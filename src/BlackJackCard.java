
public class BlackJackCard extends Card {

	public BlackJackCard(Face cardFace) {
		super(cardFace);
	}

	public int value(){
		switch(cardFace){
			case ACE: 
				return 1;
			case TWO:
				return 2; 
			case THREE:
				return 3; 
			case FOUR: 
				return 4; 
			case FIVE:
				return 5; 
			case SIX: 
				return 6; 
			case SEVEN:
				return 7; 
			case EIGHT: 
				return 8; 
			case NINE: 
				return 9; 
			default: 
				return 10; 
		}
	}
}
