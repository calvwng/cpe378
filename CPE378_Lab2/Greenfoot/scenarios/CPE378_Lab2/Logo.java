import greenfoot.*;

/**
 * Write a description of class Logo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Logo extends Actor
{
    private GreenfootImage background;
        
    public Logo() {

        background = getImage();
        updateImage();
        //getImage().scale (230, 225);
    }
    
    private void updateImage() {
        
        GreenfootImage image = new GreenfootImage(background);
        setImage(image);
    } 
}
