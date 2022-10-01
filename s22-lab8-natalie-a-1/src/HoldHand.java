import java.util.HashMap;

public class HoldHand extends Hand{
	
	private final int FLUSH_NUM = 5;
	

	public HoldHand(Card c1, Card c2) {
		
		super(new Card[] {c1, c2});
	}
	
	@Override
	public void addCard(Card card) {
		
	}
	
	@Override
	public Card playCard(int index) {
		
		return null;
	}
	
	public boolean hasFlush(Card[] community) {
		
		HashMap<Suit, Integer> map = new HashMap<Suit, Integer>();

		map.put(Suit.CLUBS, 0);
		map.put(Suit.DIAMONDS, 0);
		map.put(Suit.HEARTS, 0);
		map.put(Suit.SPADES, 0);
		 
		map.put(super.getCard(0).getSuit(), map.get(super.getCard(0).getSuit()) +1);
		map.put(super.getCard(1).getSuit(), map.get(super.getCard(1).getSuit()) +1);
		
		for (Card c: community) {
			
			map.put(c.getSuit(), map.get(c.getSuit()) +1);
			
			if (map.containsValue(FLUSH_NUM)) {
				
				return true;
			}
		
			}
		
		return false;
	}
}
