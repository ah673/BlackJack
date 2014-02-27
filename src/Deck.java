import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Deck {
	
	protected List<Card> cards = new ArrayList<Card>();
    
	public Deck() {
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

	public void shuffle() {
    	b.clear();
    	copyAL(); // copies 
    	Random numGenerator = new Random();
    	
    	int p =52;
        for (int i=51; i>=0; i--) {
                int rand = numGenerator.nextInt(p);
                Card temp = c.remove(rand); //removes the card 
                							//at the randomly generated index
                b.add(temp);				//and adds it to b ensuring no repeats
                p--;						// of more than 4 copies.
        }
        
        
    }// end shuffle
    
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
    

    

} // end class Deck
