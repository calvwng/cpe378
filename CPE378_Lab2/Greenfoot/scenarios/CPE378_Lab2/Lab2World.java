import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lab2World here.
 * 
 * @author Calvin Wong
 * @version 1-27-15
 */
public class Lab2World extends World
{

    /**
     * Constructor for objects of class Lab2World.
     * 
     */
    public Lab2World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        populate();
        GreenfootSound backgroundMusic = new GreenfootSound("ufo.mp3");
        backgroundMusic.playLoop();
    }
    
    public void populate() {
        Player player = new Player();
        addObject(player, getWidth()/2, getHeight()/2);
        
        //Text testText = new Text("This is test text for game dialogue and descriptions.");
        //addObject(testText, getWidth()/2, getHeight() * 7 / 8);
        
        getBackground().scale(708, 400);
    }
}


