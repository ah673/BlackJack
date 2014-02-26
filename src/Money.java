//********************************
// 
// Objects of this class will keep
// track of how much money the user has left
//
// Written by Amy Ho
// UNI: ah2703
//*********************************

import java.util.Scanner;

public class Money {  
	private static double cashLeft;
	private static double betAmt;
	private double nextBet;
	private boolean win;
	private boolean tie = false;
	private Game theGame;


	
	Scanner input = new Scanner(System.in);
	
	public void buyCoins() {
		int buyInCheck = 1; //used to check if buyIn is valid
		
		System.out.println("Please enter a minimum buy-In of $100.00");
		
		//Check for buy-in is greater than $100; 
		while (buyInCheck == 1){
			cashLeft = input.nextDouble();
			if (cashLeft >=100.00){
				System.out.println("Player currently has: $" +cashLeft);
				buyInCheck = 0; 
			}
			else
				System.out.println("Please make a Buy-in of larger than $100.00 ");
		}
			
		} // end buyCoins

	
	public void bets(){
		int betCheck = 1; 
		
		//Check for valid bet;
		while (betCheck == 1){
			System.out.println("Please bet a minimum of $10.00");
			betAmt = input.nextDouble();
			if (betAmt > cashLeft || betAmt > 1000 || betAmt < 10){
				System.out.println("This is not a valid bet. Please bet again.");
			}
			else {
				System.out.println("Your bet: $" +betAmt);
				betCheck = 0;
			}
		}
	}
	
	public void doubleBet(){
		int betCheck = 1; 
		
		//Check for valid bet;
		while (betCheck == 1){
			System.out.println("Please bet again a maximum of $" +betAmt);
			nextBet = input.nextDouble();
			
			if (betAmt >= cashLeft || betAmt > 1000 || betAmt < 10 
					|| nextBet > betAmt || nextBet + betAmt > cashLeft){
				System.out.println("This is not a valid bet.");
			}
			else {
				betAmt = betAmt+ nextBet;
				System.out.println("Your new bet: $" +betAmt);
				betCheck = 0;
			}
		}
	}
	
	
	public void winLose(){
		//determine how to allocate money
		theGame = new Game();
		tie = theGame.getTie();
		
		if (tie){
			// if no tie
			System.out.println("Tie. You now have: $" +cashLeft);
			tie = false;
		}
		else {
			// if no tie

			win = theGame.whoWon();
			if (win){ 
				//if player wins
				cashLeft = (cashLeft + betAmt);
				System.out.println("You won. You now have: $" +cashLeft);
			}
			
			else{
				//if player loses 
				cashLeft = cashLeft - betAmt;
				System.out.println("You've lost. You now have: $" +cashLeft);
			}
		}
	} // end winLose
	
	public void winLose2(){
		theGame = new Game();
		tie = theGame.getTie();
		
		if (tie){
			// if no tie
			System.out.println("Tie. You now have: $" +cashLeft);
			tie = false;
		}
		else {
			// if no tie

			win = theGame.whoWon();
			if (win){ 
				//if player wins
				cashLeft = (cashLeft + betAmt);
				System.out.println("You won. You now have: $" +cashLeft);
			}
			
			else{
				//if player loses 
				cashLeft = cashLeft - betAmt;
				System.out.println("You've lost. You now have: $" +cashLeft);
			}
		}
	} // end winLose
	
	public void payBlackJack(){
		//method to play player 1.5x if player receives Black Jack hand
		cashLeft = cashLeft+(1.5*betAmt);
		System.out.println("Black Jack pays 3 to 2. You now have: $" +cashLeft); 
	}
	
	public void payDouble(){
		//method to determine allocations if player double downs
		theGame = new Game();
		win = theGame.whoWon();
		tie = theGame.getTie();
		
		if (tie){
			System.out.println("Tie. You now have: $" +cashLeft);
		}
		
		else {
			if (win){
			//if player wins Double Down
			cashLeft = cashLeft + betAmt;
			System.out.println("You won. You now have: $" +cashLeft);
			}
			else {
			//if player loses Double Down
			cashLeft = cashLeft - betAmt;
			System.out.println("You've lost. You now have: $" +cashLeft);
			}
			
		}
	}
	
	
	public double getCash(){
		return cashLeft;
	}
	
	public double getBet(){
		return betAmt;
	}
	}// end Class


