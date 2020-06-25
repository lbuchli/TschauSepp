package ch.lukas.ts.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ch.lukas.ts.model.TschauSepp;

public class DeckController {

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
