package ch.lukas.ts.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TschauSeppWindow extends JFrame {

	private static final long serialVersionUID = 2256421965090004072L;
	
	private GameView gameView;
	private SettingView settingView;
	
	public TschauSeppWindow() {
		gameView = new GameView();
		settingView = new SettingView();
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		CardLayout layout = new CardLayout();
		layout.addLayoutComponent(gameView, "game");
		layout.addLayoutComponent(settingView, "settings");
		layout.addLayoutComponent(mainPanel, "main");
		
		JLabel title = new JLabel("Tschau Sepp");
		title.setFont(new Font(title.getFont().getName(), Font.BOLD, 64));
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener((e) -> layout.show(getContentPane(), "game"));
		
		JButton settingsButton = new JButton("Einstellungen");
		settingsButton.addActionListener((e) -> layout.show(getContentPane(), "settings"));
		
		mainPanel.add(title, BorderLayout.NORTH);
		mainPanel.add(startButton, BorderLayout.CENTER);
		mainPanel.add(settingsButton, BorderLayout.CENTER);
		
		//getContentPane().setLayout(layout);
		//layout.show(getContentPane(), "game");
		getContentPane().add(mainPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
