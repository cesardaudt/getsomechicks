package Game;

public class Chicken extends Actor {
    private final static int CHICKEN_GROUP = 2;
    private final static int CHICKEN_WIDTH = 16; 
    private final static int CHICKEN_HEIGHT = 16;
    private final static int CHICKEN_VALUE = 10;
    private final static int MAX_SPEED = 5;

    private double x_dest;
    private double y_dest;
    private int chillTimer;
    private int value;

    public Chicken(World world_, double x_, double y_) {
    	super(world_, x_, y_, CHICKEN_GROUP, "gfx_chicken", CHICKEN_WIDTH, CHICKEN_HEIGHT, "chicken");

    	x_dest = x;
    	y_dest = y;
    	value = CHICKEN_VALUE; 

    	chillTimer = this.world.rand.nextInt(100);
    }

    @Override
    public void updateSpecific() {
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
    }

    private void chooseNewDestination() {
		this.x_dest = world.rand.nextInt(world.WIDTH  - width  - 1);
		this.y_dest = world.rand.nextInt(world.HEIGHT - height - 1);
		
		chillTimer = world.rand.nextInt(200);
	
		faceDirectionOfPoint(x_dest, y_dest);
    }

    public void destroyActor() {
        // TODO add another chicken
    	remove();
    }

	public int getValue() {
		return this.value;
	}
}
