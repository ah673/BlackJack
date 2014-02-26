import java.util.ArrayList;


public class Dealer extends BlackJackPlayer {
	private Deck theDeck;
	private Card x;
	private int handTotal; //contains the sum of hand
	private boolean BlackJack; //did Dealer get Black Jack?
	
	public void play(){
		
		theDeck = new Deck();
		
		//an array list to contain the Cards in dealt
		hand = new ArrayList<Card>();
		
		//initially deal 2 cards and add to array list;
		for (int i = 0; i<2; i++){
			x = theDeck.dealCard();
			hand.add(x);
		}
		handTotal = sumCards();
		for (int i = 1; i<hand.size(); i++){
			System.out.println("Dealer's hand: x, "  +hand.get(i)); 
			//first card is not revealed
		}

	}
	
	public boolean getBlackJack() {
		//Checks to see if initial hand contains BlackJack
		if (handTotal == 21){
			BlackJack = true;
		}
		else
			BlackJack = false;
		
		return BlackJack;		
	} //end blackJack
	
	public void action(){
		//Dealer hits on all hand sums lower than 16
		while (handTotal <= 16){
			x = theDeck.dealCard();
			hand.add(x);
			handTotal = sumCards();
		}
		System.out.println("Dealer's hand:" + hand);
		System.out.println("Total: " +handTotal);
			
	}
	
	public int getTotal(){
		return handTotal;
	}

	
	public int sumCards(){
		//adds up the hand's worth and returns the value
		int sum = 0;
		int subSum = 0;
		int cardValue = 0;
		int indexValue = 0; 
		
		for (int k = 0; k<hand.size(); k++){
			indexValue =hand.get(k).getValue();
			if (indexValue <=10 && indexValue !=1){
				cardValue = hand.get(k).getValue();
			}
			else if (indexValue > 10){
				cardValue = 10;
			}
			else if (indexValue == 1){
				if (11 + subSum < 21)  
					cardValue = 11;
				else if (11+ subSum > 21) 
					cardValue = 1;	
				}
			
			subSum = subSum + cardValue;
			}
		sum = sum + subSum;
		return sum;

		}

	
	/*public Card hit(){
		x = theDeck.dealCard();
		return x;
	}*/
	
} // end class
