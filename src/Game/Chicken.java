package Game;

public class Chicken extends Actor {
	public final static int CHICKEN_GROUP  = 2;
    public final static int CHICKEN_WIDTH  = 32; 
    public final static int CHICKEN_HEIGHT = 32;
    public final static int CHICKEN_VALUE  = 10;
    public final static int MAX_SPEED      = 5;

    private double x_dest;
    private double y_dest;
    private int waitTimer;
    private int value;

    public Chicken(World world_, double x_, double y_) {
    	super(world_, x_, y_, CHICKEN_GROUP, "gfx_chicken", CHICKEN_WIDTH, CHICKEN_HEIGHT, "chicken");

    	x_dest = x;
    	y_dest = y;
    	value = CHICKEN_VALUE; 

    	waitTimer = this.world.rand.nextInt(100);
    }

    @Override
    public void update() {
		if (isAt(x_dest, y_dest)) {
		    if (waitTimer == 0) {
		    	// If we're at our destination and the timer is 0, pick a new one
		    	this.speed = 1 + world.rand.nextInt(MAX_SPEED - 1);
		    	chooseNewDestination();
		    }
		    else {
		    	this.speed = 0;
		    	waitTimer--;
		    }
		}
    }

    private void chooseNewDestination() {
		this.x_dest = world.rand.nextInt(world.WIDTH  - width  - 1);
		this.y_dest = world.rand.nextInt(world.HEIGHT - height - 1);
		
		waitTimer = world.rand.nextInt(200);
	
		faceDirectionOfPoint(x_dest, y_dest);
    }

    public void destroyActor() {
    	remove();
    }

	public int getValue() {
		return this.value;
	}
}
