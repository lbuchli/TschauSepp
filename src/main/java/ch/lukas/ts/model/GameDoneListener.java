package ch.lukas.ts.model;

/**
 * A listener to get notified when the game is done.
 * @author lukas
 */
@FunctionalInterface
public interface GameDoneListener {
	
	/**
	 * Gets called when the game is done
	 */
	public void onGameDone();
}
