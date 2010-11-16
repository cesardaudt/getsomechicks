package Game;

public class Player extends Actor {
    private static final double ROTATION_INCREMENT = 3;
    private static final double SPEED_INCREMENT    = 0.01;
    private static final double SPEED_LIMIT        = 2;

    private int score;
    private boolean isIdle;

    private final static int PLAYER_GROUP = 1;
    private final static int PLAYER_WIDTH = 16; 
    private final static int PLAYER_HEIGHT = 16;

    public Player(World world_, double x_, double y_) {
        super(world_, x_, y_, PLAYER_GROUP, "gfx_player", PLAYER_WIDTH, PLAYER_HEIGHT, "player");

        this.setScore(0);
    }

    @Override
    public void update() {
        if (isIdle) {
            decelerate();

            // The input loop will set this to true if no key is pressed
            isIdle = false;
        }
    }

    public void speedUp() {
        this.speed += SPEED_INCREMENT;

        if (this.speed > SPEED_LIMIT) {
            this.speed = SPEED_LIMIT;
        }
    }

    public void speedDown() {
        this.speed -= SPEED_INCREMENT;

        if (this.speed < -SPEED_LIMIT) {
            this.speed = -SPEED_LIMIT;
        }
    }

    public void rotateRight() {
        this.setOrientation(this.getOrientation() + ROTATION_INCREMENT);
    }

    public void rotateLeft() {
        this.setOrientation(this.getOrientation() - ROTATION_INCREMENT);
    }

    private void decelerate() {
        final double DECELERATION_RATE = 0.1;

        if (this.speed > 0) {
            this.speed -= DECELERATION_RATE;
        }
        else if (this.speed < 0) {
            this.speed += DECELERATION_RATE;
        }
    }

    public void destroy() {
        // TODO lose life
    }

    // Setters

    public void setScore(int new_score) {
        this.score = new_score;
    }

    public void addToScore(int points) {
        this.score += points;
    }

    // Getters

    public int getScore() {
        return this.score;
    }
}
