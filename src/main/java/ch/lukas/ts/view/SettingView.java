package ch.lukas.ts.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import ch.lukas.ts.control.SettingController;
import ch.lukas.ts.model.CardValue;

public class SettingView extends JPanel {

	private static final long serialVersionUID = -1419034705199112926L;
	
	private SettingController controller;
	
	public SettingView(CardLayout layout) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		controller = new SettingController();
		
		JLabel title = new JLabel("Tschau Sepp", JLabel.CENTER);
		title.setFont(new Font(title.getFont().getName(), Font.BOLD, 64));
		title.setBorder(new EmptyBorder(20, 20, 50, 20));
		add(title, BorderLayout.NORTH);
		
		JPanel settingsPanel = new JPanel();
		settingsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
		settingsPanel.setBackground(Color.WHITE);
		
		JPanel spinnerPanel = new JPanel();
		spinnerPanel.setLayout(new BoxLayout(spinnerPanel, BoxLayout.Y_AXIS));
		spinnerPanel.setBackground(Color.WHITE);
		
		Font subtitleFont = new Font(title.getFont().getName(), Font.BOLD, 18);
		
		JLabel playerCountTitle = new JLabel("Anzahl Spieler");
		playerCountTitle.setFont(subtitleFont);
		playerCountTitle.setBorder(new EmptyBorder(20, 0, 10, 0));
		
		
		JSpinner playerCountSpinner = new JSpinner();
		playerCountSpinner.addChangeListener(controller.getChangePlayerCountListener());
		playerCountSpinner.setValue(4);
		playerCountSpinner.setMaximumSize(new Dimension(64, 32));
		
		JLabel maxPointTitle = new JLabel("Maximalpunktzahl");
		maxPointTitle.setFont(subtitleFont);
		maxPointTitle.setBorder(new EmptyBorder(30, 0, 10, 0));
		
		JSpinner maxPointSpinner = new JSpinner();
		maxPointSpinner.addChangeListener(controller.getFinishPointsListener());
		maxPointSpinner.setValue(400);
		maxPointSpinner.setMaximumSize(new Dimension(64, 32));
		
		spinnerPanel.add(playerCountTitle);
		spinnerPanel.add(playerCountSpinner);
		spinnerPanel.add(maxPointTitle);
		spinnerPanel.add(maxPointSpinner);
		
		JPanel specialCardsPanel = new JPanel();
		specialCardsPanel.setLayout(new BoxLayout(specialCardsPanel, BoxLayout.Y_AXIS));
		specialCardsPanel.setBackground(Color.WHITE);
		
		JLabel specialCardsTitle = new JLabel("Sonderkarten");
		specialCardsTitle.setFont(subtitleFont);
		
		JCheckBox specialCardSeven = constructSpecialCardCheckbox(CardValue.SEVEN, "[7] 2 Karten aufnehmen");
		JCheckBox specialCardEight = constructSpecialCardCheckbox(CardValue.EIGHT, "[8] Spieler auslassen");
		JCheckBox specialCardTen   = constructSpecialCardCheckbox(CardValue.TEN, "[10] Spielrichtung ändern");
		JCheckBox specialCardAce   = constructSpecialCardCheckbox(CardValue.ACE, "[Ass] 2. Karte legen");
		
		specialCardSeven.setBackground(Color.WHITE);
		specialCardEight.setBackground(Color.WHITE);
		specialCardTen.setBackground(Color.WHITE);
		specialCardAce.setBackground(Color.WHITE);
		
		specialCardsPanel.add(specialCardsTitle);
		specialCardsPanel.add(specialCardSeven);
		specialCardsPanel.add(specialCardEight);
		specialCardsPanel.add(specialCardTen);
		specialCardsPanel.add(specialCardAce);
		
		settingsPanel.add(spinnerPanel);
		settingsPanel.add(specialCardsPanel);
		add(settingsPanel, BorderLayout.CENTER);
		
		JButton backButton = new JButton("Zurück");
		backButton.addActionListener((listener) -> layout.show(getParent(), "menu"));
		
		JPanel backButtonPanel = new JPanel();
		backButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		backButtonPanel.setBackground(Color.WHITE);
		backButtonPanel.setBorder(new EmptyBorder(16, 16, 16, 16));
		backButtonPanel.add(backButton);
		
		add(backButtonPanel, BorderLayout.SOUTH);
	}
	
	private JCheckBox constructSpecialCardCheckbox(CardValue target, String text) {
		JCheckBox result = new JCheckBox(text);
		result.addActionListener(e -> controller.getSpecialCardListener().accept(target, result.isSelected()));
		return result;
	} 
}
