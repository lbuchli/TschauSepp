package ch.lukas.ts.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card> handCards;
	private CardDeck deck;
	private int score;
	
	public Player(CardDeck deck) {
		handCards = new ArrayList<Card>();
		this.deck = deck;
		score = 0;
	}
	
	public void pickUpCard(Card card) {
		handCards.add(card);
	}
	
	public Card promptMove() {
		return null; // TODO
	}
	
	public void endRound(int points) {
		// TODO
	}
	
	public int calcHandScore() {
		return 0; // TODO
	}
	
	public List<Card> getHandCards() {
		return handCards;
	}
}
