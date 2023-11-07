package mini3.gameExceptions;

import java.io.*;

/**
 * Class: GameException
 * @author Rick Price
 * @version 1.2
 * Course: ITEC 3860 Fall
 * Written: Sep 12, 2022
 * 
 * This class – is the custom exception for the game.
 */
public class GameException extends IOException {

	public GameException() {
		super("An unexpected error occurred.");
	}

	/**
	 * 
	 * @param message
	 */
	public GameException(String message) {
		super(message);
	}

}