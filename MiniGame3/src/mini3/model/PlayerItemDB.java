package mini3.model;

import mini3.gameExceptions.GameException;
import mini3.controller.Item;
import mini3.controller.*;

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
		// TODO - implement PlayerItemDB.addItemToInventory
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: removeItemFromInventory
	 * THis method removes an item from the player's inventory
	 * @param item
	 */
	public void removeItemFromInventory(Item item) throws GameException {
		// TODO - implement PlayerItemDB.removeItemFromInventory
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: getInventory
	 * This method gets the player's inventory
	 * @param playerID
	 * @return ArrayList<Item> - items
	 * @throws GameException
	 */
	public java.util.ArrayList<Item> getInventory(int playerID) throws GameException {
		// TODO - implement PlayerItemDB.getInventory
		throw new UnsupportedOperationException();
	}

}