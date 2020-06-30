package ch.lukas.ts.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
	
	CardDeck deck;
	Player player;
	
	@BeforeEach
	public void setup() {
		deck = new CardDeck();
		player = new Player(deck);
	}
	
	/**
	 * UTC015
	 */
	@Test
	public void calcHandScoreCorrect() {
		player.addElement(new Card(CardValue.KING, CardColor.HEARTS));
		player.addElement(new Card(CardValue.NINE, CardColor.HEARTS));
		player.addElement(new Card(CardValue.THREE, CardColor.SPADES));
		player.addElement(new Card(CardValue.EIGHT, CardColor.CLOVER));
		assertEquals(30, player.calcHandScore());
	}

}
