package com.games_schedule;

public class GameInfo {
	
	private String gameNumber = null;
	private String gameLevel = null;
	private String gameLocation = null;
	private String date = null;
	private String time = null;
	private String homeTeam = null;
	private String awayTeam = null;
	private String homeTeamScore = null;
	private String awayTeamScore = null;
	private String gameWinner = null;
	
	public GameInfo() {
		super();
	}

	public String getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(String gameNumber) {
		this.gameNumber = gameNumber;
	}

	public String getGameLevel() {
		return gameLevel;
	}

	public void setGameLevel(String gameLevel) {
		this.gameLevel = gameLevel;
	}

	public String getGameLocation() {
		return gameLocation;
	}

	public void setGameLocation(String gameLocation) {
		this.gameLocation = gameLocation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(String homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public String getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(String awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public String getGameWinner() {
		return gameWinner;
	}

	public void setGameWinner(String gameWinner) {
		this.gameWinner = gameWinner;
	}

	@Override
	public String toString() {
		return "GameInfo [gameNumber=" + gameNumber + ", gameLevel=" + gameLevel + ", gameLocation=" + gameLocation
				+ ", date=" + date + ", time=" + time + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam
				+ ", homeTeamScore=" + homeTeamScore + ", awayTeamScore=" + awayTeamScore + ", gameWinner=" + gameWinner
				+ "]";
	}
	
}
