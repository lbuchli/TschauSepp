package ch.lukas.ts.model;

/**
 * A listener to get notified when the player changes
 * @author lukas
 */
@FunctionalInterface
public interface PlayerChangeListener {
	
	/**
	 * Gets called when the player changes
	 * @param nextPlayer The player after the current one
	 */
	public void onPlayerChange(Player nextPlayer);
}
