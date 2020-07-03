package ch.lukas.ts.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;

import ch.lukas.ts.model.Player;
import ch.lukas.ts.model.TschauSepp;

/**
 * Provides listeners and controls the card deck GUI section.
 * @author lukas
 *
 */
public class DeckController {

	/**
	 * A listener responsible for picking up a card when the user clicks on the spare cards.
	 * @return the listener
	 */
	public MouseListener getCardPickupListener() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				TschauSepp.getInstance().getCurrentGame().getCurrentPlayer().pickUpCard();
				// TODO move finished
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}
		};
	}
}
