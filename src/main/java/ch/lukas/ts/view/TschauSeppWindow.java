package ch.lukas.ts.view;

import javax.swing.JFrame;

public class TschauSeppWindow extends JFrame {
	

	private static final long serialVersionUID = 2256421965090004072L;
	
	private GameView gameView;
	private SettingView settingView;
	
	public TschauSeppWindow() {
		// TODO
		gameView = new GameView();
		add(gameView);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
