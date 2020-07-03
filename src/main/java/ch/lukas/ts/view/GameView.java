package ch.lukas.ts.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ch.lukas.ts.model.TschauSepp;

/**
 * View of an active game, consisting of a player view and a card deck view.
 * @author lukas
 */
public class GameView extends JPanel {

	private static final long serialVersionUID = 6203069336898699210L;

	private CardDeckPanel cardDeckPanel;
	private PlayerPanel playerPanel;
	
	public GameView(CardLayout layout) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		cardDeckPanel = new CardDeckPanel();
		playerPanel = new PlayerPanel();
		
		add(cardDeckPanel, BorderLayout.NORTH);
		add(playerPanel, BorderLayout.SOUTH);
		
		SwingUtilities.invokeLater(
				() -> TschauSepp.getInstance().getCurrentGame().addGameDoneListener(
						() -> {
							layout.show(getParent(), "podium");
							layout.removeLayoutComponent(this);
						}));

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
