import greenfoot.*;

/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse extends Actor
{
    private GreenfootImage background;
        
    public Mouse() {

        background = getImage();
        updateImage();
        getImage().scale (175, 225);
    }
    
    private void updateImage() {
        
        GreenfootImage image = new GreenfootImage(background);
        setImage(image);
    }   
}
