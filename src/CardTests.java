import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.hamcrest.core.Is.*;

public class CardTests {
	@Test
	public void aceCardIsACE(){
		Card aceCard = new BlackJackCard(Card.Face.ACE); 
		assertEquals(Card.Face.ACE, aceCard.cardFace); 
	}
	
	@Test
	public void queenCardIsQUEEN(){
		Card queenCard = new BlackJackCard(Card.Face.QUEEN); 
		assertEquals(Card.Face.QUEEN, queenCard.cardFace); 
	}
	
	@Test
	public void queenCardValuedAt10(){
		BlackJackCard queenCard = new BlackJackCard(Card.Face.QUEEN); 
		int cardFaceValue = queenCard.value();
		int actualFaceValue = 10;
		
		assertEquals(cardFaceValue, actualFaceValue); 
	}
}
