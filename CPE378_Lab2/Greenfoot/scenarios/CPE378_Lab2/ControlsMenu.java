import greenfoot.*;

/**
 * Write a description of class ControlsMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlsMenu extends World
{
    BackButton back = new BackButton();
    /**
     * Constructor for objects of class ControlsMenu.
     * 
     */
    public ControlsMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    public void act() {
        if (back.getBack() == true) {
            Greenfoot.setWorld (new MainMenu());
            //Greenfoot.stop();
        }
    }
    
    public void prepare() {
        getBackground().scale(1200, 1000);
        addObject(back, 190, 322);
    }
}
