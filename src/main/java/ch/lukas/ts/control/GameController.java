package ch.lukas.ts.control;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import ch.lukas.ts.model.Player;
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
	
	/**
	 * Update a scoreboard when players get points
	 * @param scoreboard The scoreboard to update
	 */
	public static void updateScoreboard(DefaultListModel<String> scoreboard) {
		List<Player> players = new ArrayList<>(TschauSepp.getInstance().getCurrentGame().getPlayers());
		TschauSepp.getInstance().getCurrentGame().addPlayerChangeListener(p -> {
			scoreboard.clear();
			players.sort((a, b) -> new Integer(a.getScore()).compareTo(b.getScore())*-1);
			for (int i = 0; i < players.size(); i++) {
				String text = String.format("[%d] %s", i+1, getPlayerInfo(players.get(i)));
				scoreboard.addElement(text);
			}
		});
	}
	
	private static String getPlayerInfo(Player p) {
		int number = TschauSepp.getInstance().getCurrentGame().getPlayerNumber(p);
		int score = p.getScore();
		return String.format("Player %d (%d Pte.)", number, score);
	}
}
