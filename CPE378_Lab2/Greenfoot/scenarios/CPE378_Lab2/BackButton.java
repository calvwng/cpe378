import greenfoot.*;

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Actor
{
   private boolean goBack = false;
        private boolean clicked = false;
        private GreenfootImage background;
        
    public BackButton() {

        background = getImage();
        updateImage();
    }
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            
            goBack = true;
            updateImage();
        }
    }
    
    public boolean getBack() {
        
        return goBack;
    }
    
    private void updateImage() {
        
        GreenfootImage image = new GreenfootImage(background);
        setImage(image);
    }
}
