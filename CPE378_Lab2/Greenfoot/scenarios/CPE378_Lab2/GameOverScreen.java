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
    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public GameOverScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    public void act() {
        if (restart.getRestart() == true) {
            Greenfoot.setWorld (new MainMenu());
            //Greenfoot.stop();
        }
    }
    
    public void prepare() {
        getBackground().scale(650, 400);
        addObject(restart, 320, 325);
    }
}
