import jgame.JGPoint;
import jgame.platform.JGEngine;
import Game.Player;
import Game.World;

@SuppressWarnings("serial")
public class Main extends JGEngine {
	
    private static final int WINDOW_WIDTH    = 640;
	private static final int WINDOW_HEIGHT   = 480;
	private static final int WIDTH_IN_TILES  = 20;
	private static final int HEIGHT_IN_TILES = 15;
	private static final int TILE_WIDTH      = 32;
	private static final int TILE_HEIGHT     = 32;
	private World world;

    public static void main(String[] args) {
        new Main(new JGPoint(WINDOW_WIDTH, WINDOW_HEIGHT));
    }

    // App constructor
    public Main(JGPoint size) {
        initEngine(size.x, size.y);
    }

    // Applet constructor
    public Main() {
        initEngineApplet();
    }

    public void initCanvas() {
        setCanvasSettings(
                WIDTH_IN_TILES, HEIGHT_IN_TILES, // size of canvas in tiles
                TILE_WIDTH, TILE_HEIGHT, // size of each tile
                null,   // fg color
                null,   // bg color
                null    // standard font (null = use default)
        );
    }

    public void initGame() {
        setFrameRate(50, 2);
        defineMedia("media.tbl");
        
        playAudio("music","mainmusic",true);        
		setGameState("Title");
    }
    
    public void newGame() {
        world = new World();
        setGameState("InGame");
    }

    public void input() {
    	Player player = world.getPlayer();
    	player.setIdle(true);
    	
    	if (getKey(KeyUp)) {
    		player.speedUp();
    		player.setIdle(false);
    	}
    	else if (getKey(KeyDown)) {
    		player.speedDown();
    		player.setIdle(false);
    	}

    	if (getKey(KeyLeft)) {
    		player.rotateLeft();
    		player.setIdle(false);
    	}
    	else if (getKey(KeyRight)) {
    		player.rotateRight();
    		player.setIdle(false);
    	}
    }
    
    public void doFrameTitle() {
    	// Wait until player presses Space
    	if (getKey(' ')) {
			newGame();
		}
    }
    
    public void doFrameInGame() {
    	input();
        moveObjects(null,0);
        world.update();
        Player player = world.getPlayer();
        
        if (!(player.isAlive())) {
        	gameOver();
        }
    }
    
    public void gameOver() {
        Player player = world.getPlayer();
        int score = player.getScore();
        
    	if (World.getHighScore() < score) {
    		World.setHighScore(score);
    	}
    	
    	world = null;
    	setGameState("Title");
    	removeObjects(null, 0);
    }
    
    public void paintFrameTitle() {
    	drawImageString("PRESS SPACE",                   20,                 20, -1, "font", 32, 0);
    	drawImageString("HIGH SCORE " + World.getHighScore(), 20, WINDOW_HEIGHT - 40, -1, "font", 32, 0);
    }

    public void paintFrame() {
    	drawImageString("FUEL  " + world.getPlayer().getFuel(),  20, WINDOW_HEIGHT - 80, -1, "font", 32, 0);
    	drawImageString("SCORE " + world.getPlayer().getScore(), 20, WINDOW_HEIGHT - 40, -1, "font", 32, 0);
    }
}
