package mini3.model;

import mini3.gameExceptions.GameException;
import mini3.controller.*;

/**
 * Class: PlayerDB
 * @author Rick Price
 * @version 1.2
 * Course: ITEC 3860
 * Written: Oct 23, 2023
 * This class – tracks the Player interacts with the Player table to maintain the Player status.
 * For this example, only tracks player name and id.
 */
public class PlayerDB {

	private SQLiteDB sdb = null;

	/**
	 * Method: updatePlayer
	 * This method updates the player passed to it
	 * @param player
	 */
	public void update(Player player) throws GameException {
		// TODO - implement PlayerDB.update
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: getPlayer
	 * This method gets the player from the DB
	 * @param id - the player ID
	 * @return Player - the player object from the DB
	 * @throws GameException
	 */
	public Player getPlayer(int id) throws GameException {
		// TODO - implement PlayerDB.getPlayer
		throw new UnsupportedOperationException();
	}

}