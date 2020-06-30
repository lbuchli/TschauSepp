package ch.lukas.ts.model;


import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardDeckTest {
	
	CardDeck deck;
	
	@BeforeEach
	public void setup() {
		deck = new CardDeck();
	}

	/**
	 * UTC001
	 */
	@Test
	public void playInvalidCard() {
		deck.playCard(new Card(CardValue.NINE, CardColor.CLOVER));
		assertEquals(false, deck.playCard(new Card(CardValue.KING, CardColor.HEARTS)));
	}
	
	/**
	 * UTC002
	 */
	@Test
	public void playCardColorMatching() {
		deck.playCard(new Card(CardValue.NINE, CardColor.CLOVER));
		assertEquals(true, deck.playCard(new Card(CardValue.KING, CardColor.CLOVER)));
	}
	
	/**
	 * UTC003
	 */
	@Test
	public void playCardValueMatching() {
		deck.playCard(new Card(CardValue.NINE, CardColor.CLOVER));
		assertEquals(true, deck.playCard(new Card(CardValue.NINE, CardColor.HEARTS)));
	}
	
	/**
	 * UTC012
	 */
	@Test
	public void deckGetsReshuffledWhenUsedUp() {
		List<Card> handCards = new ArrayList<>();
		for (int i = 0; i <= 120; i++) {
			Card pickedUp = deck.pickUpCard();
			if (pickedUp == null) {
				fail("Picked up card was null");
			}
			handCards.add(pickedUp);
			handCards.removeIf(card -> deck.playCard(card)); // play all playable cards
		}
	}
}
