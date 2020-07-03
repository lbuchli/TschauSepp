package ch.lukas.ts.model;

import java.util.ArrayList;
import java.util.List;

public class Settings {

	private static Settings instance;
	private int playerCount = 4;
	private List<CardValue> specialEnabled;
	private int finishPoints = 400;
	
	private Settings() {
		specialEnabled = new ArrayList<CardValue>();
	}
	
	/**
	 * Get a Settings instance
	 * @return The instance
	 */
	public static Settings getInstance() {
		if (instance == null) {
			instance = new Settings();
		}
		
		return instance;
	}
	
	/**
	 * Check if a CardValue is special
	 * @param value The CardValue to check
	 * @return Wheter the value is special
	 */
	public boolean isSpecial(CardValue value) {
		return specialEnabled.contains(value);
	}
	
	/**
	 * Add a CardValue to the list of special cards
	 * @param card The value to add
	 */
	public void addSpecialCard(CardValue card) {
		specialEnabled.add(card);
	}
	
	/**
	 * Remove a CardValue from the list of special cards
	 * @param card The value to remove
	 */
	public void removeSpecialCard(CardValue card) {
		specialEnabled.remove(card);
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
