package ch.lukas.ts.model;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	private List<Card> spareCards;
	private List<Card> spentCards;
	private List<CardDeckListener> listeners;
	
	public CardDeck() {
		spareCards = new ArrayList<Card>();
		spentCards = new ArrayList<Card>();
		listeners = new ArrayList<CardDeckListener>();
	}
	
	public boolean playCard(Card card) {
		return true; // TODO
	}
	
	public Card pickUpCard() {
		return null; // TODO
	}
	
	public void reshuffle() {
		// TODO
	}
	
	public Card getLastPlayedCard() {
		return null; // TODO
	}
	
	public void addListener(CardDeckListener listener) {
		listeners.add(listener);
	}
}
