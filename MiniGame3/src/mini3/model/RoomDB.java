package mini3.model;

import mini3.gameExceptions.GameException;
import mini3.controller.Item;
import mini3.controller.Room;
import mini3.controller.*;

/**
 * Class: RoomDB
 * @author Rick Price
 * @version 1.0
 * Course: ITEC 3860
 * Written: September 22, 2023
 * This class – Holds the Room data for mini game 3. Contains an ArrayList Room
 * This reads information from ItemDB when retrieving a Room.
 * This allows the other classes to request these items.
 */
public class RoomDB {

	private SQLiteDB sdb = null;

	/**
	 * Method getRoom
	 * returns the Room with the ID requested
	 * If not found, throws a GameException
	 * @param roomID - the int for the room requested
	 * @return Room - the requested room
	 * @throws GameException if the roomID cannot be found
	 */
	public Room getRoom(int roomID) throws GameException {
		// TODO - implement RoomDB.getRoom
		throw new UnsupportedOperationException();
	}

	/**
	 * Method getItems
	 * Returns the list of items in a room
	 * throws an exception if the room ID is not found
	 * @param roomID - the id of the room requested
	 * @return ArrayList -  the items contained in a room
	 * @throws GameException if the roomID cannot be found
	 */
	public java.util.ArrayList<Item> getItems(int roomID) throws GameException {
		// TODO - implement RoomDB.getItems
		throw new UnsupportedOperationException();
	}

	/**
	 * Method getMap
	 * Returns the String of the complete map
	 * @return String
	 */
	public String getMap() throws GameException {
		// TODO - implement RoomDB.getMap
		throw new UnsupportedOperationException();
	}

	/**
	 * Method updateRoom
	 * Updates the room in the current map
	 * throws an exception if the room is not found
	 * @param rm - The Room that is being updated
	 */
	public void updateRoom(Room rm) throws GameException {
		// TODO - implement RoomDB.updateRoom
		throw new UnsupportedOperationException();
	}

}