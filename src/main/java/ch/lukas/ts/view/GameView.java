package ch.lukas.ts.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ch.lukas.ts.control.GameController;
import ch.lukas.ts.control.PlayerController;
import ch.lukas.ts.model.TschauSepp;

public class GameView extends JPanel {

	private static final long serialVersionUID = 6203069336898699210L;

	private GameController controller;
	private CardDeckPanel cardDeckPanel;
	private PlayerPanel playerPanel;
	
	public GameView() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		controller = new GameController();
		
		cardDeckPanel = new CardDeckPanel();
		playerPanel = new PlayerPanel();
		
		add(cardDeckPanel, BorderLayout.NORTH);
		add(playerPanel, BorderLayout.SOUTH);

		/*
		JLabel notice = new JLabel("", JLabel.CENTER);
		notice.setFont(new Font(notice.getFont().getName(), Font.BOLD, 32));
		add(notice, BorderLayout.CENTER);
		
		SwingUtilities.invokeLater(() -> {
			TschauSepp.getInstance().getCurrentGame().addPlayerPickedUpListener(amount -> SwingUtilities.invokeLater(() -> {
				notice.setText("+" + String.valueOf(amount));
				notice.updateUI();
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				notice.setText("");
				notice.updateUI();
			}));
		});
		*/
	}
}
