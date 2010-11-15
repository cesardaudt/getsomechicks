package Game;

public abstract class Actor {
    private World world;

    private double speed;
    private double pos_x;
    private double pos_y;
    private double orientation;

    //direction_x and direction_y represent a normalized vector which is the direction where the actor is pointing
    private double direction_x;
    private double direction_y;
    private int lives;
    private int health;

    public Actor(World world_, double pos_x_, double pos_y_) {
        this.world = world_;
        this.pos_x = pos_x_;
        this.pos_y = pos_y_;
        this.speed = 0;

        //creates the actor pointing to 90 degrees
        this.orientation = 90;

        //we need to transform the orientation to radians in order to use cosine and sine functions
        this.direction_x = Math.cos(Math.toRadians(this.orientation));
        this.direction_y = Math.sin(Math.toRadians(this.orientation));

        this.lives = 1;
        this.health = 100;              
    }

    public void update() {
        move();
    }

    //given a point in 2d, moves the actor
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

        // Java math has some problems with sin and cos greater than 360 or smaller than 0
        // so we have to limit the orientation values
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

    // Other functions
    public boolean isAt(int x, int y) {
        return (this.pos_x == x && this.pos_y == y);
    }

    public boolean faceDirectionOfPoint(int x, int y) {
        int new_direction_x = x - this.pos_x;
        int new_direction_y = y - this.pos_y;

        int dist = Math.sqrt(Math.pow(new_direction_x, 2) + Math.pow(new_direction_y, 2));
        new_direction_x /= dist;
        new_direction_y /= dist;

        this.direction_x = new_direction_x;
        this.direction_y = new_direction_y;
    }
}
