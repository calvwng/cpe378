import greenfoot.*;

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends World
{

    WinText winText = new WinText();
    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public WinScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    public void prepare() {
        getBackground().scale(650, 400);
        addObject(WinText, 278, 305);
    }
}
