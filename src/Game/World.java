package Game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class World {
	public static int high_score = 0;
	
	public final int WIDTH            = 640;
	public final int HEIGHT           = 480;
	public final int INITIAL_CHICKENS = 2;
	public final int TOTAL_CHICKENS   = 42;
	public final int CHICKENS_ADDED   = 3;
	
	protected Random rand = new Random();
	
	protected ArrayList<Chicken> chicken_list;
	protected Player player;
	
	protected int chicken_count;

	public World() {
		this.chicken_list = new ArrayList<Chicken>();
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
			iterator = chicken_list.iterator();
			while (iterator.hasNext()) {
				iterator.next().update();
			}

			checkCollisions();
		}
	}

	public void checkCollisions() {
		Iterator<Chicken> iterator;
		
		iterator = chicken_list.iterator();
		while (iterator.hasNext()) {
			Chicken current_chicken = iterator.next();
			if (current_chicken.collidesWith(player)) {
				player.addToScore(current_chicken.getValue());
				player.gainFuel();
				current_chicken.destroyActor();
				chicken_list.remove(chicken_list.indexOf(current_chicken));
				
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
			this.chicken_list.add(i, new Chicken(this, rand.nextInt(WIDTH-Chicken.CHICKEN_WIDTH), rand.nextInt(HEIGHT-Chicken.CHICKEN_HEIGHT)));
		}
	}
	
	//Getters
	public static int getHighScore() {
		return high_score;
	}
	
	public ArrayList<Chicken> getChickenList() {
		return chicken_list;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	//Setters
	public static void setHighScore(int score) {
		high_score = score;
	}
}
