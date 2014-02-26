import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CardTests {
	@Test
	public void aceCardIsACE(){
		Card aceCard = new Card(Card.Face.ACE); 
		assertEquals(Card.Face.ACE, aceCard.cardFace); 
	}
	
	@Test
	public void queenCardIsQUEEN(){
		Card queenCard = new Card(Card.Face.QUEEN); 
		assertEquals(Card.Face.QUEEN, queenCard.cardFace); 
	}
}
