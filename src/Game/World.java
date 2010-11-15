package Game;

import java.util.ArrayList;

public class World {
    public static final int WIDTH           = 600;
    public static final int HEIGHT          = 600;
    public static final int NUMBER_CHICKENS = 5;
    public static final int NUMBER_PLAYERS  = 1;

    protected ArrayList<Chicken> chickenList;
    protected ArrayList<Player>  playerList;

    protected Random rand = new Random();

    public World() {
	this.chickenList = new ArrayList<Chicken>();
	this.playerList  = new ArrayList<Player>();

	//creates the chickens
	for (int i = 0; i < NUMBER_CHICKENS; i++) {
	    this.chickenList.add(i, new Chicken(this, rand.nextInt(WIDTH), rand.nextInt(HEIGHT)));
	}

	//creates the players
	//TODO: are we going to have multiple players? if so, we need a way to make their controls nonconflicting
	for (int i = 0; i < NUMBER_PLAYERS; i++) {
	    this.getPlayerList().add(i, new Player(this, 0, 0));
	}
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
    }

    public void checkCollisions() {
	//TODO
    }
}
