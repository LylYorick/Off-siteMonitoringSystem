package com.work.tools;

import java.util.ArrayList;

/**
 * 
 */

/**
 * @作者 aps-dux
 * @创建日期
 * @版本 深圳V1.0
 */
public class GenInsertScript {
	String table = "";
	String dbtype = "";
	ArrayList name = new ArrayList();
	ArrayList value = new ArrayList();
	
	public GenInsertScript()
	{
	}
	
	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}

	public GenInsertScript(String table)
	{
		this.table = table;
	}
	
	public void setTableName(String table)
	{
		this.table = table;
	}
	
	public void add(String sFieldName,Object sFieldValue)
	{
		if(sFieldValue instanceof Integer || sFieldValue instanceof Double){
			name.add(sFieldName);
			value.add(sFieldValue);		
			}else {
				name.add(sFieldName);
				value.add("'" + sFieldValue + "'");	
				} 

	}
	
	public String getInsertSql()
	{
		StringBuffer sb = new StringBuffer();
		//表名
		sb.append("insert into " + table + "(");
		
		//字段名
		for ( int i = 0 ; i < this.name.size() ; i++ )
		{
			if ( i != 0 )
				sb.append(",");
			sb.append(this.name.get(i));
		}
		
		//值
		sb.append(") values (");
		for ( int i = 0 ; i < this.value.size() ; i++ )
		{
			if ( i != 0 )
				sb.append(",");
			sb.append(this.value.get(i));
		}
		
		sb.append(")");

		return sb.toString();
	}
}
