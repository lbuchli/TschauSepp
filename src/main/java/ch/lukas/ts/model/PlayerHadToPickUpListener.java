package ch.lukas.ts.model;

@FunctionalInterface
public interface PlayerHadToPickUpListener {
	public void onPlayerHadToPickUp(int amount);
}
