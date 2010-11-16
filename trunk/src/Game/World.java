package Game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class World {
	public static int high_score;
	
	public final int WIDTH            = 320;
	public final int HEIGHT           = 240;
	public final int INITIAL_CHICKENS = 2;
	public final int TOTAL_CHICKENS   = 20;
	public final int CHICKENS_ADDED   = 3;
	
	protected Random rand = new Random();
	
	protected ArrayList<Chicken> chickenList;
	protected Player player;
	
	protected int chicken_count;

	public World() {
		this.chickenList = new ArrayList<Chicken>();
		chicken_count = TOTAL_CHICKENS;

		addChickens(INITIAL_CHICKENS);

		//creates the player
		this.player = new Player(this, 0, 0);
	}

	public void update() {
		if (getPlayer().isAlive()) {
			player.update();
			
			Iterator<Chicken> iterator;
			
			//updates the chickens
			iterator = chickenList.iterator();
			while (iterator.hasNext()) {
				iterator.next().update();
			}

			checkCollisions();
		}
	}

	public void checkCollisions() {
		Iterator<Chicken> iterator;
		
		iterator = chickenList.iterator();
		while (iterator.hasNext()) {
			Chicken current_chicken = iterator.next();
			if (current_chicken.collidesWith(player)) {
				player.addToScore(current_chicken.getValue());
				player.gainFuel();
				current_chicken.destroyActor();
				chickenList.remove(chickenList.indexOf(current_chicken));
				
				if (getChickenList().size() == 0) {
					addChickens(CHICKENS_ADDED);
				}
			}
		}
	}
	
	public void addChickens(int chickens) {
		if (chickens > chicken_count) {
			chickens = chicken_count;
		}
		
		this.chicken_count -= chickens;
		
		for (int i = 0; i < chickens; i++) {
			this.chickenList.add(i, new Chicken(this, rand.nextInt(WIDTH), rand.nextInt(HEIGHT)));
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
