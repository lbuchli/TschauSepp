package ch.lukas.ts.model;

/**
 * A listener that reacts to card deck events.
 * @author lukas
 */
public interface CardDeckListener {
	
	/**
	 * Gets called when a player picks up a card
	 * @param card The card the player picked up
	 */
	public void onCardPickup(Card card);
	
	/**
	 * Gets called when a player plays a card
	 * @param card the card the player played
	 */
	public void onCardPlay(Card card);
}
