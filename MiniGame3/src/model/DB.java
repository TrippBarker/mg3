package model;

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
		// TODO - implement DB.queryDB
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: updateDB
	 * Purpose: Updates the database
	 * @param SQL
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean updateDB(String SQL) throws java.sql.SQLException {
		// TODO - implement DB.updateDB
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: count
	 * Purpose: Gets the count of records in the specified table
	 * @param table
	 * @return int
	 */
	public int count(String table) {
		// TODO - implement DB.count
		throw new UnsupportedOperationException();
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
		// TODO - implement DB.close
		throw new UnsupportedOperationException();
	}

}