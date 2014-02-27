import java.util.List;

public class BlackJackGame {
	public static final int WIN_VALUE = 21; 
	private BlackJackPlayer human; 
	private BlackJackPlayer dealer;  
	private Shoe shoe;
	
	public BlackJackGame() {
		human = new Player();
		dealer = new Dealer();
		shoe = new Shoe();
	}
	
	public void startGame(){
		dealCardTo(dealer);
		dealCardTo(human);
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
	
	public boolean isHandBust(List<Card> hand){
		if (minValueOf(hand) > WIN_VALUE)
			return true; 
		return false;
	}
}
		

