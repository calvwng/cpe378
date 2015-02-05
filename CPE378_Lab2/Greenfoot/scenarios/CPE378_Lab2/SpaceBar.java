import greenfoot.*;

/**
 * Write a description of class SpaceBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceBar extends Actor
{
    private GreenfootImage background;
        
    public SpaceBar() {

        background = getImage();
        updateImage();
        getImage().scale (250, 75);
    }
    
    private void updateImage() {
        
        GreenfootImage image = new GreenfootImage(background);
        setImage(image);
    }
}
