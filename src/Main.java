import java.io.IOException;

import Game.Chicken;
import Game.Player;
import Game.World;


public class Main {

	private static final double INCREMENT_SPEED = 10;
	private static final double ROTATION_INCREMENT = 5;
	private static World world;

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
				player.move();
		}
	}
	
//	public static void refreshGameStatus() {
		
//	}
	
//	public static void redrawScene() {
		
//	}
	
	public static void main(String[] args) {

		world = new World();
		
		for(int i=0; i<World.NUMBER_CHICKENS; i++) {
			System.out.println("Chicken #" + i + " sayin' hello from " + "<"  + 
								world.getChickens().get(i).getPosX()   + ", " +
								world.getChickens().get(i).getPosY()   + ">");	
			
		}
		
		//this is the main loop of the game
		while(true){
			for(int i=0; i<World.NUMBER_PLAYERS; i++) {
				inputFromUser(world.getPlayers().get(i));
				
				System.out.println("I'm here: <" + world.getPlayers().get(i).getPosX() + ", " + 
						world.getPlayers().get(i).getPosY() + ">" + "Theta:" + 
						world.getPlayers().get(i).getOrientation()+ "Dir <"  +
						world.getPlayers().get(i).getDirectionX() + ", "     +
						world.getPlayers().get(i).getDirectionY()+ ">");
			}
			
			//refreshGameStatus();
			//redrawScene();
			
		}
		
	}

}
