import java.util.*;

public class BlackJackGame {
	private static final int WIN_VALUE = 21; 
	private static final int INITIAL_HAND_SIZE = 2; 
	
	protected BlackJackPlayer human; 
	private BlackJackPlayer dealer;  
	private Shoe shoe;
	
	public BlackJackGame() {
		dealer = new Dealer();
		human = new Player();
		shoe = new Shoe();
		
	}
	
	public void startGame(){
		dealInitialTwoCards();
	}

	private void dealInitialTwoCards() {
		for (int i = 0; i < INITIAL_HAND_SIZE; i++){
			dealCardTo(dealer);
			dealCardTo(human);
		}
	}

	private void dealCardTo(BlackJackPlayer recipient) {
		Card card = shoe.dealCard();
		recipient.receiveCard(card); 
	}
	
	protected static int minValueOf(List<Card> hand){
		int valueOfHand = 0; 
		for (Card card : hand){
			valueOfHand += card.value();
		}
		return valueOfHand; 
	}
	
	public static boolean isHandBust(List<Card> hand){
		if (minValueOf(hand) > WIN_VALUE)
			return true; 
		return false;
	}
}
		

