package ch.lukas.ts.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import ch.lukas.ts.control.GameController;

public class GameView extends JPanel {

	private static final long serialVersionUID = 6203069336898699210L;

	private GameController controller;
	private CardDeckPanel cardDeckPanel;
	private PlayerPanel playerPanel;
	
	public GameView() {
		super(new BorderLayout());
		// TODO
	}
}
