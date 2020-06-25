package ch.lukas.ts.model;

@FunctionalInterface
public interface PlayerChangeListener {
	public void onPlayerChange(Player nextPlayer);
}
