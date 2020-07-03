package ch.lukas.ts.model;

/**
 * Represents one of 13 possible card values.
 * @author lukas
 *
 */
public enum CardValue {
	TWO(2, "2"),
	THREE(3, "3"),
	FOUR(4, "4"),
	FIVE(5, "5"),
	SIX(6, "6"),
	SEVEN(7, "7"),
	EIGHT(8, "8"),
	NINE(9, "9"),
	TEN(10, "10"),
	JACK(10, "j"),
	QUEEN(10, "q"),
	KING(10, "k"),
	ACE(10, "a");

	private final int points;
	private final String imageID;
	
	private CardValue(int points, String imageID) {
		this.points = points;
		this.imageID = imageID;
	}
	
	/**
	 * Get the points this value is worth
	 * @return The amount of points it is worth
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Get the image id of this value (used for image path building)
	 * @return The ID
	 */
	public String getImageID() {
		return imageID;
	}
}
