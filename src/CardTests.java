import org.junit.Test;


public class CardTests {
	@Test
	public void aceCardIsACE(){
		Card ace = new Card(Card.Face.ACE); 
		assertEquals(Card.Face.ACE, ace.cardFace); 
	}
}
