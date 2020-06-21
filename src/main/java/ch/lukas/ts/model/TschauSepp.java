package ch.lukas.ts.model;

public class TschauSepp {

	private static TschauSepp instance;
	private Game currentGame;
	
	private TschauSepp() {
		currentGame = new Game();
	}
	
	public static TschauSepp getInstance() {
		if (instance == null) {
			instance = new TschauSepp();
		}
		
		return instance;
	}
	
	public Game getCurrentGame() {
		return currentGame;
	}
}
