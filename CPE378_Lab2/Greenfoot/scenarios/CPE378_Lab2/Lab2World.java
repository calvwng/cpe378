import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lab2World here.
 * 
 * @author Calvin Wong
 * @version 1-27-15
 */
public class Lab2World extends World
{
    Text caption = new Text();

    /**
     * Constructor for objects of class Lab2World.
     * 
     */
    public Lab2World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        //--- Start BG Music Loop
        GreenfootSound backgroundMusic = new GreenfootSound("sounds/ufo.mp3");
        backgroundMusic.playLoop();

        //--- Populate world with player, enemies, etc.
        populate();

        //--- Add Text Caption
        addObject(caption, getWidth()/2, getHeight() * 7 / 8);
        setCaption("Caption");
        toggleCaption(false);
    }
    
    public void populate() {
        Player player = new Player();
        addObject(player, getWidth()/2, getHeight()/2);
                
        //--- Add enemies
        for (int i = 0; i < this.getWidth(); i += this.getWidth() / 4) {
            addObject(new Enemy(), i, getHeight() * 7 / 8);
        }

        //--- Text

        //--- Scale the background image.
        getBackground().scale(708, 400);
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


