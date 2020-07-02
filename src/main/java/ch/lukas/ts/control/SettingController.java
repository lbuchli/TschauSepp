package ch.lukas.ts.control;

import java.util.function.BiConsumer;

import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;

import ch.lukas.ts.model.CardValue;
import ch.lukas.ts.model.Settings;

public class SettingController {

	public ChangeListener getChangePlayerCountListener() {
		return (e) -> {
			int count = (int) ((JSpinner) e.getSource()).getValue(); // :(
			Settings.getInstance().setPlayerCount(count);
		};
	}
	
	public BiConsumer<CardValue, Boolean> getSpecialCardListener() {
		return (value, enabled) -> {
			if (enabled) {
				Settings.getInstance().addSpecialCard(value);
			} else {
				Settings.getInstance().removeSpecialCard(value);
			}
		};
	}
	
	public ChangeListener getFinishPointsListener() {
		return (e) -> {
			int points = (int) ((JSpinner) e.getSource()).getValue(); // :(
			Settings.getInstance().setFinishPoints(points);
		};
	}
}
