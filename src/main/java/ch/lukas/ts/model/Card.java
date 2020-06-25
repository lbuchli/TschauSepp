package ch.lukas.ts.model;

public class Card {

	private static final String CARD_PATH = "cards/";
	
	private final CardValue value;
	private final CardColor color;
	
	public Card(CardValue value, CardColor color) {
		this.value = value;
		this.color = color;
	}
	
	public String getImageFileName() {
		return CARD_PATH + color.getImageID() + value.getImageID() + ".png";
	}
	
	public static String getBackFileName() {
		return CARD_PATH + "card_back.png";
	}
	
	public static String getPlaceholderFileName() {
		return CARD_PATH + "placeholder.png";
	}

	public CardValue getValue() {
		return value;
	}

	public CardColor getColor() {
		return color;
	}
}
