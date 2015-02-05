import greenfoot.*;

/**
 * Write a description of class RestartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestartButton extends Actor
{
    private boolean reset = false;
        private boolean clicked = false;
        private GreenfootImage background;
        
    public RestartButton() {

        background = getImage();
        updateImage();
        getImage().scale (200, 50);
    }
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            
            reset = true;
            updateImage();
        }
    }
    
    public boolean getRestart() {
        
        return reset;
    }
    
    private void updateImage() {
        
        GreenfootImage image = new GreenfootImage(background);
        setImage(image);
    }
}
