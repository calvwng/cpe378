import greenfoot.*;

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{

    RestartButton restart = new RestartButton();
    GameOver gameOver = new GameOver();
    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public GameOverScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();

        // Stop the bg music
        if (Lab2World.bgMusic.isPlaying()) {
            Lab2World.bgMusic.stop();
        }             
    }
    
    public void act() {
        if (restart.getRestart() == true) {
            Greenfoot.setWorld (new Lab2World());
            //Greenfoot.stop();
        }
    }
    
    public void prepare() {
        getBackground().scale(650, 400);
        addObject(restart, 278, 305);
        addObject(gameOver, 269, 185);
    }
}
