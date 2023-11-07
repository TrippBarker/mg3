package mini3.view;

import mini3.controller.GameController;
import mini3.controller.*;
import mini3.gameExceptions.GameException;
import mini3.model.GameDBCreate;

import java.util.Scanner;

/**
 * Class: Adventure
 * @author Rick Price
 * @version 1.2
 * Course: ITEC 3860
 * Written: Sep 12, 2022
 * 
 * This class – is the UI class for Mini Game 3. This class will control all user aspects
 * of these games.
 */
public class Adventure {

	private Scanner input;
	private GameController gc = new GameController();
	private String introMsg = "Welcome to my adventure game. You will proceed through rooms based upon your entries.\n" +
			"You can navigate by using the entire direction or just the first letter.\n" +
			"You can view a room by using the 'Look' command.\n" +
			"To exit(X) the game, enter X.\n";


	/**
	 * Method Adventure
	 * Constructor for the Adventure class
	 * Creates an instance of the GameController class which is the interface into the mini3.gameExceptions.controller package
	 */
	public Adventure() {
		this.gc = new GameController();
	}

	/**
	 * Method playGame
	 * Allows the player to play the game.
	 * Prints an introduction message
	 * Loops until the user chooses to exit.
	 * Prints the current rooms display text if the direction is valid.
	 * If an invalid direction is entered, catches the exception and prints the message in that exception.
	 * Calls getCommand to get users input.
	 * Passes the user's command to Commands, executeCommand for processing. This will handle move, item, look,
	 * and backpack commands.
	 */
	private void playGame() throws GameException {
		gc.start();
		System.out.println(introMsg);
		String gcRet = "";
		String userInput = "";
		System.out.println(gc.displayFirstRoom());
		do{
			userInput = getCommand();
			gcRet = gc.executeCommand(userInput);
			System.out.println(gcRet);
		}while(!gcRet.equals("Thank you for playing my game."));
	}

	/**
	 * Method getCommand
	 * Prompts the user for their input and returns this to playGame
	 * @return String - the command entered by the user.
	 */
	private String getCommand() {
		System.out.println(gc.getPlayerName() + ", what would you like to do?");
		return input.nextLine().toUpperCase();
	}

	/**
	 * Method main
	 * Starts the game, initializes the Scanner, calls playGame and then closes the Scanner
	 * If the data file is not found, prints a message and exits.
	 * If the data file is found and successfully loaded, prints the map by calling the
	 * GameController printMap method and printing the String that methods returns.
	 * @param args - String[]
	 */
	public static void main(String[] args) throws GameException{
		Adventure adv = new Adventure();
		adv.input = new Scanner(System.in);
		adv.playGame();
		adv.input.close();
	}

}