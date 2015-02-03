import greenfoot.*;

/**
 * Write a description of class MainMenu here.
 * 
 * @author Grant Plaster 
 * @version 1-29-15
 */
public class MainMenu extends World
{
    StartButton start = new StartButton();
    ControlsButton controls = new ControlsButton();
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
    }
    
    public void act() {
        if (start.getStart() == true) {
            Greenfoot.setWorld (new Lab2World());
            //Greenfoot.stop();
        }
        
        if (controls.getControls() == true) {
            Greenfoot.setWorld (new ControlsMenu());
        }
    }
    
    public void prepare() {
        getBackground().scale(1200, 1000);
        addObject(start, 190, 322);
        addObject(controls, 388, 322);
    }
}
