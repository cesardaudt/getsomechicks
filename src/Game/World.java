package Game;

import java.util.ArrayList;

public class World {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	public static final int NUMBER_CHICKENS = 5;
	public static final int NUMBER_PLAYERS = 1;
	protected ArrayList<Chicken> chickens;
	protected ArrayList<Player> players;
	
	public World(){
		this.chickens = new ArrayList<Chicken>();
		this.players = new ArrayList<Player>();
		
		//creates the chickens of the game 
		for(int i=0; i<NUMBER_CHICKENS; i++) {
			this.chickens.add(i, new Chicken(i*10, i*5));
		}
		
		//creates the players of the game
		for(int i = 0; i<NUMBER_PLAYERS; i++) {
			this.getPlayers().add(i, new Player(0, 0));
		}
		
		
	}

	public ArrayList<Chicken> getChickens() {
		return chickens;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
}
