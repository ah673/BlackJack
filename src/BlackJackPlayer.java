import java.util.*;

public class BlackJackPlayer {
	
	protected List<Card> primaryHand = new ArrayList<Card>();
	
	
	public void receiveCard(Card... dealtCard) { 
		for (Card card : dealtCard){
			primaryHand.add(card); 
		}
	}
	
	public boolean isHandBust(List<Card> hand){
		if (BlackJackGame.minValueOf(hand) > BlackJackGame.WIN_VALUE)
			return true; 
		return false;
	}
	
}
