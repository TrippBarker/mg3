package view;

import mini3.controller.*;

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

	private java.util.Scanner input;
	private GameController gc;

	/**
	 * Method Adventure
	 * Constructor for the Adventure class
	 * Creates an instance of the GameController class which is the interface into the controller package
	 */
	public Adventure() {
		// TODO - implement Adventure.Adventure
		throw new UnsupportedOperationException();
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
	private void playGame() {
		// TODO - implement Adventure.playGame
		throw new UnsupportedOperationException();
	}

	/**
	 * Method getCommand
	 * Prompts the user for their input and returns this to playGame
	 * @return String - the command entered by the user.
	 */
	private String getCommand() {
		// TODO - implement Adventure.getCommand
		throw new UnsupportedOperationException();
	}

	/**
	 * Method main
	 * Starts the game, initializes the Scanner, calls playGame and then closes the Scanner
	 * If the data file is not found, prints a message and exits.
	 * If the data file is found and successfully loaded, prints the map by calling the
	 * GameController printMap method and printing the String that methods returns.
	 * @param args - String[]
	 */
	public static void main(String[] args) {
		// TODO - implement Adventure.main
		throw new UnsupportedOperationException();
	}

}