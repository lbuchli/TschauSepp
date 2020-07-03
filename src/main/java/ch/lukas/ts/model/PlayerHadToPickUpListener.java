package ch.lukas.ts.model;

/**
 * A listener to be notified when a player has to pick up
 * @author lukas
 */
@FunctionalInterface
public interface PlayerHadToPickUpListener {
	
	/**
	 * Gets called when a player had to pick up
	 * @param amount The amount of cards they had to pick up
	 */
	public void onPlayerHadToPickUp(int amount);
}
