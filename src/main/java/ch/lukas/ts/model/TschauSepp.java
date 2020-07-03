package ch.lukas.ts.model;

public class TschauSepp {

	private static TschauSepp instance;
	private Game currentGame;
	
	private TschauSepp() {
		//currentGame = new Game();
	}
	
	/**
	 * Get a TschauSepp instance
	 * @return The instance
	 */
	public static TschauSepp getInstance() {
		if (instance == null) {
			instance = new TschauSepp();
		}
		
		return instance;
	}
	
	/**
	 * Get the game currently played
	 * @return The game
	 */
	public Game getCurrentGame() {
		return currentGame;
	}
	
	/**
	 * Start a new game
	 */
	public void newGame() {
		currentGame = new Game();
	}
}
