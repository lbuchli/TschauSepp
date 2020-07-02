package ch.lukas.ts.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

public class Player extends DefaultListModel<Card> {
	
	private static final long serialVersionUID = 6132068650994968305L;
	
	private List<Card> handCards;
	private CardDeck deck;
	private int score;
	private boolean hasPlayedOrPickedUp;
	
	public Player(CardDeck deck) {
		handCards = new ArrayList<Card>();
		this.deck = deck;
		score = 0;
		hasPlayedOrPickedUp = false;
	}
	
	public void pickUpCard() {
		if (!hasPlayedOrPickedUp) {
			addElement(deck.pickUpCard());
			setHasPlayedOrPickedUp(true);
		}
	}
	
	public boolean playCard(int index) {
		if (index < handCards.size() 
				&& !hasPlayedOrPickedUp
				&& deck.playCard(handCards.get(index))) {
			
			Card previous = deck.getLastPlayedCard();
			Card played = handCards.remove(index);
			fireIntervalRemoved(this, index, index);
			
			if (!played.getValue().equals(CardValue.ACE)
					|| !Settings.getInstance().isSpecial(CardValue.ACE)) {
				setHasPlayedOrPickedUp(true);
			}
			
			return true;
		}
		
		return false;
	}
	
	public void endRound(int points) {
		int handCardSize = handCards.size();
		handCards.clear();
		fireIntervalRemoved(this, 0, handCardSize);
		score = getScore() + points;
	}
	
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
}
