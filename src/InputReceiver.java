import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;


public class InputReceiver {
	Scanner scanner = new Scanner(System.in); 
	Writer microphone = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public void say (String message){
		try {
			microphone.write(message); 
			microphone.flush(); 
		} catch (IOException e){
			System.err.println(e); 
		}
	}
	
	public void sayGreeting(){
		String greeting = "Let's Play Black Jack"; 
		say(greeting); 
	}
	
	public void notifyCardsDealt(){
		String cardsDealtMessage = "You have been dealt:\n";
		say(cardsDealtMessage); 
	}
	
	public void sayOptions(){
		String options = "(H)it or (S)tand?\n"; 
		say(options); 
	}

}
