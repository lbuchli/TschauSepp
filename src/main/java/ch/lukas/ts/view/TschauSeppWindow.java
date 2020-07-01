package ch.lukas.ts.view;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class TschauSeppWindow extends JFrame {

	private static final long serialVersionUID = 2256421965090004072L;
	
	private GameView gameView;
	private SettingView settingView;
	private MenuView menuView;
	
	public TschauSeppWindow() {
		CardLayout layout = new CardLayout();
		//setLayout(layout);
		
		gameView = new GameView();
		settingView = new SettingView();
		menuView = new MenuView(layout);
		layout.addLayoutComponent(gameView, "game");
		layout.addLayoutComponent(settingView, "settings");
		layout.addLayoutComponent(menuView, "menu");
		
		
		
		//getContentPane().setLayout(layout);
		//layout.show(getContentPane(), "game");
		getContentPane().add(gameView);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
