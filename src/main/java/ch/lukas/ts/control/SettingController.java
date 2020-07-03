package ch.lukas.ts.control;

import java.util.function.BiConsumer;

import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;

import ch.lukas.ts.model.CardValue;
import ch.lukas.ts.model.Settings;

/**
 * Controller for the "Settings"-screen.
 * @author lukas
 *
 */
public class SettingController {

	/**
	 * A listener to react to changes in player count
	 * @return The listener
	 */
	public ChangeListener getChangePlayerCountListener() {
		return (e) -> {
			int count = (int) ((JSpinner) e.getSource()).getValue(); // :(
			Settings.getInstance().setPlayerCount(count);
		};
	}
	
	/**
	 * A listener for (de-)activating special cards
	 * @return The listener
	 */
	public BiConsumer<CardValue, Boolean> getSpecialCardListener() {
		return (value, enabled) -> {
			if (enabled) {
				Settings.getInstance().addSpecialCard(value);
			} else {
				Settings.getInstance().removeSpecialCard(value);
			}
		};
	}
	
	/**
	 * A listener for when the finish points get changed
	 * @return The listener
	 */
	public ChangeListener getFinishPointsListener() {
		return (e) -> {
			int points = (int) ((JSpinner) e.getSource()).getValue(); // :(
			Settings.getInstance().setFinishPoints(points);
		};
	}
}
