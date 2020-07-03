package ch.lukas.ts.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

/**
 * A player that participates in a game.
 * @author lukas
 */
public class Player extends DefaultListModel<Card> {
	
	private static final long serialVersionUID = 6132068650994968305L;
	
	private List<Card> handCards;
	private CardDeck deck;
	private int score;
	private boolean hasPlayedOrPickedUp;
	private boolean hasPlayed;
	
	public Player(CardDeck deck) {
		handCards = new ArrayList<Card>();
		this.deck = deck;
		score = 0;
		hasPlayedOrPickedUp = false;
	}
	
	/**
	 * Pick up a card from the spare cards
	 */
	public void pickUpCard() {
		if (!hasPlayedOrPickedUp) {
			addElement(deck.pickUpCard());
			setHasPlayedOrPickedUp(true);
		}
	}
	
	/**
	 * Play a hand card
	 * @param index The hand card's index
	 * @return Wheter it was possible to play that card
	 */
	public boolean playCard(int index) {
		if (index < handCards.size() 
				&& !hasPlayedOrPickedUp
				&& deck.playCard(handCards.get(index))) {
			
			Card played = handCards.remove(index);
			fireIntervalRemoved(this, index, index);
			
			if (!played.getValue().equals(CardValue.ACE)
					|| !Settings.getInstance().isSpecial(CardValue.ACE)) {
				setHasPlayedOrPickedUp(true);
				setHasPlayed(true);
			}
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * End a round. Clears the hand cards and adds points
	 * @param points The amount of points this player gained from the round
	 */
	public void endRound(int points) {
		int handCardSize = handCards.size();
		handCards.clear();
		fireIntervalRemoved(this, 0, handCardSize);
		score = getScore() + points;
	}
	
	/**
	 * Calculates this player's hand card score
	 * @return The score
	 */
	public int calcHandScore() {
		return handCards.parallelStream()
				.mapToInt((c) -> c.getValue().getPoints())
				.sum();
	}
	
	public List<Card> getHandCards() {
		return handCards;
	}

	public int getScore() {
		return score;
	}

	@Override
	public Card getElementAt(int index) {
		return handCards.get(index);
	}

	@Override
	public int getSize() {
		return handCards.size();
	}
	
	@Override
	public void addElement(Card card) {
		handCards.add(card);
		int addedIndex = handCards.size() - 1;
		fireIntervalAdded(this, addedIndex, addedIndex);
	}
	
	@Override
	public boolean removeElement(Object card) {
		boolean found = handCards.remove(card);
		if (found) {
			fireContentsChanged(this, 0, handCards.size());
		}
		return found;
	}

	public boolean getHasPlayedOrPickedUp() {
		return hasPlayedOrPickedUp;
	}

	public void setHasPlayedOrPickedUp(boolean hasPlayedOrPickedUp) {
		this.hasPlayedOrPickedUp = hasPlayedOrPickedUp;
	}

	public boolean getHasPlayed() {
		return hasPlayed;
	}

	public void setHasPlayed(boolean hasPlayed) {
		this.hasPlayed = hasPlayed;
	}
}
