package mini3.controller;

import mini3.gameExceptions.GameException;
import mini3.model.ExitDB;
import mini3.model.GameDBCreate;
import mini3.model.RoomDB;

/**
 * Class: GameController
 * @author Rick Price
 * @version 1.3
 * Course: ITEC 3860
 * Written: Sep 12, 2023
 * This class – Is the UI to mini3.gameExceptions.controller interface for mini game 3
 * All user interactions will be sent to this class to be sent on for further processing.
 */
public class GameController {

	public static final int FIRST_ROOM = 1;
	private Commands commands;
	private GameDBCreate gdbc;

	/**
	 * Method GameController
	 * Constructor for the GameController class
	 * Instatiates the Commands object for the game
	 */
	public GameController() {
		this.commands = new Commands();
	}

	/**
	 * Method : start
	 * Checks to see if the DB file exists and if not creates it
	 * by calling GameDBCreate buildTables().
	 */
	public void start() throws GameException {
		try{
			gdbc = new GameDBCreate();
			gdbc.buildTables();
		} catch (GameException ge){
		}

	}

	/**
	 * Method displayFirstRoom
	 * Retrieves the String for the current room. If ther player does not have a room stored, returns the first room
	 * @return - the first room display String
	 * @throws GameException - if the first room is not found.
	 */
	public String displayFirstRoom() throws GameException {
		RoomDB rdb = new RoomDB();
		Room curRoom = rdb.getRoom(commands.getPlayerRoom());
		return curRoom.display();

	}

	/**
	 * Method executeCommand
	 * Handles the user input from Adventure
	 * Sends the user's command to Commands for processing
	 * throws an exception if the command is not valid
	 * @param cmd - String
	 * @return String - the result from the command
	 * @throws GameException if the command is invalid
	 */
	public String executeCommand(String cmd) throws GameException {
		return commands.executeCommand(cmd);
	}

	/**
	 * Method printMap
	 * Handles the print map command from Adventure
	 * Builds a  String representation of the current map
	 * @return String - the String of the current map
	 * @throws GameException if one of the files is not found or has an error
	 */
	public String printMap() throws GameException {
		// TODO - implement GameController.printMap
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: getPlayerName
	 * Requests the Player name from the Commands class
	 * @return String - player name
	 */
	public String getPlayerName() {
		return commands.getPlayerName();
	}

}