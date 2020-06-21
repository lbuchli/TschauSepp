package ch.lukas.ts.model;

public enum CardColor {
	HEARTS("h"),
	DIAMONDS("d"),
	SPADES("s"),
	CLOVER("c");
	
	private final String imageID;
	
	private CardColor(String imageID) {
		this.imageID = imageID;
	}
	
	public String getImageID() {
		return imageID;
	}
}
