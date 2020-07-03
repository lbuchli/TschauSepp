package ch.lukas.ts.view;

import java.awt.CardLayout;

import javax.swing.JFrame;

/**
 * The main window, containing all views.
 * @author lukas
 */
public class TschauSeppWindow extends JFrame {

	private static final long serialVersionUID = 2256421965090004072L;
	
	private SettingView settingView;
	private MenuView menuView;
	
	public TschauSeppWindow() {
		CardLayout layout = new CardLayout();
		getContentPane().setLayout(layout);
		
		settingView = new SettingView(layout);
		menuView = new MenuView(layout);
		layout.addLayoutComponent(settingView, "settings");
		layout.addLayoutComponent(menuView, "menu");
		
		getContentPane().add(settingView);
		getContentPane().add(menuView);

		layout.show(getContentPane(), "menu");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
