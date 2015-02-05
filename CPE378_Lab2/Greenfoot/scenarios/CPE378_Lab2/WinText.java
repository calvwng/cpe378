import greenfoot.*;

/**
 * Write a description of class WinText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinText extends Actor
{
    private GreenfootImage background;
        
    public WinText() {

        background = getImage();
        updateImage();
        //getImage().scale (230, 225);
    }
    
    private void updateImage() {
        
        GreenfootImage image = new GreenfootImage(background);
        setImage(image);
    } 
}
