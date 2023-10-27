package model;

import mini3.controller.*;
import mini3.gameExceptions.*;

/**
 * Class: ItemRoomDB
 * @author Rick Price
 * @version 1.0
 * Course: ITEC 3860
 * Written: September 20, 2022
 * This class – tracks the items and the room they are in. Since we can have many items in a room,
 * we must use an association table.
 */
public class ItemRoomDB {

	/**
	 * Method: getRoomItems
	 * This method gets the items that are in the room.
	 * @param roomID
	 * @return ArrayList<Item>
	 * @throws GameException
	 */
	protected java.util.ArrayList<Item> getRoomItems(int roomID) throws GameException {
		// TODO - implement ItemRoomDB.getRoomItems
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: removeItem
	 * This item removes an item from the room.
	 * @param item
	 */
	public void removeItem(Item item) throws GameException {
		// TODO - implement ItemRoomDB.removeItem
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: addItem
	 * This method adds an item to the room.
	 * @param item
	 * @param roomId
	 */
	public void addItem(Item item, int roomId) throws GameException {
		// TODO - implement ItemRoomDB.addItem
		throw new UnsupportedOperationException();
	}

}