package ch.lukas.ts.control;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

import ch.lukas.ts.model.TschauSepp;

/**
 * Controller for the player section of the game GUI
 * @author lukas
 */
public class PlayerController {
	
	/**
	 * A listener for the "Tschau"-Checkbox
	 * @return The listener
	 */
	public ActionListener getTschauListener() {
		return e -> TschauSepp.getInstance().getCurrentGame().toggleTschau();
	}
	
	/**
	 * A listener for the "Sepp"-Checkbox
	 * @return The listener
	 */
	public ActionListener getSeppListener() {
		return e -> TschauSepp.getInstance().getCurrentGame().toggleSepp();
	}
	
	/**
	 * A listener for the "Fertig"-Button
	 * @return The listener
	 */
	public ActionListener getFinishMoveListener() {
		return e -> TschauSepp.getInstance().getCurrentGame().nextPlayer();
	}
	
	/*
	 * Only works half the time... very funny swing
	public ListSelectionListener getCardChooseListener() {
		return e -> {
			TschauSepp.getInstance()
					.getCurrentGame()
					.getCurrentPlayer()
					.playCard(e.getFirstIndex());
		};
	}
	*/
	
	/**
	 * A listener for when the user chooses a hand card
	 * @return The listener
	 */
	public MouseListener getCardChooseListener() {
		return new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JList source = (JList) e.getSource();
				int index = source.locationToIndex(e.getPoint());
				TschauSepp.getInstance()
					.getCurrentGame()
					.getCurrentPlayer()
					.playCard(index);
			}
		};
	}
}
