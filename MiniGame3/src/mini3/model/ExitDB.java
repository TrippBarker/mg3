package mini3.model;

import mini3.gameExceptions.GameException;
import mini3.controller.Exit;
import mini3.controller.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class: ExitDB
 * @author Rick Price
 * @version 1.1
 * Course: ITEC 3860
 * Written: September 20, 2023
 * This class – handles the Exit interaction with the DB. This class uses a buried association to
 * allow the exit to be assigned to a room. An Exit can only be in one room so we don't have to use an
 * association table.
 */
public class ExitDB {

	private SQLiteDB sdb = null;

	/**
	 * 
	 * @param roomID
	 */
	public java.util.ArrayList<Exit> getExits(int roomID) throws GameException {
		ArrayList<Exit> exitsAL = new ArrayList<>();
		Exit exit;
		try{
			SQLiteDB db = new SQLiteDB();
			String statement = "SELECT * FROM Exit where roomID = " + roomID;
			ResultSet rs = db.queryDB(statement);
			while (rs.next()){
				exit = new Exit(
						rs.getString("direction"),
						rs.getInt("roomID"),
						rs.getInt("destination")
				);
				exitsAL.add(exit);
			}
			db.close();
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Exit could not be found for " + roomID);
		}
		return exitsAL;
	}

}