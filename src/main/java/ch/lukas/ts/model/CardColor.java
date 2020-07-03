package ch.lukas.ts.model;

/**
 * Represents one of four card colors.
 * @author lukas
 */
public enum CardColor {
	HEARTS("h"),
	DIAMONDS("d"),
	SPADES("s"),
	CLOVER("c");
	
	private final String imageID;
	
	private CardColor(String imageID) {
		this.imageID = imageID;
	}
	
	/**
	 * Get the ID of this CardValue (used for building the image path)
	 * @return the ID
	 */
	public String getImageID() {
		return imageID;
	}
}
