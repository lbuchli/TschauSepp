package ch.lukas.ts.model;

/**
 * A class representing a single playcard
 * @author lukas
 */
public class Card {

	private static final String CARD_PATH = "cards/";
	
	private final CardValue value;
	private final CardColor color;
	
	public Card(CardValue value, CardColor color) {
		this.value = value;
		this.color = color;
	}
	
	/**
	 * Get the file name (with relative path) of an image of a card
	 * @return The file name
	 */
	public String getImageFileName() {
		return CARD_PATH + color.getImageID() + value.getImageID() + ".png";
	}
	
	/**
	 * Get the file name (with relative path) of a card back
	 * @return The file name
	 */
	public static String getBackFileName() {
		return CARD_PATH + "card_back.png";
	}
	
	/**
	 * Get the file name (with relatice path) of the card placeholder image
	 * @return The file name
	 */
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
