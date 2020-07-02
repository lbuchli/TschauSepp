package ch.lukas.ts.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private final static int HAND_CARDS = 7;
	
	private CardDeck deck;
	private List<PlayerChangeListener> playerChangeListeners;
	private List<GameDoneListener> gameDoneListeners;
	private List<PlayerHadToPickUpListener> playerHadToPickUpListeners;
	private List<Player> players;
	
	private boolean isTschauChecked;
	private boolean isSeppChecked;
	private boolean isDirectionReversed;
	
	private int sevenStackSize = 0;
	private int currentPlayer = 0;
	
	public Game() {
		playerChangeListeners = new ArrayList<>();
		gameDoneListeners = new ArrayList<>();
		playerHadToPickUpListeners = new ArrayList<>();
		players = new ArrayList<>();
		deck = new CardDeck();
		
		int playerCount = Settings.getInstance().getPlayerCount();
		for (int i = 0; i < playerCount; i++) {
			Player player = new Player(deck);
			for (int j = 0; j < HAND_CARDS; j++) {
				player.pickUpCard();
				player.setHasPlayedOrPickedUp(false);
			}
			players.add(player);
		}
	}
	
	public void cancel() {
		gameDoneListeners.forEach(listener -> listener.onGameDone());
	}
	
	public void addPlayerChangeListener(PlayerChangeListener listener) {
		playerChangeListeners.add(listener);
		listener.onPlayerChange(players.get(currentPlayer));
	}
	
	public void addGameDoneListener(GameDoneListener listener) {
		gameDoneListeners.add(listener);
	}
	
	public void addPlayerPickedUpListener(PlayerHadToPickUpListener listener) {
		playerHadToPickUpListeners.add(listener);
	}
	
	public void nextPlayer() {
		Player current = players.get(currentPlayer);
		if (current.getHasPlayedOrPickedUp()) {
			current.setHasPlayedOrPickedUp(false);
			checkTschauAndSepp(current);
			if (current.getHandCards().size() == 0) {
				endRound();
				currentPlayer = 0;
			} else {
				int step;
				CardValue lastPlayedValue = deck.getLastPlayedCard().getValue();
				if (lastPlayedValue.equals(CardValue.EIGHT)
						&& Settings.getInstance().isSpecial(CardValue.EIGHT)) {
					step = 2;
				} else {
					step = 1;
				}
				
				if (lastPlayedValue.equals(CardValue.TEN)
						&& Settings.getInstance().isSpecial(CardValue.TEN)) {
					isDirectionReversed = !isDirectionReversed;
				}
				
				if (lastPlayedValue.equals(CardValue.SEVEN)
						&& Settings.getInstance().isSpecial(CardValue.SEVEN)) {
					sevenStackSize += 1;
				} else {
					for (int i = 0; i < sevenStackSize*2; i++) {
						current.pickUpCard();
						current.setHasPlayedOrPickedUp(false);
					}
					sevenStackSize = 0;
				}
				
				if (isDirectionReversed) {
					step *= -1;
				}
				
				currentPlayer = (currentPlayer + step) % Settings.getInstance().getPlayerCount();
				if (step < 0) {
					currentPlayer += Settings.getInstance().getPlayerCount();
				}
			}
			
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
			playerHadToPickUpListeners.forEach(listener -> listener.onPlayerHadToPickUp(2));
			for (int i = 0; i < 2; i++) {
				current.pickUpCard();
				current.setHasPlayedOrPickedUp(false);
			}
		}
		if ((cardCount != 0 && isSeppChecked) || (cardCount == 0 && !isSeppChecked)) {
			playerHadToPickUpListeners.forEach(listener -> listener.onPlayerHadToPickUp(4));
			for (int i = 0; i < 4; i++) {
				current.pickUpCard();
				current.setHasPlayedOrPickedUp(false);
			}
		}
	}
	
	private void endRound() {
		Player current = players.get(currentPlayer);
		int score = players.parallelStream().mapToInt((p) -> p.calcHandScore()).sum();
		for (Player p : players) {
			if (p == current) {
				current.endRound(score);
				if (current.getScore() >= Settings.getInstance().getFinishPoints()) {
					cancel();
				}
			} else {
				p.endRound(0);
			}
		}
		deck.reshuffle();
		for (Player player : players) {
			for (int j = 0; j < HAND_CARDS; j++) {
				player.pickUpCard();
				player.setHasPlayedOrPickedUp(false);
			}
		}
	}
}
