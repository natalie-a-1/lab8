import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HandTest {

	@Test
	void test() {
		Hand hand = new Hand(new Card[] {});
		assertEquals(0, hand.size());
		assertEquals("[]", hand.toString());
		assertTrue(hand.isSorted());
		
		hand.addCard(new Card(Rank.SIX, Suit.DIAMONDS));
		assertEquals(1, hand.size());
		assertEquals("[6 of D]", hand.toString());
		assertTrue(hand.isSorted());
		
		hand.addCard(new Card(Rank.KING, Suit.CLUBS));
		assertEquals(2, hand.size());
		assertEquals("[6 of D, K of C]", hand.toString());
		assertFalse(hand.isSorted());
		
		hand.sort();
		assertEquals(2, hand.size());
		assertEquals("[K of C, 6 of D]", hand.toString());
		assertTrue(hand.isSorted());
		
		hand.addCard(new Card(Rank.TEN, Suit.HEARTS));
		assertEquals(3, hand.size());
		assertEquals("[K of C, 6 of D, 10 of H]", hand.toString());
		assertTrue(hand.isSorted());
		
		hand.sort();
		assertEquals(3, hand.size());
		assertEquals("[K of C, 6 of D, 10 of H]", hand.toString());
		assertTrue(hand.isSorted());
		
		assertEquals("6 of D", hand.playCard(1).toString());
		assertEquals(2, hand.size());
		assertEquals("[K of C, 10 of H]", hand.toString());
		assertTrue(hand.isSorted());
		
		hand.addCard(new Card(Rank.NINE, Suit.HEARTS));
		assertEquals(3, hand.size());
		assertEquals("[K of C, 10 of H, 9 of H]", hand.toString());
		assertFalse(hand.isSorted());
		
		hand.sort();
		assertEquals(3, hand.size());
		assertEquals("[K of C, 9 of H, 10 of H]", hand.toString());
		assertTrue(hand.isSorted());
		
		assertEquals("9 of H", hand.playCard(1).toString());
		assertEquals(2, hand.size());
		assertEquals("K of C", hand.getCard(0).toString());
		assertEquals("10 of H", hand.getCard(1).toString());
		assertTrue(hand.isSorted());
		
		assertEquals("K of C", hand.playCard(0).toString());
		assertEquals(1, hand.size());
		assertEquals("10 of H", hand.getCard(0).toString());
		assertTrue(hand.isSorted());
		
		assertEquals("10 of H", hand.playCard(0).toString());
		assertEquals(0, hand.size());
		assertTrue(hand.isSorted());
	}
}
