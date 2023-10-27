package mini3.model;

import mini3.gameExceptions.GameException;
import mini3.controller.Exit;
import mini3.controller.*;

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
		// TODO - implement ExitDB.getExits
		throw new UnsupportedOperationException();
	}

}