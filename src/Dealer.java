import java.util.*;

public class Dealer extends BlackJackPlayer {
	List<Card> hand; 
	
	public Dealer(){
		hand = new ArrayList<Card>();
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
	
} // end class
