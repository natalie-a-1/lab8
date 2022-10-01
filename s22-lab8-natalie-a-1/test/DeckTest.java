import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void testNoArgumentConstructor() {
		Deck deck = new Deck();
		
		Card card = deck.draw();
		assertEquals("2 of C", card.toString());
		card = deck.draw();
		assertEquals("3 of C", card.toString());
		card = deck.draw();
		assertEquals("4 of C", card.toString());
		
		for (int count = 0; count < 9; ++count) {
			deck.draw();
		}
		card = deck.draw();
		assertEquals("A of C", card.toString());
		card = deck.draw();
		assertEquals("2 of D", card.toString());
		card = deck.draw();
		assertEquals("3 of D", card.toString());
		card = deck.draw();
		assertEquals("4 of D", card.toString());
		
		for (int count = 0; count < 20; ++count) {
			deck.draw();
		}
		card = deck.draw();
		assertEquals("Q of H", card.toString());
		card = deck.draw();
		assertEquals("K of H", card.toString());
		card = deck.draw();
		assertEquals("A of H", card.toString());
		card = deck.draw();
		assertEquals("2 of S", card.toString());
		
		for (int count = 0; count < 10; ++count) {
			deck.draw();
		}
		card = deck.draw();
		assertEquals("K of S", card.toString());
		card = deck.draw();
		assertEquals("A of S", card.toString());
		card = deck.draw();
		assertNull(card);
		card = deck.draw();
		assertNull(card);
	}

	@Test
	void testShuffle() {
		Card[] cards = {
				new Card(Rank.FIVE, Suit.SPADES), 
				new Card(Rank.FOUR, Suit.HEARTS),
				new Card(Rank.THREE, Suit.SPADES),
				new Card(Rank.KING, Suit.CLUBS),
				new Card(Rank.ACE, Suit.DIAMONDS)};
		Deck deck = new Deck(cards);
		
		assertEquals("[5 of S, 4 of H, 3 of S, K of C, A of D]", deck.toString());
		deck.shuffle();
		assertEquals(cards.length, deck.size());
		assertNotEquals("[5S, 4H, 3S, KC, AD]", deck.toString());
	}
	
	@Test
	void testCopyConstructor() {
		Card[] cards = {
				new Card(Rank.SEVEN, Suit.CLUBS), 
				new Card(Rank.TWO, Suit.HEARTS),
				new Card(Rank.QUEEN, Suit.CLUBS),
				new Card(Rank.NINE, Suit.SPADES),
				new Card(Rank.QUEEN, Suit.DIAMONDS)};
		Deck d1 = new Deck(cards);
		Deck d2 = new Deck(d1);
		
		assertEquals("[7 of C, 2 of H, Q of C, 9 of S, Q of D]", d1.toString());
		assertEquals("[7 of C, 2 of H, Q of C, 9 of S, Q of D]", d2.toString());
		for (int idx = 0; idx < cards.length; ++idx) {
			cards[idx] = null;
		}
		assertEquals("[7 of C, 2 of H, Q of C, 9 of S, Q of D]", d1.toString());
		assertEquals("[7 of C, 2 of H, Q of C, 9 of S, Q of D]", d2.toString());
		
		assertEquals("7 of C", d2.draw().toString());
		assertEquals("[7 of C, 2 of H, Q of C, 9 of S, Q of D]", d1.toString());
		assertEquals("[2 of H, Q of C, 9 of S, Q of D]", d2.toString());
		assertEquals(5, d1.size());
		assertEquals(4, d2.size());
		
		assertEquals("2 of H", d2.draw().toString());
		assertEquals("Q of C", d2.draw().toString());
		assertEquals("[7 of C, 2 of H, Q of C, 9 of S, Q of D]", d1.toString());
		assertEquals("[9 of S, Q of D]", d2.toString());
		assertEquals(5, d1.size());
		assertEquals(2, d2.size());
		
		assertEquals("9 of S", d2.draw().toString());
		assertEquals("Q of D", d2.draw().toString());
		assertNull(d2.draw());
		assertEquals("[7 of C, 2 of H, Q of C, 9 of S, Q of D]", d1.toString());
		assertEquals("[]", d2.toString());
		assertEquals(5, d1.size());
		assertEquals(0, d2.size());
	}
}
