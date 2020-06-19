package org.jmresler.aw.support;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * An old JDBC handler if you still use straight JDBC... :-)
 * @author johnm
 *
 */
public class JDBCUtil {
	
	/**
	 * 
	 * @param rset
	 */
	public static void close(ResultSet rset) {
		if (rset != null) {
			try { rset.close(); } catch (SQLException ignore) {}
		}
	}
	
	/**
	 * 
	 * @param statement
	 */
	public static void close(Statement statement) {
		if (statement != null) {
			try { statement.close(); } catch (SQLException ignore) {}
		}
	}
	
	/**
	 * 
	 * @param connection
	 */
	public static void close(Connection connection) {
		if (connection != null) {
			try { connection.close(); } catch (SQLException ignore) {}
		}
	}
	
	/**
	 * 
	 * @param rset
	 * @param stmt
	 * @param conn
	 */
	public static void close(ResultSet rset, Statement stmt, Connection conn) {
		close(rset);
		close(stmt);
		close(conn);
	}
}
