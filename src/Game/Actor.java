package Game;

public abstract class Actor {
  
	protected double speed;
	protected double pos_x;
	protected double pos_y;
	protected double orientation;
	//direction_x and direction_y represents a normalized vector to where the actor is pointing
	protected double direction_x;
	protected double direction_y;
	protected int lives;
	protected int health;
		
	public Actor(double pos_x, double pos_y) {
		
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.speed = 0;
		//creates the actor pointing to 90 degrees
		this.orientation = 90;
		//we need to transform the orientation to radians, in order to use cosine and sine functions
		this.direction_x = Math.cos(Math.toRadians(this.orientation));
		this.direction_y = Math.sin(Math.toRadians(this.orientation));
		this.lives = 1;
		this.health = 100;		
	}
	
	//given a point in 2-d, moves the actor
	public void move() {
		
		this.pos_x += this.speed * this.direction_x;
		this.pos_y += this.speed * this.direction_y;
		
		//here we see if we passed the limits of the game area		
		if(this.speed * this.direction_x < 0) {
			this.pos_x = 0;
		}
		else if(this.speed * this.direction_x >= World.WIDTH) {
			this.pos_x = World.WIDTH - 1;
		}
		
		if(this.speed * this.direction_y < 0) {
			this.pos_y = 0;
		}
		else if(this.speed * this.direction_y >= World.HEIGHT) {
			this.pos_y = World.HEIGHT - 1;
		}
	}

	//Setters
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setOrientation(double orientation) {
		this.orientation = orientation;
		
		//maybe Java math has some problems with sin and cos greater than 360 or smaller than 0
		//so we've to limit the orientation values
		if(this.orientation >= 360) {
			this.orientation -= 360;
		}
		else if(this.orientation < 0) {
			this.orientation += 360;
		}
		this.direction_x = Math.cos(Math.toRadians(this.orientation));
		this.direction_y = Math.sin(Math.toRadians(this.orientation));
		
	}
	
	//Getters
	public double getSpeed() {
		return this.speed;
	}
	
	public double getPosX() {
		return this.pos_x;
	}
	
	public double getPosY() {
		return this.pos_y;
	}
	
	public double getDirectionX() {
		return this.direction_x;
	}
	
	public double getDirectionY() {
		return this.direction_y;
	}
	
	public double getOrientation() {
		return this.orientation;
	}
	
}
