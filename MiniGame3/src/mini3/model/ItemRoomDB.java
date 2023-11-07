package mini3.model;

import mini3.gameExceptions.GameException;
import mini3.controller.Item;
import mini3.controller.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		ItemDB idb = new ItemDB();
		ArrayList<Item> roomItems = new ArrayList<>();
		try{
			SQLiteDB db = new SQLiteDB();
			String statement = "SELECT * FROM ItemRoom where roomID = " + roomID;
			ResultSet rs = db.queryDB(statement);
			while(rs.next()){
				roomItems.add(
						idb.getItem(rs.getInt("itemID"))
				);
			}
			db.close();
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Cannot find item in roomID " + roomID);
		}
		return roomItems;
	}

	/**
	 * Method: removeItem
	 * This item removes an item from the room.
	 * @param item
	 */
	public void removeItem(Item item) throws GameException {
		try{
			SQLiteDB db = new SQLiteDB();
			String statement = "DELETE FROM ItemRoom WHERE itemID = " + item.getItemID() + ";";
			db.updateDB(statement);
			db.close();
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Could not remove item from room");
		}
	}

	/**
	 * Method: addItem
	 * This method adds an item to the room.
	 * @param item
	 * @param roomID
	 */
	public void addItem(Item item, int roomID) throws GameException {
		try{
			SQLiteDB db = new SQLiteDB();
			String statement = "INSERT INTO ItemRoom VALUES(" + item.getItemID() + ", " + roomID + ");";
			db.updateDB(statement);
			db.close();
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Could not add item to room.");
		}
	}

}