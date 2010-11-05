package Game;

public abstract class Actor {
  
	protected double speed;
	protected double pos_x;
	protected double pos_y;
	protected double direction_x;
	protected double direction_y;
	protected double orientation;
		
	public Actor(double pos_x, double pos_y) {
		
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.speed = 0;
		this.direction_x = 0;
		this.direction_y = 0;
		this.orientation = 0;
		
	}
	
	public void move(double pos_x, double pos_y) {
		
	}

	//Setters
	public void setSpeed(double speed) {
		
	}
	
	public void setPos(double pos_x, double pos_y) {
		
	}
	
	public void setDirection(double dir_x, double dir_y) {
		
	}
	
	public void setOrientation(double orientation) {
		
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
