import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	
	private ArrayList<Card> hand;
	private ArrayList<Card> hand2;
	private Money myBet = new Money();
	private Deck theDeck;
	private boolean won;
	private Card x;
	private int cardValue;
	private int handTotal;
	private int hand2Total;
	private static boolean BlackJack;
	private boolean splitted;


	Scanner input = new Scanner (System.in);
	

	
	public void play(){
		theDeck = new Deck();
		myBet.bets();
		
		//an array list to contain the Cards dealt
		hand = new ArrayList<Card>();
		
		//initially deal 2 cards and add to array list;
		for (int i = 0; i<2; i++){
			x = theDeck.dealCard();
			hand.add(x);
		}
		
		System.out.println("Your hand:" + hand);
		handTotal = sumCards();
		System.out.println("Cards' Total: " +handTotal);
		
		int indexValue1 =hand.get(0).getValue();
		int indexValue2 = hand.get(1).getValue();
		
		if (indexValue1==indexValue2){
			playSplit();
		}
		
		
		
	} // end play
	
	public boolean playSplit() {
		int again = 0;
		
		while (again ==0){
			System.out.println("Split your hand? (1-yes | 0-no)");
			int willSplit = input.nextInt();
		
		if (willSplit == 1){	
			splitted = true;

			//an second array list to contain the 2nd hand
			hand2 = new ArrayList<Card>();
			
			hand2.add(hand.get(1)); //adds 2nd card to hand2 
			hand.remove(1); //removes 2nd card from hand1
			
			//Deal another card to hand1
			x = theDeck.dealCard();
			hand.add(x);
			
			//Deal another card to hand2
			x = theDeck.dealCard();
			hand2.add(x);
			
			System.out.println("Hand 1: " +hand + " Hand2: " + hand2);
			handTotal =  sumCards();
			hand2Total = sumCards2();
			System.out.println("Respective sums: " 
					+ handTotal + "," +hand2Total);			
			again = 1; 
			}
		else if (willSplit == 0){
			splitted = false;
			again =1;
			}
		else if (willSplit !=0 && willSplit != 1){
			//in case user enters a number greater than 1 or text
			System.out.println("Invalid response");
			}
		}//end while
		return splitted;
	} // end playSplit
	
	public boolean getSplitted(){
		return splitted;
	}

	public boolean getBlackJack() {
		//Checks to see if initial hand contains BlackJack
		if (handTotal == 21){
			System.out.println("Player BlackJacks");
			BlackJack = true;
		}
		else{
			BlackJack = false;
		}
		
		return BlackJack;		
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
		
		for (int k = 0; k<hand2.size(); k++){
			indexValue =hand2.get(k).getValue();
			if (indexValue <=10 && indexValue !=1){
				cardValue = hand2.get(k).getValue();
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
		hand2.add(x);
		return hand2;
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

} // end class
