import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DeckTests {
	private static final int TOTAL_CARDS_PER_DECK = Card.NUM_OF_FACES * Card.NUM_OF_SUITS; 
	
	@Test
	public void startingDeckHas52Cards(){
		Deck deck = new Deck(); 
		assertThat(deck.cards, hasSize(TOTAL_CARDS_PER_DECK)); 
	}
}