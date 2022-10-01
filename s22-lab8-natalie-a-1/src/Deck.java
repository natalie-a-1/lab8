import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		
		
		for(Suit s: Suit.values()) {
			
			for(Rank r: Rank.values()) {
				
				Card temp = new Card(r, s);
				
				this.cards.add(temp);
			}
		}
		Collections.sort(cards);
	}
	
	public Deck(Card[] cards) {
		
		Collections.addAll(this.cards, cards);
		
	}
	
	public Deck(Deck deck) {
		
		for (Card c: deck.cards) {
			cards.add(c);
		}
	}
	
	public int size() {
		return cards.size();
	}
	
	public Card draw() {
		if (cards.size() == 0) {
			return null;
		}
		return cards.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	//NEED TO DO
	public List<Card> getCardsByRank(Rank rank) {
		
		List<Card> temp = new ArrayList<Card>();
		
		for (Card c: cards) {
			
			if (c.getRank() == rank) {
				
				temp.add(c);
			}
		}
		return temp;
	}
	
	public String toString() {
		return cards.toString();
		
	}
}
