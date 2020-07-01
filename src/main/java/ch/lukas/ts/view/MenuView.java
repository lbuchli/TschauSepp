package ch.lukas.ts.view;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuView extends JPanel {

	private static final long serialVersionUID = -719202664457466158L;

	public MenuView(CardLayout layout) {
		//setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Tschau Sepp");
		//title.setFont(new Font(title.getFont().getName(), Font.BOLD, 64));
		
		//JButton startButton = new JButton("Start");
		//startButton.addActionListener((e) -> layout.show(getParent(), "game"));
		
		//JButton settingsButton = new JButton("Einstellungen");
		//settingsButton.addActionListener((e) -> layout.show(getParent(), "settings"));
		
		//add(title, BorderLayout.NORTH);
		add(title);
		//add(startButton, BorderLayout.CENTER);
		//add(settingsButton, BorderLayout.CENTER);
	}
}
