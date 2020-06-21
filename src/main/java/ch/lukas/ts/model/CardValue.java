package ch.lukas.ts.model;

public enum CardValue {
	VALUE_2(2, "2"),
	VALUE_3(3, "3"),
	VALUE_4(4, "4"),
	VALUE_5(5, "5"),
	VALUE_6(6, "6"),
	VALUE_7(7, "7"),
	VALUE_8(8, "8"),
	VALUE_9(9, "9"),
	VALUE_10(10, "10"),
	VALUE_JACK(10, "J"),
	VALUE_QUEEN(10, "Q"),
	VALUE_KING(10, "K"),
	VALUE_ACE(10, "A");

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
