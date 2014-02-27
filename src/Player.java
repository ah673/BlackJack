import java.util.ArrayList;
import java.util.Scanner;

public class Player extends BlackJackPlayer {

	private ArrayList<Card> splitHand;

	Scanner input = new Scanner (System.in);
	

	
	public void play(){
	
	} // end play

	public boolean getBlackJack() {
		
	} //end blackJack
	
	public boolean playDD(){
		
		boolean playedDD = true;
		
		int again = 0;
		while (again ==0){
			System.out.println("(Double Down? (1-yes | 0-no))");
			int options = input.nextInt();
		
		if (options == 1){
			//if double downed, new bet
			myBet.doubleBet();
			System.out.println("Your hand:" + hit());
			handTotal = sumCards();
			System.out.println("Total: " +handTotal);
			again =1;
			playedDD = true;
			}
		else if (options == 0){
			playedDD = false;
			again =1;
			}
		else if (options !=0 && options != 1){
			//in case user enters a number greater than 1 or text
			System.out.println("Invalid response");
			}
		} // end while
		
		return playedDD;
	}

	public void action(){
		//method to ask if user wants to hit or stand
		//and act accordingly
		int again = 1;
			while (again == 1 && sumCards() < 21){
				System.out.println("Hand 1: (1-Hit | 0-Stand)");
				int hit = input.nextInt();
				if (hit == 1){
					System.out.println("Your hand:" + hit());
					handTotal = sumCards();
					System.out.println("Total: " +handTotal);
				}
				else if (hit ==0){
					again = 0;
					}
				else if (hit !=0 && hit != 1)
					//in case user enters a number greater than 1 or text
					System.out.println("Invalid response");
				}
			} // end action
	
	public void action2(){
		//method to ask if user wants to hit or stand
		//and act accordingly for 2nd hand
		int again = 1;
			while (again == 1 && sumCards2() < 21){
				System.out.println("Hand2 (1-Hit | 0-Stand)");
				int hit = input.nextInt();
				if (hit == 1){
					System.out.println("Your hand:" + hit2());
					hand2Total = sumCards2();
					System.out.println("Total: " +hand2Total);
				}
				else if (hit ==0){
					again = 0;
					}
				else if (hit !=0 && hit != 1)
					//in case user enters a number greater than 1 or text
					System.out.println("Invalid response");
				}
			} // end action
	
	public int sumCards(){
		//sums the cards in the player's hand
		int sum = 0;
		int subSum = 0;
		cardValue = 0;
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
				if (11 + subSum <= 21)  
					cardValue = 11;
				else if (subSum > 21) 
					cardValue = 1;	
				}
			
			subSum = subSum + cardValue;
			}
		sum = sum + subSum;
		
		return sum;
		}
	
	public int sumCards2(){
		//sums the cards in the player's 2nd hand
		int sum = 0;
		int subSum = 0;
		cardValue = 0;
		int indexValue = 0; 
		
		for (int k = 0; k<splitHand.size(); k++){
			indexValue =splitHand.get(k).getValue();
			if (indexValue <=10 && indexValue !=1){
				cardValue = splitHand.get(k).getValue();
			}
			else if (indexValue > 10){
				cardValue = 10;
			}
			else if (indexValue == 1){
				if (11 + subSum <= 21)  
					cardValue = 11;
				else if (11+ subSum > 21) 
					cardValue = 1;	
				}
			
			subSum = subSum + cardValue;
			}
		sum = sum + subSum;
		
		return sum;
		}
	
	public ArrayList<Card> hit(){
		x = theDeck.dealCard();
		hand.add(x);
		return hand;
	}
	
	public ArrayList<Card> hit2(){
		//hitting on second hand
		x = theDeck.dealCard();
		splitHand.add(x);
		return splitHand;
	}
	
	public int getTotal(){
		return handTotal;
	}
	
	public int getTotal2(){
		return hand2Total;
	}
	
	public boolean win(){
		return won; 
	}
	
	public boolean getSplitted1(){
		return splitted;
	}

	public void receiveCard(Card dealtCard) {
		hand.add(dealtCard); 
	}

} // end class
