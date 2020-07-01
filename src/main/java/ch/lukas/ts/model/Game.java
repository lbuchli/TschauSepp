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
			players.add(player);
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
		Player current = players.get(currentPlayer);
		if (current.getHasPlayedOrPickedUp()) {
			checkTschauAndSepp(current);
			if (current.getHandCards().size() == 0) {
				int score = players.parallelStream().mapToInt((p) -> p.calcHandScore()).sum();
				for (Player p : players) {
					if (p == current) {
						current.endRound(score);
					} else {
						p.endRound(0);
					}
				}
				deck.reshuffle();
			}

			current.setHasPlayedOrPickedUp(false);
			currentPlayer = (currentPlayer + 1) % Settings.getInstance().getPlayerCount();
			Player nextPlayer = players.get(currentPlayer);
			playerChangeListeners.forEach((listener) -> listener.onPlayerChange(nextPlayer));
			isTschauChecked = false;
			isSeppChecked = false;
		}
	}
	
	public void toggleTschau() {
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
	
	public CardDeck getDeck() {
		return deck;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	private void checkTschauAndSepp(Player current) {
		int cardCount = current.getHandCards().size();
		if ((cardCount != 1 && isTschauChecked) || (cardCount == 1 && !isTschauChecked)) {
			for (int i = 0; i < 2; i++) {
				current.pickUpCard();
			}
		}
		if ((cardCount != 0 && isSeppChecked) || (cardCount == 0 && !isSeppChecked)) {
			for (int i = 0; i < 4; i++) {
				current.pickUpCard();
			}
		}
	}
}
