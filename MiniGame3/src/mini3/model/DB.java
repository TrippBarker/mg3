package mini3.model;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.sql.*;
/**
 * Class : DB.java
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860
 * Written: September 12, 2022
 * This class controls basic DB functionality
 * Purpose:Has Query and Update DB
 */
public abstract class DB {

	protected String dbName = "src/mini3/Mini3.db";
	protected String sJdbc;
	protected String sDriverName;
	protected java.sql.Connection conn;
	protected String sDbUrl;
	protected int timeout = 5;

	/**
	 * Method: queryDB
	 * Purpose: read from the database
	 * @param sql
	 * @return ResultSet
	 * @throws SQLException
	 */
	public java.sql.ResultSet queryDB(String sql) throws java.sql.SQLException {
		ResultSet rs = null;
		Statement stmt = conn.createStatement();
		stmt.setQueryTimeout(timeout);
		rs = stmt.executeQuery(sql);
		return rs;
	}

	/**
	 * Method: updateDB
	 * Purpose: Updates the database
	 * @param SQL
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean updateDB(String SQL) throws java.sql.SQLException {
		Statement stmt = conn.createStatement();
        return stmt.execute(SQL);
	}

	/**
	 * Method: count
	 * Purpose: Gets the count of records in the specified table
	 * @param table
	 * @return int
	 */
	public int count(String table) {
		int cnt = 0;
		try{
			Statement stmt = conn.createStatement();
			String sql = "SELECT count(*) AS count FROM \""+table+"\";";
			ResultSet rs = stmt.executeQuery(sql);
			cnt = rs.getInt(1);
		} catch (SQLException sqe){
			System.out.println(sqe.getMessage());
		}
		return cnt;
	}

	/**
	 * Method: getMaxValue
	 * Purpose: Gets max value for a particular field in a particular table
	 * @param columnName
	 * @param table
	 * @return int
	 */
	public int getMaxValue(String columnName, String table) {
		// TODO - implement DB.getMaxValue
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: close
	 * Purpose: Close the database connection
	 */
	public void close() throws java.sql.SQLException {
		conn.close();
	}

}