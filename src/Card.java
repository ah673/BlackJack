public class Card {
	public static final int NUM_OF_SUITS = 4;
	public final Face cardFace;
	
	public enum Face {
		ACE, TWO, THREE, FOUR, FIVE, 
		SIX, SEVEN, EIGHT, NINE, TEN,
		JACK, QUEEN, KING
	}
	  
    public Card(Face cardFace) {
        this.cardFace = cardFace;
    }
        

}
