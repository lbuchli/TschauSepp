package ch.lukas.ts.model;

import java.util.List;

public class Game {
	
	private CardDeck deck;
	private List<PlayerChangeListener> playerChangeListeners;
	private List<Player> players;
	
	public Game() {
		// TODO
	}
	
	public void cancel() {
		// TODO
	}
	
	public void addPlayerChangeListener(PlayerChangeListener listener) {
		playerChangeListeners.add(listener);
	}
}
