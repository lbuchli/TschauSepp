package ch.lukas.ts.view;

import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JPanel;

import ch.lukas.ts.control.PlayerController;
import ch.lukas.ts.model.Card;

public class PlayerPanel extends JPanel {

	private static final long serialVersionUID = 5885829937259432735L;
	
	private PlayerController controller;
	private JList<Card> handCards;
	
	public PlayerPanel() {
		super(new GroupLayout(null));
		// TODO
	}
}
