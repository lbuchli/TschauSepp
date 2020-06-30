package ch.lukas.ts.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import ch.lukas.ts.control.SettingController;
import ch.lukas.ts.model.CardValue;

public class SettingView extends JPanel {

	private static final long serialVersionUID = -1419034705199112926L;
	
	private SettingController controller;
	
	public SettingView() {
		setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Tschau Sepp");
		title.setFont(new Font(title.getFont().getName(), Font.BOLD, 64));
		add(title, BorderLayout.NORTH);
		
		GroupLayout layout = new GroupLayout(this);
		JPanel settingsPanel = new JPanel(layout);
		
		Font subtitleFont = new Font(title.getFont().getName(), Font.BOLD, 18);
		
		JLabel playerCountTitle = new JLabel("Anzahl Spieler");
		playerCountTitle.setFont(subtitleFont);
		
		JSpinner playerCountSpinner = new JSpinner();
		
		JLabel maxPointTitle = new JLabel("Maximalpunktzahl");
		maxPointTitle.setFont(subtitleFont);
		
		JSpinner maxPointSpinner = new JSpinner();
		
		JLabel specialCardsTitle = new JLabel("Sonderkarten");
		specialCardsTitle.setFont(subtitleFont);
		
		JCheckBox specialCardSeven = constructSpecialCardCheckbox(CardValue.SEVEN, "[7] 2 Karten aufnehmen");
		JCheckBox specialCardEight = constructSpecialCardCheckbox(CardValue.EIGHT, "[8] Spieler auslassen");
		JCheckBox specialCardTen   = constructSpecialCardCheckbox(CardValue.TEN, "[10] Spielrichtung ändern");
		JCheckBox specialCardAce   = constructSpecialCardCheckbox(CardValue.ACE, "[Ass] 2. Karte legen");
		
		
		
		add(settingsPanel, BorderLayout.CENTER);
	}
	
	private JCheckBox constructSpecialCardCheckbox(CardValue target, String text) {
		JCheckBox result = new JCheckBox(text);
		result.addActionListener(e -> controller.getSpecialCardListener().accept(target, result.isSelected()));
		return result;
	} 
}
