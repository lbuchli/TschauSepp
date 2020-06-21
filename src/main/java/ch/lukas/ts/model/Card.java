package ch.lukas.ts.model;

public class Card {
	private final CardValue value;
	private final CardColor color;
	
	public Card(CardValue value, CardColor color) {
		this.value = value;
		this.color = color;
	}
	
	public String getImageFileName() {
		return null; // TODO
	}

	public CardValue getValue() {
		return value;
	}

	public CardColor getColor() {
		return color;
	}
}
