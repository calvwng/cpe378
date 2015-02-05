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
    Logo logo = new Logo();
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
            start.setStart(false);
            Greenfoot.setWorld (new TransitionScreen());
        }
        
        if (controls.getControls() == true) {
            Greenfoot.setWorld (new ControlsMenu());
        }
    }
    
    public void prepare() {
        getBackground().scale(600, 400);
        addObject(start, 190, 322);
        addObject(controls, 388, 322);
        addObject(logo, 282, 182);
    }
}
