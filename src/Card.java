public class Card {
                         
    private int value; 
      
    public Card(int v) {
        value = v;
    }
        
    public int getValue() {
        return value;
    }
    
    
    public String valuetoString() {
        // Return a String representing the card.
    	// A 1 is an ACE, a 11 is a Jack. 
    	// values do not represent the true worth of the cards
    	
    	if(value==1)		return "A";
		else if(value==2) 	return "2";
		else if(value==3)	return "3";
        else if(value==4)   return "4";
        else if(value==5)   return "5";
        else if(value==6)   return "6";
        else if(value==7)   return "7";
        else if(value==8)   return "8";
        else if(value==9)   return "9";
        else if(value==10)  return "10";
        else if(value==11)  return "J";
        else if(value==12)  return "Q";
        else return "K";
        }
    
    public String toString() {
    	return valuetoString();
    }


} // end class Card
