package mini3.controller;

import mini3.gameExceptions.GameException;
import mini3.model.ItemDB;
import mini3.model.ItemRoomDB;
import mini3.model.PlayerDB;
import mini3.model.RoomDB;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class: Commands
 * @author Rick Price
 * @version 1.3
 * Course: ITEC 3860
 * Written: Oct 23, 2023
 * 
 * This class – Handles commands from the user. The command is parsed, type of command determined and
 * then routed to correct methods to handle the command.
 */
class Commands {

	protected static final java.util.List<String> VALID_DIRECTIONS = Arrays.asList("W", "WEST", "N", "NORTH", "S", "SOUTH", "E", "EAST", "U", "UP", "D", "DOWN");
	protected static final java.util.List<String> ITEM_COMMANDS = Arrays.asList("I", "INSPECT", "R", "REMOVE", "G", "GET");
	public static final int EXIT_COMMAND = 5;
	private Player player;

	/**
	 * Method Commands
	 * Constructor for the Commands class
	 * Instantiates a new player object for tracking inventory in the game
	 */
	Commands() {
		PlayerDB pdb = new PlayerDB();
		try {
			this.player = pdb.getPlayer(1);
		} catch (GameException ge){
			System.out.println(ge.getMessage());
		}
	}

	/**
	 * Method: addPlayer
	 * Retrieves the name from the database and sets it into the Player object.
	 */
	protected void addPlayer() {
		// TODO - implement Commands.addPlayer
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: setPlayer
	 * Sets the player object for the current player.
	 * @param player
	 */
	protected void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Method validateCommand
	 * returns an int that tells what type of command.
	 * 1 for movement (N, S, E, W, U, D)
	 * 2 for item commands (G, R, I)
	 * 3 for Look (L)
	 * 4 for Backpack (B)
	 * EXIT_COMMAND for exit (X)
	 * throws an exception for an invalid command
	 * @param cmdLine - String containing the command entered by the user
	 * @return int - the integer for the command received. If not recognized, returns 0 for an invalid command
	 * @throws GameException
	 */
	private int validateCommand(String cmdLine) throws GameException {
		String cmd = cmdLine.split(" ")[0];
		if (cmd.equals("X") || cmd.equals("EXIT")){
			return EXIT_COMMAND;
		} else if (VALID_DIRECTIONS.contains(cmd)) {
			return 1;
		} else if (ITEM_COMMANDS.contains(cmd)){
			return 2;
		} else if (cmd.equals("L") || cmd.equals("LOOK")) {
			return 3;
		} else if (cmd.equals("B") || cmd.equals("BACKPACK")){
			return 4;
		} else {
			throw new GameException(cmdLine + " is not a valid command.");
		}
	}

	/**
	 * Method executeCommand
	 * returns the String to be displayed to the user based on the user's command
	 * Calls the correct command method or returns the String for the command entered.
	 * throws an exception for an invalid command
	 * @param cmd - String that contains the command entered by the user
	 * @return String - the response to the command
	 * @throws GameException
	 */
	protected String executeCommand(String cmd) throws GameException {
		int commandType = 0;
		try{
			commandType = validateCommand(cmd);
		} catch (GameException ge){
			return ge.getMessage();
		}
		String retString = "";
		switch (commandType){
			case 1:
				retString = move(cmd);
				break;
			case 2:
				retString = itemCommand(cmd);
				break;
			case 3:
				RoomDB rdb = new RoomDB();
				retString = rdb.getRoom(getPlayerRoom()).display();
				break;
			case 4:
				retString = player.printInventory();
				break;
			case 5:
				retString = "Thank you for playing my game.";
				break;
		}
		return retString;
	}

	/**
	 * Method move
	 * returns the String for the new Room the user is entering
	 * Calls Room validDirection to ensure that the direction is valid for this room.
	 * If the direction is valid,
	 * Updates the room to be visited by updating the room
	 * Updates the current Room in Player
	 * If the direction is not valid,
	 * throws an exception for an invalid direction
	 * @param cmdRoom - String that contains the command entered by the user
	 * @return String - the new room the user is moving to
	 * @throws GameException
	 */
	private String move(String cmdRoom) throws GameException {
		try{
			RoomDB rdb = new RoomDB();
			Room curRoom = rdb.getRoom(player.getCurRoom());
			Room nextRoom = rdb.getRoom(curRoom.validDirection(cmdRoom.charAt(0)));
			curRoom.setVisited(true);
			curRoom.updateRoom();
			player.setCurRoom(nextRoom.getRoomID());
			player.updatePlayer();
			return nextRoom.display();
		} catch (GameException ge){
			return ge.getMessage();
		}
	}

	/**
	 * Method itemCommand
	 * returns the String for the Item based on the user's command
	 * Calls different methods to handle the Item interactions
	 * throws an exception for an invalid command or action,
	 * For example, item not in the room and the user tries to pick it up
	 * @param cmd - String that contains the command entered by the user
	 * @return String - the response to the user's command
	 * @throws GameException
	 */
	private String itemCommand(String cmd) throws GameException {
		RoomDB rdb = new RoomDB();
		String itemCmd = cmd.split(" ")[0];
		if(itemCmd.equals("GET") || itemCmd.equals("G")){
			return get(cmd, rdb.getRoom(player.getCurRoom()));
		} else if (itemCmd.equals("REMOVE") || itemCmd.equals("R")){
			return remove(cmd, rdb.getRoom(getPlayerRoom()));
		} else if (itemCmd.equals("INSPECT") || itemCmd.equals("I")){
			return lookItem(cmd, rdb.getRoom(player.getCurRoom()));
		}
		throw new GameException("Bad item interaction encountered.");
	}

	/**
	 * Method get
	 * returns the String for the item to be added to the Player's inventory
	 * Updates the room to remove the item from the room
	 * Updates Player to add item to the backpack
	 * throws an exception if the item is not in the room
	 * @param cmd - String that contains the command entered by the user
	 * @param room
	 * @return String - item has been added to inventory
	 * @throws GameException
	 */
	private String get(String cmd, Room room) throws GameException {
		try{
			ArrayList<Item> roomItems = room.getRoomItems();
			for (Item item : roomItems){
				if(cmd.toUpperCase().contains(item.getItemName().toUpperCase())){
					room.removeItem(item);
					player.addItem(item);
					return item.getItemName() + " has been added to your inventory.";
				}
			}
		} catch (GameException ge){
			throw new GameException(ge.getMessage());
		}
		return "That item does not appear to be in this room.";
	}

	/**
	 * Method remove
	 * returns the String for dropping the item
	 * Updates the room to add the item to the room
	 * Updates the Player by removing the item from the backpack
	 * throws an exception for if Item is not in the inventory
	 * @param cmd - String that contains the command entered by the user
	 * @param room - the current Room from mini3.gameExceptions.view.Adventure
	 * @return String - the Item has been dropped
	 * @throws GameException
	 */
	private String remove(String cmd, Room room) throws GameException {
		try{
			ArrayList<Item> playerInventory = player.getInventory();
			for (Item item : playerInventory){
				if (cmd.toUpperCase().contains(item.getItemName().toUpperCase())){
					player.removeItem(item);
					room.dropItem(item);
					return item.getItemName() + " has been dropped.";
				}
			}
		} catch (GameException ge){
			throw new GameException(ge.getMessage());
		}
		return "Player does not appear to have that item in their inventory.";
	}

	/**
	 * Method lookItem
	 * returns the String of the item or an "I don't see " the item message
	 * @param cmd - String that contains the command entered by the user
	 * @param room - the current Room from mini3.gameExceptions.view.Adventure
	 * @return String - the String for the look command
	 * @throws GameException
	 */
	private String lookItem(String cmd, Room room) throws GameException {

		for (Item item : room.getRoomItems()){
			if (cmd.toUpperCase().contains(item.getItemName().toUpperCase())){
				return item.getItemDescription();
			}
		}
		return "I don't see that item here.";
	}

	/**
	 * Method: getPlayerName
	 * This method returns the player's name. Gets this from the Player object
	 * @return String player name.
	 */
	protected String getPlayerName() {
		return player.getName();
	}

	protected int getPlayerRoom(){
		return player.getCurRoom();
	}

}