package mini3.controller;

import java.util.*;

import mini3.gameExceptions.GameException;
import mini3.model.*;
import mini3.model.RoomDB;

/**
 * Class: Room
 * @author Rick Price
 * @version 1.2
 * Course: ITEC 3860
 * Written: Sep 12, 2023
 * This class – handles the Room interactions. This class contains the roomID, name, description
 * ArrayList Exit as well as a boolean value to determine if the user has visited the room.
 * Items are retrieved in RoomDB and not maintained in the Room.
 * Exits are retrieved in RoomDB and are maintained in the Room class for performance reasons.
 */
public class Room {

	private int roomID;
	private String name;
	private String description;
	private boolean visited;
	private Collection<Exit> exits;
	private RoomDB rdb;

	public int getRoomID() {
		return this.roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public boolean isVisited() {
		return this.visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setExits(Collection<Exit> exits) {
		this.exits = exits;
	}

	/**
	 * Method Room
	 * Constructor for the Room class
	 * Initializes exits and items ArrayLists and gets the current map.
	 */
	public Room() throws GameException {
		// TODO - implement Room.Room
		throw new UnsupportedOperationException();
	}

	/**
	 * Room constructor
	 * constructs the room object with the given ID
	 * @param id id of the room to be constructed
	 */
	public Room(int id, String roomName, String roomDesc, boolean visited) throws GameException {
		this.roomID = id;
		this.name = roomName;
		this.description = roomDesc;
		this.visited = visited;
		ExitDB edb = new ExitDB();
		setExits(edb.getExits(getRoomID()));
	}

	/**
	 * Method display
	 * Builds a String representation of the current room
	 * Calls buildItems, buildDescription, and displayExits to build this String
	 * @return String - the current room display String
	 * @throws GameException if the Item String cannot be built
	 */
	public String display() throws GameException {
		StringBuilder disStr = new StringBuilder();
		disStr.append(this.name);
		if(visited){
			disStr.append(" visited.\n");
		} else {
			disStr.append(" not visited.\n");
		}
		disStr.append(buildDescription());
		disStr.append(buildItems());
		disStr.append(displayExits());
		return disStr.toString();
	}

	/**
	 * Method buildDescription
	 * Builds a String of the description
	 * @return String - the current room description text
	 */
	private String buildDescription() {
		StringBuilder descBuilder = new StringBuilder();
		for (String str : this.description.split("\\|")){
			descBuilder.append(str + "\n");
		}
		return descBuilder.toString();
	}

	/**
	 * Method buildItems
	 * Builds a String of the items in the room
	 * @return String - the current room items text
	 * @throws GameException if an error retrieving items
	 */
	private String buildItems() throws GameException {
		StringBuilder items = new StringBuilder();
		rdb = new RoomDB();
		try{
			ArrayList<Item> roomItems = rdb.getItems(this.roomID);
			items.append("You see:\n");
			for(Item roomItem : roomItems){
				items.append(roomItem.getItemDescription() + "\n");
			}
		} catch (NullPointerException | GameException ex){
		}
		if (items.toString().equals("You see:\n")){
			return "";
		}
		return items.toString();
	}

	/**
	 * Method removeItem
	 * Removes an item from the room. Removes it and calls updateRoom to save the changes
	 * @param item - the Item to remove
	 */
	public void removeItem(Item item) throws GameException {
		ItemRoomDB irdb = new ItemRoomDB();
		irdb.removeItem(item);
	}

	/**
	 * Method dropItem
	 * Adds an item from the room. Adds it and calls updateRoom to save the changes
	 * @param item - the Item to add
	 */
	public void dropItem(Item item) throws GameException {
		ItemRoomDB irdb = new ItemRoomDB();
		irdb.addItem(item, this.roomID);
	}

	/**
	 * Method updateRoom
	 * Calls RoomDB updateRoom(this) to save the current room in the map
	 */
	public void updateRoom() throws GameException {
		RoomDB rdb = new RoomDB();
		rdb.updateRoom(this);
	}

	/**
	 * Method displayExits
	 * Builds a String of the exits in the room
	 * @return String - the current room exits text
	 */
	private String displayExits() {
		StringBuilder exitStr = new StringBuilder();
		int exitsAdded = 0;
		exitStr.append("You can go ");
		for (Exit exit : exits){
			if (exitsAdded++ > 0){
				exitStr.append(" or ");
			}
			exitStr.append(exit.getDirection());
		}
		exitStr.append(".");
		return exitStr.toString();
	}

	/**
	 * Method retrieveByID
	 * Retrieves the requested Room from RoomDB. Sets its values into the current Room and returns it
	 * @param roomNum ID of the room to retrieve
	 * @return Room - the requested Room
	 * @throws GameException if the room cannot be found
	 */
	public Room retrieveByID(int roomNum) throws GameException {
		// TODO - implement Room.retrieveByID
		throw new UnsupportedOperationException();
	}

	/**
	 * Method validDirection
	 * Determines if the direction entered by the user is valid for this room
	 * Throws an exception if this is invalid
	 * @param cmd - The direction the user wants to move
	 * @return int - the ID of the destination room
	 * @throws GameException if the direction chosen is not valid
	 */
	public int validDirection(char cmd) throws GameException {
		for (Exit exit : exits){
			if (cmd == exit.getDirection().charAt(0)){
				return exit.getDestination();
			}
		}
		throw new GameException("Invalid direction entered.");
	}

	/**
	 * Method: getRoomItems
	 * This method calls RoomDB to get the items that are in the current room.
	 * @return ArrayList Item - the items in the room
	 * @throws GameException if the list of items cannot be built
	 */
	public java.util.ArrayList<Item> getRoomItems() throws GameException {
		rdb = new RoomDB();
		return rdb.getItems(this.roomID);
	}

	/**
	 * Method setName
	 * setter for room name
	 * @param name - the name to be set
	 */
	public void setName(String name) throws GameException {
		this.name = name;
	}

	/**
	 * Method setDescription
	 * setter for room description
	 * @param description - the description to be set
	 */
	public void setDescription(String description) throws GameException {
		this.description = description;
	}

	/**
	 * Method getExits
	 * getter for the ArrayList Exit in the room
	 * @return the room exits
	 */
	public java.util.ArrayList<Exit> getExits() throws GameException {
		// TODO - implement Room.getExits
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		// TODO - implement Room.toString
		throw new UnsupportedOperationException();
	}

}