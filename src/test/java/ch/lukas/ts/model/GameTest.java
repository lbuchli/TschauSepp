package ch.lukas.ts.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
	
	Game game;
	Player current;
	
	@BeforeEach
	public void setup() {
		game = new Game();
		current = game.getCurrentPlayer();
	}

	/**
	 * UTC004
	 */
	@Test
	public void playByPickingUp() {
		current.pickUpCard();
		game.nextPlayer();
		assertNotEquals(current, game.getCurrentPlayer());
	}
	
	/**
	 * UTC005
	 */
	@Test
	public void cannotSkipRound() {
		game.nextPlayer();
		assertEquals(current, game.getCurrentPlayer());
	}
	
	/**
	 * UTC006
	 */
	@Test
	public void pickUp2CardsWhenTschauWithMoreThan2Handcards() {
		current.addElement(new Card(CardValue.EIGHT, CardColor.SPADES));
		current.addElement(new Card(CardValue.TEN, CardColor.HEARTS));
		current.pickUpCard();
		game.toggleTschau();
		game.nextPlayer();
		int cardCount = current.getHandCards().size();
		assertEquals(5, cardCount);
	}
	
	/**
	 * UTC007
	 */
	public void pickUp4CardsWhenSeppWithMoreThan1Handcard() {
		current.addElement(new Card(CardValue.THREE, CardColor.DIAMONDS));
		current.pickUpCard();
		game.toggleSepp();
		game.nextPlayer();
		int cardCount = current.getHandCards().size();
		assertEquals(6, cardCount);
	}
	
	/**
	 * UTC008
	 */
	public void pickUpNoCardsWhenTschauCorrect() {
		current.addElement(new Card(CardValue.KING, CardColor.HEARTS));
		current.addElement(new Card(CardValue.TEN, CardColor.CLOVER));
		game.toggleTschau();
		current.playCard(0);
		game.nextPlayer();
		int cardCount = current.getHandCards().size();
		assertEquals(1, cardCount);
	}
	
	/**
	 * UTC009
	 */
	public void pickUpNoCardsWhenSeppCorrect() {
		current.addElement(new Card(CardValue.KING, CardColor.HEARTS));
		game.toggleSepp();
		current.playCard(0);
		game.nextPlayer();
		int cardCount = current.getHandCards().size();
		assertEquals(0, cardCount);
	}
	
	/**
	 * UTC010
	 */
	public void pickUp2CardsWhenTschauForgotten() {
		current.addElement(new Card(CardValue.KING, CardColor.HEARTS));
		current.addElement(new Card(CardValue.ACE, CardColor.DIAMONDS));
		current.playCard(0);
		game.nextPlayer();
		int cardCount = current.getHandCards().size();
		assertEquals(3, cardCount);
	}
	
	/**
	 * UTC011
	 */
	public void pickUp4CardsWhenSeppForgotten() {
		current.addElement(new Card(CardValue.KING, CardColor.HEARTS));
		current.playCard(0);
		game.nextPlayer();
		int cardCount = current.getHandCards().size();
		assertEquals(4, cardCount);
	}
	
	/**
	 * UTC014
	 */
	public void gameFinishedWhenMaxPointsReached() {
		// TODO
	}
}
