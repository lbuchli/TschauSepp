package ch.lukas.ts.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A deck of cards, containing all the spare and spent cards.
 * @author lukas
 */
public class CardDeck {
	
	private final static int SHUFFLE_ITERATIONS = 512;
	
	private List<Card> spareCards;
	private List<Card> spentCards;
	private List<CardDeckListener> listeners;
	
	public CardDeck() {
		spareCards = new ArrayList<Card>();
		spentCards = new ArrayList<Card>();
		listeners = new ArrayList<CardDeckListener>();
		reshuffle();
	}
	
	/**
	 * Play a card if possible.
	 * @param card The card to play
	 * @return True if the card was playable and played
	 */
	public boolean playCard(Card card) {
		if (!cardPlayable(card)) {
			return false;
		}
		spentCards.add(card);
		listeners.forEach((listener) -> listener.onCardPlay(card)); // notify listeners
		return true;
	}
	
	/**
	 * Pick up a card
	 * @return The card that was picked up.
	 */
	public Card pickUpCard() {
		if (spareCards.size() == 0) {
			spareCards.addAll(spentCards.subList(0, spentCards.size()-2));
			Card lastCard = spentCards.get(spentCards.size()-1);
			spentCards.clear();
			spentCards.add(lastCard);
		}
		
		Card card = spareCards.remove(spareCards.size()-1);
		listeners.forEach((listener) -> listener.onCardPickup(card)); // notify listeners
		return card;
	}
	
	public void reshuffle() {
		// generate cards
		spentCards.clear();
		spareCards.clear();
		for (CardColor color : CardColor.values()) {
			for (CardValue value : CardValue.values()) {
				// we use two decks of cards
				spareCards.add(new Card(value, color));
				spareCards.add(new Card(value, color));
			}
		}
		
		
		shuffleSpare();
	}
	
	public Card getLastPlayedCard() {
		if (spentCards.size() == 0) {
			return null;
		}
		
		return spentCards.get(spentCards.size()-1);
	}
	
	public void addListener(CardDeckListener listener) {
		listeners.add(listener);
	}
	
	private boolean cardPlayable(Card card) {
		if (spentCards.size() > 0) {
			Card lastCard = spareCards.get(spareCards.size()-1);
			
			if (card.getColor().equals(lastCard.getColor()) 
				|| card.getValue().equals(lastCard.getValue())) {
				
				return true;
			} else {
				return false;
			}
		}
		return true;
	}
	
	private void shuffleSpare() {
		Random rnd = new Random();
		for (int i = 0; i < SHUFFLE_ITERATIONS; i++) {
			int a = rnd.nextInt(spareCards.size());
			int b = rnd.nextInt(spareCards.size());
			Card tmp = spareCards.get(a);
			spareCards.set(a, spareCards.get(b));
			spareCards.set(b, tmp);
		}
	}
}
