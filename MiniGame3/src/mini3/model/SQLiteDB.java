package mini3.model;

import javax.sql.rowset.JdbcRowSet;
import java.sql.DriverManager;

/**
 * Class: SQLiteDB
 * @author Rick Price
 * @version 1.0
 * Course: ITEC 3860
 * Written: Sep 12, 2022
 * This class – creates the wrapper around SQLite specific initializations.
 */
public class SQLiteDB extends DB {

	/**
	 * Constructor: SQLiteDB
	 */
	public SQLiteDB() throws java.sql.SQLException, ClassNotFoundException {
		sJdbc = "jdbc:sqlite";
		sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		sDbUrl = sJdbc + ":" + dbName;
		conn = DriverManager.getConnection(sDbUrl);
	}

	/**
	 * Constructor: SQLiteDB
	 * @param dbName
	 */
	public SQLiteDB(String dbName) throws java.sql.SQLException, ClassNotFoundException {
		sJdbc = "jdbc:sqlite";
		sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		sDbUrl = sJdbc + ":" + dbName;
		this.dbName = dbName;
		conn = DriverManager.getConnection(sDbUrl);
	}

}