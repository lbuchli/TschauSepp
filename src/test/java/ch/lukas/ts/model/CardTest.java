package ch.lukas.ts.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CardTest {

	/*
	 * UTC013
	 */
	@Test
	public void imageFilePathCorrect() {
		final String target = "cards/h10.png";
		String result = new Card(CardValue.TEN, CardColor.HEARTS).getImageFileName();
		assertEquals(target, result);
	}
	
}
