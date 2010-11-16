import jgame.JGPoint;
import jgame.platform.JGEngine;
import Game.World;

@SuppressWarnings("serial")
public class Main extends JGEngine {
	
    private static final int WINDOW_WIDTH = 640;
	private static final int WINDOW_HEIGHT = 480;
	private static final int HEIGHT_IN_TILE = 15;
	private static final int WIDTH_IN_TILE = 20;
	private static final int TILE_HEIGHT = 16;
	private static final int TILE_WIDTH = 16;
	private World world;

    public static void main(String[] args) {
        new Main(new JGPoint(WINDOW_WIDTH, WINDOW_HEIGHT));
        World.high_score = 0;
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
                WIDTH_IN_TILE, HEIGHT_IN_TILE, // size of canvas in tiles
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
    	if (world.getPlayer().isAlive()) {
	    	if (getKey(KeyUp)) {
	        	world.getPlayer().speedUp();
	        }
	        else if (getKey(KeyDown)) {
	        	world.getPlayer().speedDown();
	        }
	
	        if (getKey(KeyLeft)) {
	        	world.getPlayer().rotateLeft();
	        }
	        else if (getKey(KeyRight)) {
	        	world.getPlayer().rotateRight();
	        }
    	}
    }
    
    public void doFrameTitle() {
    	if (getKey(' ')) {
			newGame();
		}
    }
    
    public void doFrameInGame() {
    	input();
        moveObjects(null,0);
        world.update();
        if (!(world.getPlayer().isAlive())) {
        	gameOver();
        }
    }
    
    public void gameOver() {
    	if (World.high_score < world.getPlayer().getScore()) {
    		World.high_score = world.getPlayer().getScore();
    	}
    	
    	world = null;
    	setGameState("Title");
    	removeObjects(null,0);
    }
    
    public void paintFrameTitle() {
    	drawImageString("HIGH  " + World.high_score, 0, 200, -1, "font", 32, 0);
    }

    public void paintFrame() {
    	drawImageString("FUEL  " + world.getPlayer().getFuel(), 0, 150, -1, "font", 32, 0);
    	drawImageString("SCORE " + world.getPlayer().getScore(), 0, 200, -1, "font", 32, 0);
    }
}
