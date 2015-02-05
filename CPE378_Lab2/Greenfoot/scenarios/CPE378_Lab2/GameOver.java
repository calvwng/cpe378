import greenfoot.*;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    private GreenfootImage background;
        
    public GameOver() {

        background = getImage();
        updateImage();
        //getImage().scale (175, 225);
    }
    
    private void updateImage() {
        
        GreenfootImage image = new GreenfootImage(background);
        setImage(image);
    }    
}
