package Game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class World {
	public final int WIDTH            = 320;
	public final int HEIGHT           = 240;
	public final int INITIAL_CHICKENS = 5;
	
	protected Random rand = new Random();
	
	protected ArrayList<Chicken> chickenList;
	protected Player player;

	public World() {
		this.chickenList = new ArrayList<Chicken>();

		//creates the chickens
		for (int i = 0; i < INITIAL_CHICKENS; i++) {
			this.chickenList.add(i, new Chicken(this, rand.nextInt(WIDTH), rand.nextInt(HEIGHT)));
		}

		//creates the player
		this.player = new Player(this, 0, 0);
	}

	public void update() {
		Iterator<Chicken> iterator;
		
		//updates the chickens
		iterator = chickenList.iterator();
		while (iterator.hasNext()) {
			iterator.next().update();
		}

		//updates the player
		player.update();

		checkCollisions();
	}

	public void checkCollisions() {
		Iterator<Chicken> iterator;
		
		iterator = chickenList.iterator();
		while (iterator.hasNext()) {
			Chicken current_chicken = iterator.next();
			if (current_chicken.collidesWith(player)) {
				player.addToScore(current_chicken.getValue());
				current_chicken.destroy();
				chickenList.remove(chickenList.indexOf(current_chicken));
			}
		}
	}
	
	//Getters
	public ArrayList<Chicken> getChickenList() {
		return chickenList;
	}
	
	public Player getPlayer() {
		return player;
	}

}
