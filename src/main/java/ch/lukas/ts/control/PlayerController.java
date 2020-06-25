package ch.lukas.ts.control;

import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionListener;

import ch.lukas.ts.model.TschauSepp;

public class PlayerController {
	
	public ActionListener getTschauListener() {
		return (e) -> TschauSepp.getInstance().getCurrentGame().toggleTschau();
	}
	
	public ActionListener getSeppListener() {
		return (e) -> TschauSepp.getInstance().getCurrentGame().toggleSepp();
	}
	
	public ActionListener getFinishMoveListener() {
		return (e) -> TschauSepp.getInstance().getCurrentGame().nextPlayer();
	}
	
	public ListSelectionListener getCardChooseListener() {
		return (e) -> {
			boolean moveWasValid = TschauSepp.getInstance()
					.getCurrentGame()
					.getCurrentPlayer()
					.playCard(e.getFirstIndex());
			TschauSepp.getInstance().getCurrentGame().setHasPlayedOrPickedUp(moveWasValid);
		};
	}
}
