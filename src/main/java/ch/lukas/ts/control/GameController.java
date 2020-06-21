package ch.lukas.ts.control;

import java.awt.event.ActionListener;

import ch.lukas.ts.model.TschauSepp;

public class GameController {

	public ActionListener getCancelListener() {
		return (e) -> TschauSepp.getInstance().getCurrentGame().cancel();
	}
}
