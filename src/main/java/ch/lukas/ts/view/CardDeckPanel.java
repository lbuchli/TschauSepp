package ch.lukas.ts.view;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class CardDeckPanel extends JPanel {

	private static final long serialVersionUID = -420695756707545895L;
	
	private BufferedImage lastPlayedCard;
	private BufferedImage spareCard;

	public CardDeckPanel() {
		super(new BorderLayout());
		// TODO
	}
}
