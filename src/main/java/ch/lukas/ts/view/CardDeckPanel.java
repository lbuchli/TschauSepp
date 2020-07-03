package ch.lukas.ts.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ch.lukas.ts.control.DeckController;
import ch.lukas.ts.control.GameController;
import ch.lukas.ts.model.Card;
import ch.lukas.ts.model.CardDeckListener;
import ch.lukas.ts.model.TschauSepp;

/**
 * The panel containing the played and spare cards.
 * @author lukas
 */
public class CardDeckPanel extends JPanel {

	private static final long serialVersionUID = -420695756707545895L;
	
	private JLabel lastPlayedCard;
	private JLabel spareCard;
	private DeckController controller;

	public CardDeckPanel() {
		this.controller = new DeckController();
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setBackground(Color.WHITE);
		try {
			InputStream backStream = getClass()
					.getClassLoader()
					.getResourceAsStream(Card.getBackFileName());
			spareCard = new JLabel(new ImageIcon(ImageIO.read(backStream)));
			backStream.close();
			InputStream placeholderStream = getClass()
					.getClassLoader()
					.getResourceAsStream(Card.getPlaceholderFileName());
			lastPlayedCard = new JLabel(new ImageIcon(ImageIO.read(placeholderStream)));
			placeholderStream.close();
			
			spareCard.addMouseListener(controller.getCardPickupListener());
			
			add(spareCard, BorderLayout.CENTER);
			add(lastPlayedCard, BorderLayout.WEST);
		} catch (IOException e) {
			// well sh*t
		}
		
		TschauSepp.getInstance().getCurrentGame().getDeck().addListener(new CardDeckListener() {

			@Override
			public void onCardPickup(Card card) {}

			@Override
			public void onCardPlay(Card card) {
				InputStream imageStream = getClass()
						.getClassLoader()
						.getResourceAsStream(card.getImageFileName());
				try {
					lastPlayedCard.setIcon(new ImageIcon(ImageIO.read(imageStream)));
				} catch (IOException e) {
					throw new RuntimeException("Couldn't read image file");
				}
			}
		});
		
		DefaultListModel<String> scoreboardModel = new DefaultListModel<>();
		JList<String> scoreboard = new JList<>(scoreboardModel);
		GameController.updateScoreboard(scoreboardModel);
		add(scoreboard, BorderLayout.EAST);
	}
}
