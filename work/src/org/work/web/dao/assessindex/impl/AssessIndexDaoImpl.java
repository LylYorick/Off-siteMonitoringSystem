/**
 * 
 */
package org.work.web.dao.assessindex.impl;

import java.util.List;
import java.util.Map;

import org.work.web.dao.assessindex.IAssessIndexDao;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.po.AssessIndex;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class AssessIndexDaoImpl extends BaseDaoHibernateImpl implements IAssessIndexDao {

	@Override
	public Class getModelClass() {
		return AssessIndex.class;
	}
	
	public List getAllAssessIndex() {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from AssessIndex where ascfiled like 'a%' order by acsid asc");
		return getList(helper);
	}
	
	public PaginaterList getAllAssessIndex(Map<String, Object> params, Integer page) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from AssessIndex order by acsid asc");
		if (params != null) {
		}
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":" order by "+(String)params.get("order"));
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":(String)params.get("sord"));
		return getPaginaterList(helper,page);
	}

	public List findByPid(Integer pid) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from AssessIndex");
		if(pid!=null){
			helper.append(" where ascpid = ?",pid);
		}
		helper.append(" order by acsid asc");
		return getList(helper);
	}

	public List getAllAssessIndexInAssess(Map<String, Object> params) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("select a.acsid,a.ascproject,a.ascdesc,a.ascremark,ass.selevalscore,ass.score,ass.remark,a.ascpid,ass.selevalremark from AssessIndex a left join a.assesses ass " );
		if (params != null) {
			helper.append("with 1 = 1");
			helper.append("and ass.BOrgInformation.oid = ?",params.get("oid"));
			helper.append("and ass.year = ?",params.get("year"));
			
			if(params.get("selfevalflag")!=null){
				helper.append(" where a.ascfiled like ?",params.get("selfevalflag")+"%");
			}
		}
		helper.append(" order by a.acsid asc");
		return getList(helper);
	}

	public List getAllAssessIndex(Map<String, Object> params) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("select a.acsid,a.ascproject,a.ascdesc,a.ascremark,a.ascadd,a.asccut,ass.score,ass.remark,a.ascpid,a.ascfiled,ass.selevalscore,ass.selevalremark from AssessIndex a left join a.assesses ass " );
		if (params != null) {
			helper.append("with 1 = 1");
			helper.append("and ass.BOrgInformation.oid = ?",params.get("oid"));
			helper.append("and ass.year = ?",params.get("year"));
			
			if(params.get("selfevalflag")!=null){
				helper.append(" where a.ascfiled like ?",params.get("selfevalflag")+"%");
			}
		}
		helper.append(" order by a.acsid asc");
		return getList(helper);
	}
	/**added by liuxz at 2017-02-24*/
	public List getAllAssessIndex2(Map<String, Object> params) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("select a.acsid,a.ascproject,a.ascdesc,a.ascremark,a.ascadd,a.asccut,ass.selevalscore,ass.selevalremark,a.ascpid,a.ascfiled,ass.score,ass.remark from AssessIndex a left join a.assesses ass " );
		if (params != null) {
			helper.append("with 1 = 1");
			helper.append("and ass.BOrgInformation.oid = ?",params.get("oid"));
			helper.append("and ass.year = ?",params.get("year"));
		}
		helper.append("where a.ascfiled like ?","b%");
		helper.append(" order by a.acsid asc");
		return getList(helper);
	}

	/**added by liuxz at 2017-02-28*/
	public List getAllAssessIndex2() {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from AssessIndex where ascfiled like 'b%' order by acsid asc");
		return getList(helper);
	}

	/**added by liuxz at 2017-03-01*/
	public List findByPid2(Integer pid, String ascfield) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from AssessIndex where 1=1");
		if(pid!=null){
			helper.append(" and ascpid = ?",pid);
		}
		if(ascfield!=null){
			helper.append(" and ascfiled like ?","%"+ascfield+"%");
		}
		helper.append(" order by acsid asc");
		return getList(helper);
	}

	
}
