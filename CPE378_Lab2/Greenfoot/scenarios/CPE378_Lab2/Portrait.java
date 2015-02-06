import greenfoot.*;

/**
 * Write a description of class Portrait here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portrait extends Actor
{
    private GreenfootImage background;
        
    public Portrait() {

        background = getImage();
        updateImage();
        //getImage().scale (230, 225);
    }
    
    private void updateImage() {
        
        GreenfootImage image = new GreenfootImage(background);
        setImage(image);
    }    
}
