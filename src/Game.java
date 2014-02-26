//******************************
//	The class establishes the rules 
//	for how Black Jack is played
//
//	Written by Amy Ho
//	UNI (ah2703)
//
//******************************
public class Game {
	
	private Player p1; 
	private Dealer p2; 
	private Money p1Cash; 
	private Deck deck;
	private int playerTotal;
	private int playerTotal2; //2nd hand's sum
	private int dealerTotal;
	private static boolean playerWon;
	private static boolean push;
	private static boolean p1BlackJack;
	private static boolean p2BlackJack;
	private static boolean playedSplit;


	
	public Game() {
		p1=new Player();
		p2 = new Dealer();
		p1Cash = new Money();
		deck = new Deck();
		playerTotal = p1.getTotal();
		playerTotal2 = p1.getTotal2();

	}
	
	public void play(){
		
		deck.shuffle();
		boolean playedDD = true;
		
		while (p1Cash.getCash()>9){
			//will play only when user possesses more than $9
			//since the minimum bet is $10
			p1.play();
			p2.play();
			p2BlackJack = p2.getBlackJack(); //check for BlackJacks
			
			playedSplit = p1.getSplitted(); //check for doubles in Player's hand
			if (playedSplit){
				//if user requested to split
				p1.action(); 
				playerWin(); //determines if 1st hand wins
				p1.action2(); //can draw for 2nd hand now
				
				if (playerTotal <=21 || playerTotal2 <=21){
					//dealer will draw only if player does not bust either hand
					p2.action();
				}
				playerWin2(); //determines if 2nd hand wins
				p1Cash.winLose2(); //allocate the cash
				}
			else{
				p1BlackJack = p1.getBlackJack();
			}
			
			if (p1BlackJack==false && p2BlackJack==false && playedSplit ==false){
				//if neither has Black Jack and player decides not to split, if applicable
				playedDD = p1.playDD(); // DoubleDown
				
				if (playedDD == true){
					if (playerTotal <= 21){
						p2.action();
						}
					playerWin();
					p1Cash.payDouble();
				}
				
				else {
					//if Doubled down, then can't hit again
					p1.action();
					playerTotal = p1.getTotal();
					if (playerTotal <= 21){
						p2.action();
						}
					playerWin();
					p1Cash.winLose();
					}
				
				}
			
			else if (p1BlackJack==true || p2BlackJack == true){
				//if either player has a starting Black Jack hand
				playerWin();
				p1Cash.payBlackJack();
				}
		} // end while 
		
		System.out.println("Thanks for playing!");
		
		
		} //end play*/
	
	
	public void playerWin2() {
		playerTotal = p1.getTotal2();
		dealerTotal = p2.getTotal();
		push = false;
		
		if (playerTotal == dealerTotal){
			push = true;
		}
			else {
				//if neither hands are equal
				if (playerTotal <= 21){
					if (dealerTotal > 21 || playerTotal > dealerTotal){
					playerWon = true;
					push = false;
				}
					else if (playerTotal < dealerTotal){
					playerWon = false;
					push = false;
				}
			}
				else{
				//if player busts
				playerWon = false;
				push = false;
			}
		}
	}

	public void playerWin(){
		
		playerTotal = p1.getTotal();
		dealerTotal = p2.getTotal();
		push = false;
		
		//check for BlackJacks
		if (p1BlackJack || p2BlackJack){
			if (p1BlackJack && p2BlackJack){
				push = true;
			}
			if (p2BlackJack){
				//if only dealer gets a Black Jack
				System.out.println("Dealer BlackJacks");
				playerWon = false;
				push = false;
			}
		} // end check for BlackJacks
		
		else {
		//if neither players got a Black Jack
			if (playerTotal == dealerTotal){
				push = true;
			}
			else {
				//if neither hands are equal
				if (playerTotal <= 21){
					if (dealerTotal > 21 || playerTotal > dealerTotal){
					playerWon = true;
					push = false;
				}
					else if (playerTotal < dealerTotal){
					playerWon = false;
					push = false;
				}
			}
				else{
				//if player busts
				playerWon = false;
				push = false;
			}
		}
		}//end false push 
		
	} // end playerWin
	
	public boolean whoWon(){
		return playerWon;
	}
	
	public boolean getTie(){
		return push;
	}
	
	} // end class
		

