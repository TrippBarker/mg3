package mini3.model;

import mini3.gameExceptions.GameException;
import mini3.controller.Item;
import mini3.controller.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class: PlayerItemDB
 * @author Rick Price
 * @version 1.1
 * Course: ITEC 3860
 * Written: October 7, 2022
 * This class – tracks the Player inventory.
 */
public class PlayerItemDB {

	private SQLiteDB sdb = null;

	/**
	 * Method: addItemToInventory
	 * This method adds the selected item to their inventory
	 * @param playerID
	 * @param item
	 */
	public void addItemToInventory(int playerID, Item item) throws GameException {
		try{
			SQLiteDB db = new SQLiteDB();
			String statement = "INSERT INTO PlayerItem VALUES(" + playerID + ", " +item.getItemID() + ");";
			db.updateDB(statement);
			db.close();
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Could not add item to player inventory.");
		}
	}

	/**
	 * Method: removeItemFromInventory
	 * THis method removes an item from the player's inventory
	 * @param item
	 */
	public void removeItemFromInventory(int playerID, Item item) throws GameException {
		try{
			SQLiteDB db = new SQLiteDB();
			String statement = "DELETE FROM PlayerItem WHERE itemID = " + item.getItemID() + " AND playerID = " + playerID + ";";
			db.updateDB(statement);
			db.close();
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Could not remove item from inventory.");
		}
	}

	/**
	 * Method: getInventory
	 * This method gets the player's inventory
	 * @param playerID
	 * @return ArrayList<Item> - items
	 * @throws GameException
	 */
	public java.util.ArrayList<Item> getInventory(int playerID) throws GameException {
		ArrayList<Item> playerInventory = new ArrayList<>();
		ItemDB idb = new ItemDB();
		try{
			SQLiteDB db = new SQLiteDB();
			String statement = "SELECT * FROM PlayerItem WHERE playerID = " + playerID + ";";
			ResultSet rs = db.queryDB(statement);
			while (rs.next()){
				playerInventory.add(idb.getItem(rs.getInt("itemID")));
			}
			db.close();
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Player inventory could not be retrieved.");
		}
		return playerInventory;
	}

}