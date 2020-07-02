package ch.lukas.ts.control;

import java.awt.event.ActionListener;

import ch.lukas.ts.model.TschauSepp;

/**
 * Controller for the game GUI view
 * @author lukas
 */
public class GameController {

	/**
	 * If a game has to get cancelled or quit, this listener quits
	 * the game
	 * @return The listener
	 */
	public ActionListener getCancelListener() {
		return (e) -> TschauSepp.getInstance().getCurrentGame().cancel();
	}
}
