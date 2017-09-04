/**
 * 
 */
package com.work.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.work.web.exception.ServiceException;
import org.work.web.util.PropertyReader;


/**
 * @作者 ThinkPad
 * @创建日期 Sep 23, 2010
 * @版本 work V1.0
 */
public class DButils {
	private static final Log log = LogFactory.getLog(DButils.class); 
	private static final String DB_DRIVER = "com.ibm.db2.jcc.DB2Driver";
    private static String url = null; 
    private static String username = null; 
    private static String password = null; 
    private static Properties props = new Properties(); 

	static{
		try {
			Class.forName(DB_DRIVER);
			Properties properties= PropertyReader.getProperties("/config/report.properties");
			url=properties.get("jdbc.url").toString();
			username=properties.get("jdbc.username").toString();
			password=properties.get("jdbc.password").toString();
		} catch (Exception e) {
			System.out.println("Get DB Connection Error!");
		}
	}
    /** 
     * 创建一个数据库连接 
     * 
     * @return 一个数据库连接 
     */ 
    public static Connection getConnection() { 
            Connection conn = null; 
            //创建数据库连接 
            try { 
                    conn = DriverManager.getConnection(url, username, password); 
            } catch (SQLException e) { 
                    log.error("#ERROR# :创建数据库连接发生异常，请检查！", e); 
            } 
            return conn; 
    } 
    /** 
     * 在一个数据库连接上执行一个静态SQL语句查询 
     * 
     * @param conn            数据库连接 
     * @param staticSql 静态SQL语句字符串 
     * @return 返回查询结果集ResultSet对象 
     */ 
    public static ResultSet executeQuery(Connection conn, String staticSql) { 
            ResultSet rs = null; 
            try { 
                    //创建执行SQL的对象 
                    Statement stmt = conn.createStatement(); 
                    //执行SQL，并获取返回结果 
                    rs = stmt.executeQuery(staticSql); 
            } catch (SQLException e) { 
                    log.error("#ERROR# :执行SQL语句出错，请检查！\n" + staticSql, e); 
            } 
            return rs; 
    } 

    /** 
     * 在一个数据库连接上执行一个静态SQL语句 
     * 
     * @param conn            数据库连接 
     * @param staticSql 静态SQL语句字符串 
     */ 
    public static void executeSQL(Connection conn, String staticSql) { 
            try { 
                    //创建执行SQL的对象 
                    Statement stmt = conn.createStatement(); 
                    //执行SQL，并获取返回结果 
                    stmt.execute(staticSql); 
            } catch (SQLException e) { 
                    log.error("#ERROR# :执行SQL语句出错，请检查！\n" + staticSql, e); 
                    throw new ServiceException("数据中有数据长度太长，请修改");
            } 
    } 

    /** 
     * 在一个数据库连接上执行一批静态SQL语句 
     * 
     * @param conn        数据库连接 
     * @param sqlList 静态SQL语句字符串集合 
     */ 
    public static void executeBatchSQL(Connection conn, List<String> sqlList) { 
            try { 
                    //创建执行SQL的对象 
                    Statement stmt = conn.createStatement(); 
                    for (String sql : sqlList) { 
                            stmt.addBatch(sql); 
                    } 
                    //执行SQL，并获取返回结果 
                    stmt.executeBatch(); 
            } catch (SQLException e) { 
                    log.error("#ERROR# :执行批量SQL语句出错，请检查！", e); 
            } 
    } 

    public static void closeConnection(Connection conn) { 
        if (conn == null) return; 
        try { 
                if (!conn.isClosed()) { 
                        //关闭数据库连接 
                        conn.close(); 
                } 
        } catch (SQLException e) { 
                log.error("#ERROR# :关闭数据库连接发生异常，请检查！", e); 
        } 
} 

}
