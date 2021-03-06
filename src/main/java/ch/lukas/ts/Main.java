package ch.lukas.ts;

import javax.swing.SwingUtilities;

import ch.lukas.ts.view.TschauSeppWindow;

/**
 * The main class. Its sole purpose is to host the main method.
 * @author lukas
 *
 */
public class Main {

	/**
	 * The main method instantiates a "Tschau Sepp"-Window.
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			TschauSeppWindow window = new TschauSeppWindow();
			window.pack();
			window.setSize(800, 500);
			window.setVisible(true);
		});
	}

}
