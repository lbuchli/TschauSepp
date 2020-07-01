package ch.lukas.ts.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import ch.lukas.ts.control.PlayerController;
import ch.lukas.ts.model.Card;
import ch.lukas.ts.model.TschauSepp;

public class PlayerPanel extends JPanel {

	private static final long serialVersionUID = 5885829937259432735L;
	
	private PlayerController controller;
	private JList<Card> handCards;
	
	public PlayerPanel() {
		setLayout(new BorderLayout());
		controller = new PlayerController();
		
		handCards = new JList<Card>();
		handCards.addMouseListener(controller.getCardChooseListener());
		handCards.setCellRenderer(new CardListCellRenderer());
		handCards.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		handCards.setVisibleRowCount(-1);
		
		JLabel playerName = new JLabel("<Unknown>");
		
		JCheckBox tschauBox = new JCheckBox("Tschau");
		JCheckBox seppBox = new JCheckBox("Sepp");
		JButton doneButton = new JButton("Fertig");
		
		tschauBox.addActionListener(controller.getTschauListener());
		seppBox.addActionListener(controller.getSeppListener());
		doneButton.addActionListener(controller.getFinishMoveListener());
		
		TschauSepp.getInstance().getCurrentGame().addPlayerChangeListener(player -> {
			handCards.setModel(player);
			
			String name = String.valueOf(TschauSepp.getInstance().getCurrentGame().getPlayerNumber(player));
			playerName.setText("Player " + name);
			
			tschauBox.setSelected(false);
			seppBox.setSelected(false);
		});
		
		JPanel top = new JPanel();
		top.add(playerName);
		top.add(tschauBox);
		top.add(seppBox);
		top.add(doneButton);
		
		add(top, BorderLayout.NORTH);
		add(handCards, BorderLayout.SOUTH);
	}
}
