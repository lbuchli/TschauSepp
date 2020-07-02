package ch.lukas.ts.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class TschauSeppWindow extends JFrame {

	private static final long serialVersionUID = 2256421965090004072L;
	
	private GameView gameView;
	private SettingView settingView;
	private MenuView menuView;
	
	public TschauSeppWindow() {
		CardLayout layout = new CardLayout();
		getContentPane().setLayout(layout);
		
		gameView = new GameView();
		settingView = new SettingView(layout);
		menuView = new MenuView(layout);
		layout.addLayoutComponent(gameView, "game");
		layout.addLayoutComponent(settingView, "settings");
		layout.addLayoutComponent(menuView, "menu");
		
		getContentPane().add(gameView);
		getContentPane().add(settingView);
		getContentPane().add(menuView);

		layout.show(getContentPane(), "menu");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
