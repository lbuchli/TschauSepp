package ch.lukas.ts.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A game (A round until one player reaches max points)
 * @author lukas
 */
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
	
	/**
	 * Cancel/finish the game
	 */
	public void cancel() {
		gameDoneListeners.forEach(listener -> listener.onGameDone());
	}
	
	/**
	 * Add a PlayerChaneListener to get notified on player changes
	 * @param listener The listener
	 */
	public void addPlayerChangeListener(PlayerChangeListener listener) {
		playerChangeListeners.add(listener);
		listener.onPlayerChange(players.get(currentPlayer));
	}
	
	/**
	 * Add a GameDoneListener to get notified when the game is done
	 * @param listener The listener
	 */
	public void addGameDoneListener(GameDoneListener listener) {
		gameDoneListeners.add(listener);
	}
	
	/**
	 * Add a PlayerHadToPickedUpListener to get notified when a player had to pick up
	 * @param listener The listener
	 */
	public void addPlayerHadToPickUpListener(PlayerHadToPickUpListener listener) {
		playerHadToPickUpListeners.add(listener);
	}
	
	/**
	 * Go to the next player. Checks if the current player can finish their move first
	 */
	public void nextPlayer() {
		Player current = players.get(currentPlayer);
		if (current.getHasPlayedOrPickedUp()) {
			checkTschauAndSepp(current);
			if (current.getHandCards().size() == 0) {
				endRound();
				currentPlayer = 0;
			} else {
				int step = 1;
				Card lastPlayedCard = deck.getLastPlayedCard();
				
				if (lastPlayedCard != null) {
					CardValue lastPlayedValue = lastPlayedCard.getValue();
					
					if (current.getHasPlayed()) {
						if (lastPlayedValue.equals(CardValue.EIGHT)
								&& Settings.getInstance().isSpecial(CardValue.EIGHT)) {
							step = 2;
						}
						
						if (lastPlayedValue.equals(CardValue.TEN)
								&& Settings.getInstance().isSpecial(CardValue.TEN)) {
							isDirectionReversed = !isDirectionReversed;
						}
					}
					
					if (lastPlayedValue.equals(CardValue.SEVEN)
							&& Settings.getInstance().isSpecial(CardValue.SEVEN)
							&& current.getHasPlayed()) {
						sevenStackSize += 1;
					} else {
						for (int i = 0; i < sevenStackSize*2; i++) {
							current.pickUpCard();
							current.setHasPlayedOrPickedUp(false);
						}
						sevenStackSize = 0;
					}
				}
				
				if (isDirectionReversed) {
					step *= -1;
				}
				
				currentPlayer = (currentPlayer + step) % Settings.getInstance().getPlayerCount();
				if (currentPlayer < 0) {
					currentPlayer += Settings.getInstance().getPlayerCount();
				}
			}

			current.setHasPlayedOrPickedUp(false);
			current.setHasPlayed(false);
			
			Player nextPlayer = players.get(currentPlayer);
			playerChangeListeners.forEach((listener) -> listener.onPlayerChange(nextPlayer));
			isTschauChecked = false;
			isSeppChecked = false;
		}
	}
	
	/**
	 * Toggle wheter 'Tschau' is activated for the current player
	 */
	public void toggleTschau() {
		isTschauChecked = !isTschauChecked;
	}
	
	/**
	 * Toggle wheter 'Sepp' is activated for the current player
	 */
	public void toggleSepp() {
		isSeppChecked = !isSeppChecked;
	}
	
	/**
	 * Get the current player
	 * @return The current player
	 */
	public Player getCurrentPlayer() {
		return players.get(currentPlayer);
	}
	
	/**
	 * Get the player number of a player in human-readable format
	 * @param p The player
	 * @return The player's number
	 */
	public int getPlayerNumber(Player p) {
		return players.indexOf(p) + 1;
	}
	
	/**
	 * Get the active card deck
	 * @return The card deck
	 */
	public CardDeck getDeck() {
		return deck;
	}
	
	/**
	 * Get a list of all players participating in this game
	 * @return The list
	 */
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
