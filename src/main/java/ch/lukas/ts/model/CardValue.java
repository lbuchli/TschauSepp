package ch.lukas.ts.model;

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
	
	public int getPoints() {
		return points;
	}
	
	public String getImageID() {
		return imageID;
	}
}
