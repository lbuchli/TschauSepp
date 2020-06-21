package ch.lukas.ts.model;

import java.util.ArrayList;
import java.util.List;

public class Settings {

	private static Settings instance;
	private int playerCount = 4;
	private List<CardValue> specialEnabled;
	private int finishPoints = 200;
	
	private Settings() {
		specialEnabled = new ArrayList<CardValue>();
	}
	
	public static Settings getInstance() {
		if (instance == null) {
			instance = new Settings();
		}
		
		return instance;
	}
	
	public boolean isSpecial(CardValue value) {
		return specialEnabled.contains(value);
	}
	
	public void addSpecialCard(CardValue card) {
		specialEnabled.add(card);
	}
	
	public int getPlayerCount() {
		return playerCount;
	}
	
	public int getFinishPoints() {
		return finishPoints;
	}
	
	public void setPlayerCount(int count) {
		playerCount = count;
	}
	
	public void setFinishPoints(int points) {
		finishPoints = points;
	}
}
