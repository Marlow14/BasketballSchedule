package com.games_schedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
	
	static final String JBDC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	
	public static final ArrayList<GameInfo> myGameList =  new ArrayList<>();
	
	public static void connectToDB(){
		
		try {
			Class.forName(JBDC_Driver);
			
			System.out.println("Attempting to connect to the Database...");
			CONN = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			System.out.println("Connected to the Database");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error!!! Could not connect to the Database!");
			e.printStackTrace();
		}
		
	}//connectToDB
	
	public static void readFromDB(){
		
		connectToDB();
		
		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM game_schedule.games;");
			
			while(RES_SET.next()){
				
				GameInfo games = new GameInfo();
				
				games.setGameNumber(RES_SET.getString("game_number"));
				games.setGameLevel(RES_SET.getString("level_of_game"));
				games.setGameLocation(RES_SET.getString("game_location"));
				games.setDate(RES_SET.getString("date"));
				games.setTime(RES_SET.getString("time"));
				games.setHomeTeam(RES_SET.getString("home_team"));
				games.setAwayTeam(RES_SET.getString("away_team"));
				games.setHomeTeamScore(RES_SET.getString("home_team_score"));
				games.setAwayTeamScore(RES_SET.getString("away_team_score"));
				games.setGameWinner(RES_SET.getString("game_winner"));
				
				myGameList.add(games);
				
			}
				for (GameInfo game : myGameList) {
					System.out.println(game);					
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//readFromDB
	
	private static String insertIntoTable = "INSERT INTO `game_schedule`.`games`" +
						"(`level_of_game`, `game_location`, " +
						"`date`, `time`, `home_team`, `away_team`, " + 
						"`home_team_score`, `away_team_score`, `game_winner`)" +
						" VALUES " +
						"(?, ?, ?, ?, ?, ?, ?, ?, ?);";

	public static void insertToDB(GameInfo game){
		
		
		try {
			connectToDB();
			
			PREP_STMT = CONN.prepareStatement(insertIntoTable);
			
			PREP_STMT.setString(1, game.getGameLevel());
			PREP_STMT.setString(2, game.getGameLocation());
			PREP_STMT.setString(3, game.getDate());
			PREP_STMT.setString(4, game.getTime());
			PREP_STMT.setString(5, game.getHomeTeam());
			PREP_STMT.setString(6, game.getAwayTeam());
			PREP_STMT.setString(7, game.getHomeTeamScore());
			PREP_STMT.setString(8, game.getAwayTeamScore());
			PREP_STMT.setString(9, game.getGameWinner());
			
			System.out.println(PREP_STMT);
			
			PREP_STMT.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//insertToDB
	
	private static String updateDB = "";
	
	public static void updateDB (){
		
		
		
	}//updateDB
	
	private static String deleteFromDB ="";
	
	public static void deleteFromDB(){
		
		
	}//deleteFromDB
	
}//class
