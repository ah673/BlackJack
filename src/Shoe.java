import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Shoe {
	
	protected List<Card> cards = new ArrayList<Card>();
    
	public Shoe() {
		makeDeck();
	}
	
	private void makeDeck() {
		for (int i = 0; i < Card.NUM_OF_SUITS; i++){
			insertEachSuitIntoDeck();
		}	
	}
	
	private void insertEachSuitIntoDeck() {
		for (Card.Face cardFace : Card.Face.values())
			cards.add(new Card(cardFace));
	}
	
	public List<Card> shuffle() {
		Collections.shuffle(cards);
		return cards;	
	}
	
	public Card dealCard(){ 
		Card topCard = cards.remove(0);
		return topCard; 
	}

}
