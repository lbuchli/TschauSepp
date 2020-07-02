package ch.lukas.ts.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuView extends JPanel {

	private static final long serialVersionUID = -719202664457466158L;

	public MenuView(CardLayout layout) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		
		JLabel title = new JLabel("Tschau Sepp", JLabel.CENTER);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setFont(new Font(title.getFont().getName(), Font.BOLD, 64));
		title.setBorder(new EmptyBorder(20, 20, 40, 20));
		
		JButton startButton = new JButton("Start");
		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		startButton.addActionListener((e) -> layout.show(getParent(), "game"));
		
		JButton settingsButton = new JButton("Einstellungen");
		settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		settingsButton.addActionListener((e) -> layout.show(getParent(), "settings"));
		
		JButton quitButton = new JButton("Spiel Verlassen");
		quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitButton.addActionListener((e) -> System.exit(0)); // beautiful code
		
		// you can't add empty borders directly to buttons, because the buttons then display as
		// if the border where padding - thank you, swing.
		JPanel startButtonPanel = new JPanel();
		startButtonPanel.add(startButton);
		startButtonPanel.setBackground(Color.WHITE);
		
		JPanel settingsButtonPanel = new JPanel();
		settingsButtonPanel.add(settingsButton);
		settingsButtonPanel.setBackground(Color.WHITE);
		
		JPanel quitButtonPanel = new JPanel();
		quitButtonPanel.add(quitButton);
		quitButtonPanel.setBackground(Color.WHITE);
		
		JPanel spacerPanel = new JPanel();
		spacerPanel.setBackground(Color.WHITE);
		spacerPanel.setBorder(new EmptyBorder(0, 0, 150, 0));
		
		add(title);
		add(startButtonPanel);
		add(settingsButtonPanel);
		add(quitButtonPanel);
		add(spacerPanel);
	}
}
