package mini3.model;

import mini3.gameExceptions.GameException;
import mini3.controller.Item;
import mini3.controller.Room;
import mini3.controller.*;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		Room room;
		try{
			SQLiteDB db = new SQLiteDB();
			String statement = "SELECT * FROM Room where roomID = " + roomID;
			ResultSet rs = db.queryDB(statement);
			if (rs.next()){
				boolean visited = false;
				if (rs.getInt("visited") == 1){
					visited = true;
				}
				room = new Room(
						rs.getInt("roomID"),
						rs.getString("roomName"),
						rs.getString("roomDescription"),
						visited
				);
			} else {
				throw new SQLException("Room " + roomID + " was not found");
			}
			db.close();
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Room id " + roomID + " was not found");
		}
		return room;
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
		ItemRoomDB irdb = new ItemRoomDB();
		try{
			return irdb.getRoomItems(roomID);
		} catch (GameException ge){
			throw new GameException();
		}

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
		try{
			SQLiteDB db = new SQLiteDB();
			String statement = "UPDATE Room SET visited = " + 1 + " WHERE roomID = " + rm.getRoomID();
			db.updateDB(statement);
			db.close();
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Room id " + rm.getRoomID() + " was not updated");
		}
	}

}