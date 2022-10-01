import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hand {

	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand(Card[] cards) {
		Collections.addAll(this.cards, cards);
	}
	
	public int size() {
		return cards.size();
	}
	
	public Card getCard(int index) {
		return cards.get(index);
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public Card playCard(int index) {
		return cards.remove(index);
	}
	
	public void sort() {
		Collections.sort(cards);
	}
	
	public boolean isSorted() {
		
		if (size() == 1) {
			return true;
		}
		
		for (int i = 0; i < size()-1; i++) {
			
			if (cards.get(i).compareTo(cards.get(i + 1)) > 0) {
				
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		return cards.toString();
	}
}
