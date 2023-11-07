package mini3.model;

import mini3.gameExceptions.GameException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Class : GameDBCreate
 * 
 * @author: Rick Price
 * @version: 1.1
 * Course: ITEC 3860
 * Written: September 7, 2022
 * This class creates the Game db if it doesn't exist
 * Purpose: Creates the DB for Mini Game 3
 */
public class GameDBCreate {

	SQLiteDB sdb;

	/**
	 * Method: buildTables
	 * Purpose: Build all tables
	 */
	public void buildTables() throws GameException {
		buildRoom();
		buildItem();
		buildItemRoom();
		buildExit();
		buildPlayer();
		buildPlayerItem();
	}

	/**
	 * Method: buildRoom
	 * Purpose: Build the Room table and load data
	 */
	public void buildRoom() throws GameException {
		try{
			sdb = new SQLiteDB();
			FileReader fr;
			try{
				fr = new FileReader("src/Rooms3.txt");
				Scanner inFile = new Scanner(fr);
				String sql = "";
				while (inFile.hasNextLine()){
					sql = inFile.nextLine();
					sdb.updateDB(sql);
				}
				inFile.close();
			} catch (FileNotFoundException e){
				e.printStackTrace();
			}
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Error creating table ROOM");
		}
		finally {
			if (sdb != null){
				try{
					sdb.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Method: buildItem
	 * Purpose: Build the Item table and load data
	 */
	public void buildItem() throws GameException {
		try{
			sdb = new SQLiteDB();
			FileReader fr;
			try{
				fr = new FileReader("src/Items3.txt");
				Scanner inFile = new Scanner(fr);
				String sql = "";
				while (inFile.hasNextLine()){
					sql = inFile.nextLine();
					sdb.updateDB(sql);
				}
				inFile.close();
			} catch (FileNotFoundException e){
				e.printStackTrace();
			}
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Error creating table ITEM");
		}
		finally {
			if (sdb != null){
				try{
					sdb.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Method: buildItemRoom
	 * Purpose: Build the ItemRoom table and load data
	 */
	public void buildItemRoom() throws GameException {
		try{
			sdb = new SQLiteDB();
			FileReader fr;
			try{
				fr = new FileReader("src/ItemRoom3.txt");
				Scanner inFile = new Scanner(fr);
				String sql = "";
				while (inFile.hasNextLine()){
					sql = inFile.nextLine();
					sdb.updateDB(sql);
				}
				inFile.close();
			} catch (FileNotFoundException e){
				e.printStackTrace();
			}
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Error creating table ITEMROOM");
		}
		finally {
			if (sdb != null){
				try{
					sdb.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Method: buildExit
	 * Purpose: Build the Item table and load data
	 */
	public void buildExit() throws GameException {
		try{
			sdb = new SQLiteDB();
			FileReader fr;
			try{
				fr = new FileReader("src/Exit3.txt");
				Scanner inFile = new Scanner(fr);
				String sql = "";
				while (inFile.hasNextLine()){
					sql = inFile.nextLine();
					sdb.updateDB(sql);
				}
				inFile.close();
			} catch (FileNotFoundException e){
				e.printStackTrace();
			}
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Error creating table EXIT");
		}
		finally {
			if (sdb != null){
				try{
					sdb.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Method: buildPlayer
	 * Purpose: Builds the Player table and loads a phantom record
	 */
	public void buildPlayer() throws GameException {
		try{
			sdb = new SQLiteDB();
			String sql = "";
			sql = "CREATE TABLE Player(playerID int not Null, curRoom int not Null, playerName text not null);";
			sdb.updateDB(sql);
			sql = "INSERT INTO Player Values(1, 1, 'Fred');";
			sdb.updateDB(sql);
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Error creating table PLAYER");
		}
		finally {
			if (sdb != null){
				try{
					sdb.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Method: buildPlayerItem
	 * Purpose: Build the PlayerItem table. No data loaded since the player starts with no items
	 */
	public void buildPlayerItem() throws GameException {
		try{
			sdb = new SQLiteDB();
			String sql = "";
			sql = "CREATE TABLE PlayerItem(playerID int not Null, itemID int not Null);";
			sdb.updateDB(sql);
		} catch (SQLException | ClassNotFoundException ex){
			throw new GameException("Error creating table PLAYERITEM");
		}
		finally {
			if (sdb != null){
				try{
					sdb.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
	}

}