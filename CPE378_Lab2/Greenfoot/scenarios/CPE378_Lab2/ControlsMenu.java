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
    Mouse mouse = new Mouse();
    Keys keys = new Keys();
    SpaceBar spacebar = new SpaceBar();
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
        addObject(back, 76, 331);
        addObject (mouse, 433, 144);
        addObject (keys, 161, 143);
        addObject (spacebar, 306, 323);
    }
}
