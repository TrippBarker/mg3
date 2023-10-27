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
	public Room(int id) throws GameException {
		// TODO - implement Room.Room
		throw new UnsupportedOperationException();
	}

	/**
	 * Method display
	 * Builds a String representation of the current room
	 * Calls buildItems, buildDescription, and displayExits to build this String
	 * @return String - the current room display String
	 * @throws GameException if the Item String cannot be built
	 */
	public String display() throws GameException {
		// TODO - implement Room.display
		throw new UnsupportedOperationException();
	}

	/**
	 * Method buildDescription
	 * Builds a String of the description
	 * @return String - the current room description text
	 */
	private String buildDescription() {
		// TODO - implement Room.buildDescription
		throw new UnsupportedOperationException();
	}

	/**
	 * Method buildItems
	 * Builds a String of the items in the room
	 * @return String - the current room items text
	 * @throws GameException if an error retrieving items
	 */
	private String buildItems() throws GameException {
		// TODO - implement Room.buildItems
		throw new UnsupportedOperationException();
	}

	/**
	 * Method removeItem
	 * Removes an item from the room. Removes it and calls updateRoom to save the changes
	 * @param item - the Item to remove
	 */
	public void removeItem(Item item) throws GameException {
		// TODO - implement Room.removeItem
		throw new UnsupportedOperationException();
	}

	/**
	 * Method dropItem
	 * Adds an item from the room. Adds it and calls updateRoom to save the changes
	 * @param item - the Item to add
	 */
	public void dropItem(Item item) throws GameException {
		// TODO - implement Room.dropItem
		throw new UnsupportedOperationException();
	}

	/**
	 * Method updateRoom
	 * Calls RoomDB updateRoom(this) to save the current room in the map
	 */
	public void updateRoom() throws GameException {
		// TODO - implement Room.updateRoom
		throw new UnsupportedOperationException();
	}

	/**
	 * Method displayExits
	 * Builds a String of the exits in the room
	 * @return String - the current room exits text
	 */
	private String displayExits() {
		// TODO - implement Room.displayExits
		throw new UnsupportedOperationException();
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
		// TODO - implement Room.validDirection
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: getRoomItems
	 * This method calls RoomDB to get the items that are in the current room.
	 * @return ArrayList Item - the items in the room
	 * @throws GameException if the list of items cannot be built
	 */
	public java.util.ArrayList<Item> getRoomItems() throws GameException {
		// TODO - implement Room.getRoomItems
		throw new UnsupportedOperationException();
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