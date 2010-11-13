import java.io.IOException;

import Game.Chicken;
import Game.Player;


public class Main {

	private static final double INCREMENT_SPEED = 5;
	private static final double ROTATION_INCREMENT = 10;

	public static void inputFromUser(Player player) {
	
		char inKeyboard = ' ';
		
		try {
			inKeyboard = (char) System.in.read();	
		}
		catch (IOException e){
			System.out.println("Error reading from user");
		}
		
		switch(inKeyboard) {
			//move up
			case 'w':
				player.setSpeed(player.getSpeed()+INCREMENT_SPEED);
				player.move();
				break;
			//break (move backwards)
			case 's':
				player.setSpeed(player.getSpeed()-INCREMENT_SPEED);
				player.move();
				break;
			//turn to left
			case 'a':
				player.setOrientation(player.getOrientation()+ROTATION_INCREMENT);
				player.move();
				break;
			//turn to right
			case 'd':	
				player.setOrientation(player.getOrientation()-ROTATION_INCREMENT);
				player.move();
				break;
			//does nothing
			default:
				player.setSpeed(0);
		}
	}
	
//	public static void refreshGameStatus() {
		
//	}
	
//	public static void redrawScene() {
		
//	}
	
	public static void main(String[] args) {
		System.out.println("hello");
		
		Player player1 = new Player(10, 15);
		Chicken chick1 = new Chicken(15, 11);
		
		System.out.println("Cocoricó: <" + chick1.getPosX()  + ", " + chick1.getPosY()  + ">");
		
		//this is the main loop of the game
		while(true){
			inputFromUser(player1);
			System.out.println("I'm here: <" + player1.getPosX() + ", " + player1.getPosY() + ">" + "Theta:" + player1.getOrientation());
			//refreshGameStatus();
			//redrawScene();
			
		}
		
	}

}
