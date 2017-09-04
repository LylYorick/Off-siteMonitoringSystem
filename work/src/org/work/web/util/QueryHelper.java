package org.work.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.type.Type;
import org.hibernate.type.TypeFactory;
import org.hibernate.util.ArrayHelper;

/**
 * hibernate 查询助手.
 * 
 * @author fred.du
 *
 */
public class QueryHelper {
	private Session session;
	
	private StringBuffer hql = new StringBuffer();
	private List params;
	private List paramTypes;
	
	public QueryHelper(Session session) {
		params = new ArrayList();
		paramTypes = new ArrayList();
		this.session = session;
	}

	public QueryHelper(){
		params = new ArrayList();
		paramTypes = new ArrayList();
		}
	
	public void append(String hql) {
		appendHql(hql);
	}

	/**
	 * 添加hql.
	 * 
	 * @param hql
	 */
	private void appendHql(String hql) {
		this.hql.append(hql + " ");
	}
	
	/**
	 * 添加参数.
	 * 
	 * @param hql
	 * @param param
	 */
	public void append(String hql, Object param) {
		if (param == null) {
			return;
		}
		
		if (param.getClass().equals(String.class)) {
			String p = (String) param;
			
			if (p.trim().length() > 0) {
				appendHql(hql);
				appendParam(param);
			}
		}
		else {
			appendHql(hql);
			appendParam(param);
		}
	}
	
	/**
	 * 添加数组参数.
	 * 
	 * @param hql
	 * @param params
	 */
	public void append(String hql, Object[] params) {
		if (params == null || params.length == 0) {
			return;
		}
		
		int length = params.length;
		String s = hql.replaceFirst("\\?", getPlaceholderString(length));
		appendHql(s);
		
		for (int i = 0; i < length; i++) {
			appendParam(params[i]);
		}
	}
	
	/**
	 * 生成占位符字符串.
	 * 
	 * @param length
	 * @return
	 */
	private String getPlaceholderString(int length) {
		String s = "";
		
		for (int i = 0; i < length; i++) {
			s += ", ?";
		}
		
		return s.substring(2);
	}

	/**
	 * 添加参数.
	 * 
	 * @param hql
	 * @param allowAppend
	 * @param param
	 */
	public void append(String hql, boolean allowAppend, Serializable param) {
		if (!allowAppend) {
			return;
		}
		
		append(hql, param);
	}
	
	/**
	 * 添加字符串模糊匹配的参数.
	 * 
	 * @param hql
	 * @param param
	 * @param matchMode
	 */
	public void append(String hql, String param, MatchMode matchMode) {
		if (param == null || param.trim().length() == 0) {
			return;
		}
		
		if (matchMode == null) {
			return;
		}
		
		String matchName = matchMode.toString();
		
		if (MatchMode.START.toString().equals(matchName)) {
			param = param + "%";
		}
		else if (MatchMode.END.toString().equals(matchName)) {
			param = "%" + param;
		}
		else if (MatchMode.ANYWHERE.toString().equals(matchName)) {
			param = "%" + param + "%";
		}
		else {
		}
		
		appendHql(hql);
		appendParam(param);
	}

	/**
	 * 添加参数.
	 * 
	 * @param param
	 */
	private void appendParam(Object param) {
		this.params.add(param);
		this.paramTypes.add(getParamType(param.getClass()));
	}

	/**
	 * 添加参数类型.
	 * 
	 * @param clazz
	 */
	private Type getParamType(Class clazz) {
		return TypeFactory.heuristicType(clazz.getName());
	}
	
	/**
	 * @param session
	 * @return
	 */
	public Query getQuery(Session session) {
		return session.createQuery(hql.toString())
				.setParameters(params.toArray(), ArrayHelper.toTypeArray(paramTypes));
	}
	
	/**
	 * 根据hql 和查询参数获取查询结果记录数.<br>
	 * <b>
	 * 	仅支持不包含order 子句, 或order 子句只出现一次且为最后一个子句的hql.
	 * 	不适用统计hql.
	 * </b>
	 * 
	 * @return
	 */
	public int getRecordCount() {
		String hql = this.hql.toString().trim();
		hql = replaceHqlHead(hql);
		hql = replaceHqlTail(hql);
		
		Long count = (Long) session.createQuery(hql)
				.setParameters(params.toArray(), ArrayHelper.toTypeArray(paramTypes))
				.uniqueResult();
		
		return count.intValue();
	}
	/**
	 * 如果是涉及到关联查询，仅限于是left join查询，返回结果集的记录总数
	 * @param hql
	 * @return
	 */
	public int getRecordCountByLeftJoin() {
		String hql = this.hql.toString().trim();
		hql = replaceHqlHead(hql);
		List list = session.createQuery(hql).setParameters(params.toArray(), ArrayHelper.toTypeArray(paramTypes)).list();
		int count = list.size();
		
		return count;
	}	
	/**
	 * @param hql
	 * @return
	 */
	private String replaceHqlTail(String hql) {
		int orderPos = this.getFirstPos(hql, "order");
		
		if (orderPos == -1) {
			return hql;
		}
		else {
			return hql.substring(0, orderPos);
		}
	}

	/**
	 * 替换hql 头为select count(*).
	 * @param hql
	 * @return
	 */
	private String replaceHqlHead(String hql) {
		String head = "select count(*) ";
		String firstWord = getFirstWord(hql);
		
		if ("from".equalsIgnoreCase(firstWord)) {
			return head + hql;
		}
		else if ("select".equalsIgnoreCase(firstWord)) {
			int pos = getFirstPos(hql, "from");
			
			if (pos == -1) {
				throw new IllegalArgumentException("hql illegal");
			}
			
			return head + hql.substring(pos);
		}
		else {
			throw new IllegalArgumentException("hql illegal");
		}
		
	}

	/**
	 * 获取第一个单词.
	 * 
	 * @param hql
	 * @return
	 */
	private String getFirstWord(String hql) {
		int firstSeparatorPos = getFirstSeparatorPos(hql);
		
		return hql.substring(0, firstSeparatorPos);
	}

	/**
	 * 获取第一个分隔符的位置.
	 * 
	 * @param hql
	 * @return
	 */
	private int getFirstSeparatorPos(String hql) {
		int firstSpacePos = hql.indexOf(" ");
		int firstTabPos = hql.indexOf("\t");
		int firstLineSeparatorPos = hql.indexOf(System.getProperty("line.separator"));
		int pos = -1;
		
		if (firstSpacePos == -1 || firstTabPos == -1) {
			pos = Math.max(firstSpacePos, firstTabPos);
		}
		else {
			pos = Math.min(firstSpacePos, firstTabPos);
		}
		
		if (firstLineSeparatorPos == -1) {
			return pos;
		}
		else {
			return Math.min(pos, firstLineSeparatorPos);
		}
	}

	/**
	 * 获取关键字第一次出现的位置.
	 * 
	 * @param keyword
	 * @return
	 */
	private int getFirstPos(String hql, String keyword) {
		String s = hql.toLowerCase();
		
		if (hql.startsWith(keyword.toLowerCase())) {
			return 0;
		}
		
		String[] padedKeywords = padSeparatorKeyword(keyword);
		
		for (int i = 0; i < padedKeywords.length; i++) {
			int pos = s.indexOf(padedKeywords[i]);
			
			if (pos > 0) {
				return pos;
			}
		}
		
		return -1;
	}

	/**
	 * 给hql 关键字加标识符.
	 * 
	 * @param keyword
	 * @return
	 */
	private String[] padSeparatorKeyword(String keyword) {
		String lineSeparator = System.getProperty("line.separator");
		
		return new String[] {
				" " + keyword + " ",
				" " + keyword + "\t",
				" " + keyword + lineSeparator,
				
				"\t" + keyword + " ",
				"\t" + keyword + "\t",
				"\t" + keyword + lineSeparator,
				
				lineSeparator + keyword + " ",
				lineSeparator + keyword + "\t",
				lineSeparator + keyword + lineSeparator
		};
	}

    public List list()
    {
        return list(session);
    }
    
	public List list(Session session) {
		return this.getQuery(session).list();
	}

    public List list(Session session, String alias, LockMode lockMode)
    {
        return getQuery(session).setLockMode(alias, lockMode).list();
    }
	
	public Object getUniqueResult(Session session) {
		return this.getQuery(session).setMaxResults(1).uniqueResult();
	}
}
