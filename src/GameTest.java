import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;


public class GameTest {
	@Test
	public void ACETenHasMinValueOf11(){
		List<Card> hand = new ArrayList<Card>();
		hand.add(new BlackJackCard(Card.Face.ACE));
		hand.add(new BlackJackCard(Card.Face.TEN));
		
		int valueOfHand = BlackJackGame.minValueOf(hand);
		int actualMinValueOfHand = 11; 
		
		InputReceiver io = new InputReceiver(); 
		io.sayGreeting(); 
		
		assertThat(valueOfHand, is(actualMinValueOfHand));

	}
	
	@Test
	public void AceTenHand_NotBust(){
		List<Card> aceTenHand = new ArrayList<Card>();
		aceTenHand.add(new BlackJackCard(Card.Face.ACE));
		aceTenHand.add(new BlackJackCard(Card.Face.TEN));
		boolean handBusted = BlackJackGame.isHandBust(aceTenHand); 
		
		assertEquals(handBusted, false); 
	}
	
	@Test
	public void AceKingKingHand_NotBust(){
		List<Card> aceKingKingHand = new ArrayList<Card>();
		aceKingKingHand.add(new BlackJackCard(Card.Face.ACE));
		aceKingKingHand.add(new BlackJackCard(Card.Face.KING));
		aceKingKingHand.add(new BlackJackCard(Card.Face.KING));
		boolean handBusted = BlackJackGame.isHandBust(aceKingKingHand); 
		
		assertEquals(handBusted, false); 
	}
	
	@Test
	public void JackJackJackHand_Busted(){
		List<Card> jjjHand = new ArrayList<Card>();
		jjjHand.add(new BlackJackCard(Card.Face.JACK));
		jjjHand.add(new BlackJackCard(Card.Face.JACK));
		jjjHand.add(new BlackJackCard(Card.Face.JACK));
		boolean handBusted = BlackJackGame.isHandBust(jjjHand); 
		
		assertEquals(handBusted, true); 
	}
}
