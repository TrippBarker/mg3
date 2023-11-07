package mini3.model;

import mini3.gameExceptions.GameException;
import mini3.controller.*;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		try{
			SQLiteDB db = new SQLiteDB();
			String statement = "UPDATE Player SET curRoom = " + player.getCurRoom() + " WHERE playerID = " + player.getPlayerID() + ";";
			db.updateDB(statement);
			db.close();
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Player id " + player.getPlayerID() + " was not updated.");
		}
	}

	/**
	 * Method: getPlayer
	 * This method gets the player from the DB
	 * @param id - the player ID
	 * @return Player - the player object from the DB
	 * @throws GameException
	 */
	public Player getPlayer(int id) throws GameException {
		Player player;
		try{
			SQLiteDB db = new SQLiteDB();
			String statement = "SELECT * FROM Player WHERE PlayerID = " + id;
			ResultSet rs = db.queryDB(statement);
			if(rs.next()){
				player = new Player(
						rs.getInt("playerID"),
						rs.getString("playerName"),
						rs.getInt("curRoom")
				);
			} else {
				throw new SQLException("Player id " + id + " was not found");
			}
			db.close();
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Player id " + id + " was not found.");
		}
		return player;

	}

}