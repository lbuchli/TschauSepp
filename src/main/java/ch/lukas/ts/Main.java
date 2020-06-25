package ch.lukas.ts;

import javax.swing.SwingUtilities;

import ch.lukas.ts.view.TschauSeppWindow;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			TschauSeppWindow window = new TschauSeppWindow();
			window.pack();
			window.setSize(800, 500);
			window.setVisible(true);
		});
	}

}
