package mini3.model;

import mini3.gameExceptions.GameException;
import mini3.controller.Item;
import mini3.controller.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class: ItemDB
 * @author Rick Price
 * @version 1.0
 * Course: ITEC 3860
 * Written: September 20, 2022
 * This class – Item Database class for mini game 3.
 * This allows the other classes to request these items.
 */
public class ItemDB {

	/**
	 * ItemDB constructor
	 */
	public ItemDB() throws GameException {
	}

	/**
	 * Method getItem
	 * Returns the Item requested by the ID. Only used in readRooms
	 * @param id - the ID of the item requested.
	 * @return void
	 * @throws GameException if the item ID cannot be found
	 */
	public Item getItem(int id) throws GameException {
		Item item;
		try{
			SQLiteDB db = new SQLiteDB();
			String statement = "SELECT * FROM Item where itemID = " + id;
			ResultSet rs = db.queryDB(statement);
			if (rs.next()){
				item = new Item(
						rs.getInt("itemID"),
						rs.getString("itemName"),
						rs.getString("itemDescription")
				);
			} else {
				throw new SQLException("Item " + id + " was not found");
			}
			db.close();
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Item id " + id + " was not found");
		}
		return item;
	}

}