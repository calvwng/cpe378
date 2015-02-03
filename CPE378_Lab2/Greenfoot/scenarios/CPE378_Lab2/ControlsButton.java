import greenfoot.*;

/**
 * Write a description of class StartButton here.
 * 
 * @author Grant Plaster 
 * @version 1-29-15
 */
public class ControlsButton extends Actor
{
    private boolean showControls = false;
        private boolean clicked = false;
        private GreenfootImage background;
    public ControlsButton() {

        background = getImage();
        updateImage();
    }
    /**
     * Act - do whatever the ControlsButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            
            showControls = true;
            updateImage();
        }
    }
    
    public boolean getControls() {
        
        return showControls;
    }
    
    private void updateImage() {
        
        GreenfootImage image = new GreenfootImage(background);
        setImage(image);
    }
}
