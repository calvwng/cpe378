import greenfoot.*;

/**
 * Write a description of class StartButton here.
 * 
 * @author Grant Plaster 
 * @version 1-29-15
 */
public class StartButton extends Actor
{
    private boolean Startgame = false;
        private boolean clicked = false;
        private GreenfootImage background;
    public StartButton() {

        background = getImage();
        updateImage();
    }
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            
            Startgame = true;
            updateImage();
        }
    }
    
    public boolean getStart() {
        
        return Startgame;
    }
    
    public void setStart(boolean b) {
        Startgame = b;
    }
    
    private void updateImage() {
        
        GreenfootImage image = new GreenfootImage(background);
        setImage(image);
    }
}
