import greenfoot.*;

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends GameWorld
{

    WinText winText = new WinText();
    GreenfootSound endSound = new GreenfootSound("sounds/failure.wav");
    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public WinScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(); 
        prepare();
        
        // Stop the bg music
        if (Lab2World.bgMusic.isPlaying()) {
            Lab2World.bgMusic.stop();
        }
        
        setCaption("The Harvesters have been defeated...life on Earth will continue to press on!");
        toggleCaption(true);   
    }
    
    public void prepare() {
        getBackground().scale(650, 400);
        addObject(winText, 274, 64);
        endSound.play();
    }
}
