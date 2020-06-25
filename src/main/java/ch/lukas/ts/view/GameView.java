package ch.lukas.ts.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import ch.lukas.ts.control.GameController;
import ch.lukas.ts.control.PlayerController;

public class GameView extends JPanel {

	private static final long serialVersionUID = 6203069336898699210L;

	private GameController controller;
	private CardDeckPanel cardDeckPanel;
	private PlayerPanel playerPanel;
	
	public GameView() {
		setLayout(new BorderLayout());
		controller = new GameController();
		
		cardDeckPanel = new CardDeckPanel();
		playerPanel = new PlayerPanel();
		
		add(cardDeckPanel, BorderLayout.NORTH);
		add(playerPanel, BorderLayout.SOUTH);
	}
}
