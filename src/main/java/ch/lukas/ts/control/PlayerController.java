package ch.lukas.ts.control;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

import ch.lukas.ts.model.TschauSepp;

public class PlayerController {
	
	public ActionListener getTschauListener() {
		return e -> TschauSepp.getInstance().getCurrentGame().toggleTschau();
	}
	
	public ActionListener getSeppListener() {
		return e -> TschauSepp.getInstance().getCurrentGame().toggleSepp();
	}
	
	public ActionListener getFinishMoveListener() {
		return e -> TschauSepp.getInstance().getCurrentGame().nextPlayer();
	}
	
	/*
	public ListSelectionListener getCardChooseListener() {
		return e -> {
			TschauSepp.getInstance()
					.getCurrentGame()
					.getCurrentPlayer()
					.playCard(e.getFirstIndex());
		};
	}
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
