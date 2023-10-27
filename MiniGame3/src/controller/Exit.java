package controller;

import mini3.gameExceptions.*;

/**
 * Class: Exit
 * @author Rick Price
 * @version 1.3
 * Course: ITEC 3860
 * Written: September 15, 2023
 * 
 * This class – contains the Exit information. Allows the user to build an exit to be added to the Room
 */
public class Exit {

	private String direction;
	private int roomID;
	private int destination;
	private final java.util.List<String> VALID_DIRECTIONS = Arrays.asList(new String[] {"WEST", "NORTH", "SOUTH", "EAST", "UP", "DOWN"});

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getRoomID() {
		return this.roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getDestination() {
		return this.destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		// TODO - implement Exit.toString
		throw new UnsupportedOperationException();
	}

	/**
	 * Method buildExit
	 * Builds an Exit from the String provided
	 * throws an exception for an invalid exit
	 * You can replace this with a constructor that takes a String and parses into the Exit.
	 * @param ex - String containing the information for the exit
	 */
	public void buildExit(String ex) throws GameException {
		// TODO - implement Exit.buildExit
		throw new UnsupportedOperationException();
	}

}