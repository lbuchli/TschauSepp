package ch.lukas.ts.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;

import ch.lukas.ts.model.Player;
import ch.lukas.ts.model.TschauSepp;

public class DeckController {

	public MouseListener getCardPickupListener() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				TschauSepp.getInstance().getCurrentGame().getCurrentPlayer().pickUpCard();
				// TODO move finished
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}
		};
	}
	
	public void updateScoreboard(DefaultListModel<String> scoreboard) {
		List<Player> players = TschauSepp.getInstance().getCurrentGame().getPlayers();
		TschauSepp.getInstance().getCurrentGame().addPlayerChangeListener(p -> {
			scoreboard.clear();
			players.sort((a, b) -> new Integer(a.getScore()).compareTo(b.getScore())*-1);
			for (int i = 0; i < players.size(); i++) {
				String text = String.format("[%d] %s", i+1, getPlayerInfo(players.get(i)));
				scoreboard.addElement(text);
			}
		});
	}
	
	private String getPlayerInfo(Player p) {
		int number = TschauSepp.getInstance().getCurrentGame().getPlayerNumber(p);
		int score = p.getScore();
		return String.format("Player %d (%d Pte.)", number, score);
	}
}
