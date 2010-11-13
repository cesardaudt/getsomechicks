import java.io.IOException;

import Game.Chicken;
import Game.Player;


public class Main {

	public static void inputFromUser() {
	
		char inKeyboard = ' ';
		
		try {
			inKeyboard = (char) System.in.read();	
		}
		catch (IOException e){
			System.out.println("Error reading from user");
		}
		
		switch(inKeyboard) {
			case 'w':
				System.out.println("I'm going up");
				break;
			case 'a':
				System.out.println("I'm going left");
				break;
			case 's':
				System.out.println("I'm going down");
				break;
			case 'd':	
				System.out.println("I'm going right");
				break;
			default:
				System.out.println("Gonna stay here");
		}
	}
	
	public static void refreshPositions() {
		
	}
	
	public static void redrawScene() {
		
	}
	
	public static void main(String[] args) {
		System.out.println("hello");
		
		Player player1 = new Player(10, 15);
		Chicken chick1 = new Chicken(15, 11);
		
		System.out.println("I'm here: <" + player1.getPosX() + ", " + player1.getPosY() + ">");
		System.out.println("Cocoricó: <" + chick1.getPosX()  + ", " + chick1.getPosY()  + ">");
		
		//this is the main loop of the game
		while(true){
			inputFromUser();
			//refreshPositions();
			//redrawScene();
			
		}
		
	}

}
