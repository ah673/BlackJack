import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;


public class GameTest {
	@Test
	public void AceTenHand_NotBust(){
		List<Card> aceTenHand = new ArrayList<Card>();
		aceTenHand.add(new BlackJackCard(Card.Face.ACE));
		aceTenHand.add(new BlackJackCard(Card.Face.TEN));
		boolean handBusted = BlackJackGame.isHandBust(aceTenHand); 
		
		assertEquals(handBusted, false); 
	}
}
