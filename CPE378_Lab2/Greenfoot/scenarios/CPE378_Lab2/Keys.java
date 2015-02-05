import greenfoot.*;

/**
 * Write a description of class Keys here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Keys extends Actor
{
     private GreenfootImage background;
        
    public Keys() {

        background = getImage();
        updateImage();
        getImage().scale (230, 225);
    }
    
    private void updateImage() {
        
        GreenfootImage image = new GreenfootImage(background);
        setImage(image);
    }
}
