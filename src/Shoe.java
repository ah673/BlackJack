import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
    
    public void copyAL() {
    	//will copy a to c since a will be deleted
    	for (int i=0; i<a.size(); i++){
            c.add(a.get(i));
            }
    }
    
    public int cardsLeft() {
    	return cards.size();
    }
    

    public Card dealCard(){
    	if (cardsLeft()<=12){
    		shuffle();
    	}
		topCard = b.get(0);
		b.remove(0);
		//will keep returning the top card when 
		//called because the first element of the array is always removed
		return topCard;
	}
    

    

} // end class Shoe
