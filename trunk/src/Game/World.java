package Game;

import java.util.ArrayList;

public class World {
    public static final int WIDTH            = 600;
    public static final int HEIGHT           = 600;
    public static final int INITIAL_CHICKENS = 5;

    protected ArrayList<Chicken> chickenList;

    private Player player;

    protected Random rand = new Random();

    public World() {
	this.chickenList = new ArrayList<Chicken>();
	this.playerList  = new ArrayList<Player>();

	//creates the chickens
	for (int i = 0; i < INITIAL_CHICKENS; i++) {
	    this.chickenList.add(i, new Chicken(this, rand.nextInt(WIDTH), rand.nextInt(HEIGHT)));
	}

	//creates the player
        this.player = new Player(this, 0, 0);
    }

    public ArrayList<Chicken> getChickenList() {
	return chickenList;
    }

    public ArrayList<Player> getPlayerList() {
	return playerList;
    }

    public void update() {
	Iterator iterator;

	// TODO: refactor? maybe make a new class from arraylist?
	iterator = chickenList.iterator();
	while (iterator.hasNext()) {
	    iterator.next().update();
	}

	iterator = playerList.iterator();
	while (iterator.hasNext()) {
	    iterator.next().update();
	}

        checkCollisions();
    }

    public void checkCollisions() {
	iterator = chickenList.iterator();
	while (iterator.hasNext()) {
	    if (iterator.collidesWith(player)) {
                player.addToScore(iterator.getValue());
                iterator.destroy();
            }
	}
    }
}
