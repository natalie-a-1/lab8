
public class Card implements Comparable<Card> {
	
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		
		if (rank == null || suit == null) {
			throw new NullPointerException();
		} 
		this.rank = rank;
		this.suit = suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}

	@Override
	public int compareTo(Card card) {
		int compare_suit = suit.compareTo(card.suit);
		int compare_rank = rank.compareTo(card.rank);
		
		if (compare_suit == 0) {
			
			if (compare_rank == 0) {
				
				return 0;
			} 
			else if (compare_rank > 0) {
				
				return 1;
			} 
			else {
				
				return -1;
			}
		}
		else if (compare_suit > 0) {
			
			return 1;
		} 
		
		else {
			
			return -1;
		}
		
	}
	
	public String toString() {
		String temp = rank.toString() + " of " + suit.toString();
		return temp;
		
	}


}
