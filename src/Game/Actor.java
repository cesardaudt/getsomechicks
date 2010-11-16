package Game;

import jgame.JGColor;
import jgame.JGObject;

public abstract class Actor extends JGObject {
    private World world;

    private double speed;
    private double orientation;

    private int width;
    private int height;
    private int diameter; // diameter of bounding circle

    //direction_x and direction_y are a normalized vector which is the direction where the actor is pointing
    private double direction_x;
    private double direction_y;
    private int lives;
    private int health;
    private int value;

    public Actor(World world_, double pos_x_, double pos_y_, int collision_ID_, String sprite_, int width_, int height_, String name_, int value_) {
        super(
            name_,
            true, // unique
            pos_x_,
            pos_y_,
            collision_ID_, // determines which objects collide with each objects
            sprite_
            );

        this.world = world_;
        this.speed = 0;

        this.width = width_;
        this.height = height_;
        this.diameter = Math.max(width, height);

        //creates the actor pointing to 90 degrees
        this.setOrientation(90);

        this.lives = 1;
        this.health = 100;              
        this.value = value_;
    }

    public void move() {
        this.xspeed = this.speed * this.direction_x;
        this.yspeed = this.speed * this.direction_y;

        // check arena boundaries
        if (this.x < 0) {
            this.x = 0;
            this.xspeed = 0;
        }
        else if (this.x >= World.WIDTH) {
            this.x = World.WIDTH - 1;
            this.xspeed = 0;
        }

        if (this.y < 0) {
            this.y = 0;
            this.yspeed = 0;
        }
        else if (this.y >= World.HEIGHT) {
            this.y = World.HEIGHT - 1;
            this.yspeed = 0;
        }

        // JGame now adds xspeed and yspeed to x and y
    }

    public void paint() {
        setColor(JGColor.yellow);
        drawOval(x, y, 16, 16, true, true);
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
        return this.x;
    }

    public double getPosY() {
        return this.y;
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

    public double getDiameter() {
        return this.diameter;
    }

    // Other functions
    public boolean isAt(int x, int y) {
        return (this.x == x && this.y == y);
    }

    private double distance(x1,y1, x2,y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

    public boolean collidesWith(Actor other) {
        return (distance(this.getPosX(),this.getPosY(), other.getPosX(),other.getPosY()) 
                < (this.getDiameter() + other.getDiameter()));
    }

    public void faceDirectionOfPoint(int x, int y) {
        double new_direction_x = x - this.x;
        double new_direction_y = y - this.y;

        double dist = Math.sqrt(Math.pow(new_direction_x, 2) + Math.pow(new_direction_y, 2));
        new_direction_x /= dist;
        new_direction_y /= dist;

        this.direction_x = new_direction_x;
        this.direction_y = new_direction_y;
    }

    public void destroy() {
        // Should be overriden by children.
    }
}
