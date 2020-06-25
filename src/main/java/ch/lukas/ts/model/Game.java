package ch.lukas.ts.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private final static int HAND_CARDS = 7;
	
	private CardDeck deck;
	private List<PlayerChangeListener> playerChangeListeners;
	private List<Player> players;
	
	private boolean isTschauChecked;
	private boolean isSeppChecked;
	private boolean hasPlayedOrPickedUp;
	
	private int currentPlayer = 0;
	
	public Game() {
		playerChangeListeners = new ArrayList<>();
		players = new ArrayList<>();
		deck = new CardDeck();
		
		int playerCount = Settings.getInstance().getPlayerCount();
		for (int i = 0; i < playerCount; i++) {
			Player player = new Player(deck);
			for (int j = 0; j < HAND_CARDS; j++) {
				player.pickUpCard();
			}
			players.add(new Player(deck));
		}
	}
	
	public void cancel() {
		// TODO
	}
	
	public void addPlayerChangeListener(PlayerChangeListener listener) {
		playerChangeListeners.add(listener);
		listener.onPlayerChange(players.get(currentPlayer));
	}
	
	public void nextPlayer() {
		if (hasPlayedOrPickedUp) {
			currentPlayer = (currentPlayer + 1) % Settings.getInstance().getPlayerCount();
			Player nextPlayer = players.get(currentPlayer);
			playerChangeListeners.forEach((listener) -> listener.onPlayerChange(nextPlayer));
			isTschauChecked = false;
			isSeppChecked = false;
			hasPlayedOrPickedUp = false;
		}
	}
	
	public void toggleTschau() {
		// this is kind of ugly because the two states (isTschauChecked and checkbox) could
		// get out of sync. It is still the most elegant solution using swing as far as I know,
		// because it's not easily possible to get the checkbox state from its ActionEvent.
		// I really love swing.
		isTschauChecked = !isTschauChecked;
	}
	
	public void toggleSepp() {
		isSeppChecked = !isSeppChecked;
	}
	
	public Player getCurrentPlayer() {
		return players.get(currentPlayer);
	}
	
	public int getPlayerNumber(Player p) {
		return players.indexOf(p) + 1;
	}
	
	public void setHasPlayedOrPickedUp(boolean val) {
		hasPlayedOrPickedUp = val;
	}
	
	public CardDeck getDeck() {
		return deck;
	}
}
