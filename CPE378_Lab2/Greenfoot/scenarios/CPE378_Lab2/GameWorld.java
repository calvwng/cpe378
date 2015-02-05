import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    static final int WIDTH = 600;
    static final int HEIGHT = 400;
    Text caption = new Text();

    /**
     * Constructor for objects of class GameScreen.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1);
        addObject(caption, getWidth()/2, getHeight() * 3 / 4);
    }

    /**
    * Set the text of the text caption
    * @param str The text the caption will display
    */
    public void setCaption(String str) {
        caption.setText(str);
    }

    /**
    * Toggle the visibility of the text caption.
    * @param visible True to show caption, false to hide it
    */
    public void toggleCaption(boolean visible) {
        GreenfootImage img = caption.getImage();
        int transparency = img.getTransparency();
        
        img.setTransparency(visible ? 255 : 0);
    }
}
