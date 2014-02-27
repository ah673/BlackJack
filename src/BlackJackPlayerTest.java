import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import static org.junit.Assert.*; 

import org.junit.Test;

public class BlackJackPlayerTest {
	@Test
	public void ACECardReceivedByDealer(){ 
		Dealer dealer = new Dealer();
		Card aceCard = new Card(Card.Face.ACE);
		Card[] dealtHand = new Card[]{aceCard};
		
		dealer.receiveCard(aceCard); 
		assertThat(dealer.hand, contains(dealtHand)); 
	}

}
