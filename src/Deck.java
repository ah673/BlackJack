import java.util.ArrayList;
import java.util.Random;
public class Deck {

    public Card[] deck;
    private ArrayList<Card> a  = new ArrayList<Card>();
    private static ArrayList<Card> b = new ArrayList<Card>();
    private ArrayList<Card> c = new ArrayList<Card>();
    private Card topCard;
    
    public Deck() {
		//Fill array list with numbers from 1 to 52
		  for (int copy=0; copy<4; copy++){
			  for (int number = 0; number < 13; number++){
	            a.add(new Card(number+1));
	            }

		  }
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
    	return b.size();
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
