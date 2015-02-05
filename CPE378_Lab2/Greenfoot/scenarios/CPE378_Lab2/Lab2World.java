import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lab2World here.
 * 
 * @author Calvin Wong
 * @version 1-27-15
 */
public class Lab2World extends GameWorld
{
    static GreenfootSound bgMusic = new GreenfootSound("sounds/ufo.mp3");

    /**
     * Constructor for objects of class Lab2World.
     * 
     */
    public Lab2World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();

        //--- Start BG Music Loop
        if (bgMusic.isPlaying()) {
            bgMusic.stop();
        }
        bgMusic.playLoop();

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
                
        //--- Spawn basic Enemies at random locations along border
        for (int i = 0; i < 4; i++) {
            int hgt = (i % 2 == 0) ? 1 : HEIGHT - 1;
            addObject(new Enemy(), Greenfoot.getRandomNumber(WIDTH), hgt);    
        }    

        //--- Text

        //--- Scale the background image.
        getBackground().scale(708, 400);
    }
}


