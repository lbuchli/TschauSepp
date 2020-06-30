package ch.lukas.ts.control;

import java.awt.event.ActionListener;
import java.util.function.BiConsumer;

import ch.lukas.ts.model.CardValue;

public class SettingController {

	public ActionListener getChangePlayerCountListener() {
		return (e) -> {}; // TODO
	}
	
	public BiConsumer<CardValue, Boolean> getSpecialCardListener() {
		return (value, enabled) -> {}; // TODO
	}
	
	public ActionListener getFinishPointsListener() {
		return (e) -> {}; // TODO
	}
}
