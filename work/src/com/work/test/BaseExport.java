/**
 * 
 */
package com.work.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.work.web.util.PropertyReader;

/**
 * @作者 ThinkPad
 * @创建日期 Sep 15, 2010
 * @版本 work V1.0
 */
public abstract class BaseExport implements IExportReport{
	private static final String DB_DRIVER = "com.ibm.db2.jcc.DB2Driver";
	private Connection connection;
	private String pathString;
	private String yearString;
	private String quaterString;
	public String getYearString() {
		return yearString;
	}
	public void setYearString(String yearString) {
		this.yearString = yearString;
	}
	public String getQuaterString() {
		return quaterString;
	}
	public void setQuaterString(String quaterString) {
		this.quaterString = quaterString;
	}
	public String getPathString() {
		return pathString;
	}
	public void setPathString(String pathString) {
		this.pathString = pathString;
	}
	public void init(){
		try {
			Class.forName(DB_DRIVER);
			Properties properties= PropertyReader.getProperties("/config/report.properties");
			this.connection = DriverManager.getConnection(properties.get("jdbc.url").toString(), properties.get("jdbc.username").toString(), properties.get("jdbc.password").toString());
		} catch (Exception e) {
			System.out.println("Get DB Connection Error!");
		}
	}
	public void close(){
		try {
			this.connection.close();
		} catch (Exception e) {
			System.out.println("Close DB Connection Error!");
		}

	}
	public Connection getConnection(){
		return this.connection;
	}
}
