package Game;

public class Chicken extends Actor {
    private final int MAX_SPEED = 5;

    private int x_dest;
    private int y_dest;
    private int chillTimer;

    public Chicken(World world_, double x_, double y_) {
	super(world_, x_, y_);

	x_dest = pos_x;
	y_dest = pos_y;

	chillTimer = world.rand.nextInt(100);
    }

    @Override
    public void update() {
	if (isAt(x_dest, y_dest)) {
	    if (chillTimer == 0) {
		this.speed = 1 + world.rand.nextInt(MAX_SPEED - 1);
		chooseNewDestination();
	    }
	    else {
		this.speed = 0;
		chillTimer--;
	    }
	}

	super();
    }

    private void chooseNewDestination() {
	this.x_dest = world.rand.nextInt(world.WIDTH);
	this.y_dest = world.rand.nextInt(world.HEIGHT);
	chillTimer = world.rand.nextInt(200);

	faceDirectionOfPoint(x_dest, y_dest);
    }
}
