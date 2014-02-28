import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*; 
import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.util.*;

public class BlackJackPlayerTest {
	@Test
	public void ACECardReceivedByPlayer(){ 
		BlackJackPlayer player = new BlackJackPlayer();
		BlackJackCard aceCard = new BlackJackCard(Card.Face.ACE);
		Card[] dealtHand = new BlackJackCard[]{aceCard};
		
		player.receiveCard(aceCard); 
		
		assertThat(player.primaryHand, contains(dealtHand)); 
	}
	
	@Test
	public void addingValue
	

}
