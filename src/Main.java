import java.io.IOException;

import Game.Chicken;
import Game.Player;
import Game.World;

public class ChickenGame extends JGEngine {
    private World world;

    public static void main(String[] args) {
        new ChickenGame(new JGPoint(640, 480));

        //World world = new World();

        //for (int i = 0; i < World.NUMBER_CHICKENS; i++) {
            //System.out.println("Chicken #" + i + " sayin' hello from " + "<"  + 
                    //world.getChickens().get(i).getPosX()   + ", " +
                    //world.getChickens().get(i).getPosY()   + ">");	

        //}

        //// Game loop
        //while (true) {
            //// TODO: remove
            //for(int i = 0; i < World.NUMBER_PLAYERS; i++) {
                //inputFromUser(world.getPlayers().get(i));

                //System.out.println("I'm here: <" + world.getPlayers().get(i).getPosX() + ", " + 
                        //world.getPlayers().get(i).getPosY() + ">" + "Theta:" + 
                        //world.getPlayers().get(i).getOrientation() + "Dir <" +
                        //world.getPlayers().get(i).getDirectionX() + ", " +
                        //world.getPlayers().get(i).getDirectionY() + ">");
            //}

            //world.update();
            //redraw();
        //}

    }

    // App constructor
    public ChickenGame(JGPoint size) {
        initEngine(size.x, size.y);
    }

    // Applet constructor
    public ChickenGame() {
        initEngineApplet();
    }

    public void initCanvas() {
        setCanvasSettings(
                20, 15, // size of canvas in tiles
                16, 16, // size of each tile
                null,   // fg color
                null,   // bg color
                null    // standard font (null = use default)
        );
    }

    public void initGame() {
        setFrameRate(50, 2);
        defineMedia("media.tbl");

        world = new World();
    }

    // Game logic
    public void doFrame() {
            world.update();
    }

    public void paintFrame() {
        //TODO
    }

    //public static void inputFromUser(Player player) {

        //char inKeyboard = ' ';

        //try {
            //inKeyboard = (char) System.in.read();	
        //}
        //catch (IOException e){
            //System.out.println("Error reading from user");
        //}

        //switch (inKeyboard) {
            ////move up
            //case 'w':
                //player.speedUp();
                //break;

            ////break (move backwards)
            //case 's':
                //player.speedDown();
                //break;

            ////turn right
            //case 'd':	
                //player.rotateRight();
                //break;

            ////turn left
            //case 'a':
                //player.rotateLeft();
                //break;

            ////do nothing
            //default:
                //player.setIsIdle(true);
        //}
    //}

    //public static void redraw() {
        ////TODO
    //}
}
