package ch.lukas.ts.model;

public interface CardDeckListener {
	public void onCardPickup(Card card);
	public void onCardPlay(Card card);
}
