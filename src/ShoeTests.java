import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class ShoeTests {
	private static final int TOTAL_CARDS_PER_DECK = Card.NUM_OF_FACES * Card.NUM_OF_SUITS; 
	
	@Test
	public void startingDeckHas52Cards(){
		Shoe shoe = new Shoe(); 
		assertThat(shoe.cards, hasSize(TOTAL_CARDS_PER_DECK)); 
	}
	
	@Test
	public void deckContainsOneLessCardAfterDeal(){
		Shoe shoe = new Shoe();
		int cardsBeforeDealing = shoe.cardsLeft(); 
		shoe.dealCard();
		int cardsAfterDealing = shoe.cardsLeft(); 
		assertThat(cardsAfterDealing, is(cardsBeforeDealing - 1)); 
	}
}