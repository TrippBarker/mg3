package mini3.controller;

import mini3.gameExceptions.GameException;
import mini3.model.PlayerDB;
import mini3.model.PlayerItemDB;

import java.util.ArrayList;

/**
 * Class: Player
 * @author Rick Price
 * @version 1.3
 * Course: ITEC 3860
 * Written: Oct 23, 2023
 * 
 * This class – handles the Player object. This is concerned with tracking inventory and current room
 * for this implementation. Also contains code to update the player to persist the current player.
 */
public class Player {

	private int curRoom;
	private String name;
	private int playerID;

	public int getCurRoom() {
		return this.curRoom;
	}

	public void setCurRoom(int curRoom) {
		this.curRoom = curRoom;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerID() {
		return this.playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	/**
	 * Method Player
	 * Constructor for the Player class
	 * Creates a new player and sets that player's ID to the first room
	 */
	public Player(int playerID, String name, int curRoom) {
		this.playerID = playerID;
		this.name = name;
		this.curRoom = curRoom;
	}

	/**
	 * 
	 * @param id
	 */
	public Player getPlayer(int id) throws GameException {
		// TODO - implement Player.getPlayer
		throw new UnsupportedOperationException();
	}

	/**
	 * Method addItem
	 * Adds an item to the player's inventory
	 * @param it - the Item to add to the inventory
	 */
	protected void addItem(Item it) throws GameException {
		PlayerItemDB pidb = new PlayerItemDB();
		pidb.addItemToInventory(this.playerID, it);
	}

	/**
	 * Method removeItem
	 * Removes an item from the player's inventory
	 * @param it - the Item to remove from the inventory
	 */
	protected void removeItem(Item it) throws GameException {
		PlayerItemDB pidb = new PlayerItemDB();
		pidb.removeItemFromInventory(this.playerID, it);
	}

	/**
	 * Method printInventory
	 * Returns the String of all items in the player's inventory
	 * @return String - the String of the player's inventory
	 */
	protected String printInventory() throws GameException {
		PlayerItemDB pidb = new PlayerItemDB();
		ArrayList<Item> playerInventory = pidb.getInventory(this.playerID);
		StringBuilder inventoryStr = new StringBuilder();
		for (Item item : playerInventory){
			inventoryStr.append(item.getItemDescription() + "\n");
		}
		return inventoryStr.toString();
	}

	/**
	 * Method getInventory
	 * @return the ArrayList of the current Items in the player's inventory
	 */
	protected java.util.ArrayList<Item> getInventory() throws GameException {
		PlayerItemDB pidb = new PlayerItemDB();
		return pidb.getInventory(this.playerID);
	}

	/**
	 * Method updatePlayer
	 * Calls PlayerDB to update changes to the current player.
	 */
	public void updatePlayer() throws GameException {
		PlayerDB pdb = new PlayerDB();
		pdb.update(this);
	}

}