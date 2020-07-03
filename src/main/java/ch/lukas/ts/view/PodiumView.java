package ch.lukas.ts.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ch.lukas.ts.control.GameController;

/**
 * A podium that gets shown at the end of a game.
 * @author lukas
 */
public class PodiumView extends JPanel {
	
	private static final long serialVersionUID = 8394120660155897096L;

	public PodiumView(CardLayout layout) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		DefaultListModel<String> podiumModel = new DefaultListModel<>();
		JList<String> podium = new JList<>(podiumModel);
		GameController.updateScoreboard(podiumModel);
		podium.setBorder(new EmptyBorder(40, 40, 40, 40));
		
		JPanel podiumPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		podiumPanel.setBackground(Color.WHITE);
		podiumPanel.add(podium);
		add(podiumPanel, BorderLayout.CENTER);
		
		JButton backButton = new JButton("Zurück zum Hauptmenu");
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.add(backButton);
		
		backButton.addActionListener((e) -> {
			layout.removeLayoutComponent(this);
			layout.show(getParent(), "menu");
		});
		
		add(buttonPanel, BorderLayout.SOUTH);
	}

}
