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
    final int ENEMY_SPAWN_INTERVAL = 1000;
    double time = 0;

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

        //--- Set start time
        time = System.currentTimeMillis();
    }
    
    public void populate() {
        Player player = new Player();
        addObject(player, getWidth()/2, getHeight()/2);
                
        spawnEnemies(4);

        //--- Text

        //--- Scale the background image.
        getBackground().scale(708, 400);
    }

    /**
    * Spawn |num| enemies at random locations along the top and bottom edge of the World
    */
    public void spawnEnemies(int num) {
        //--- Spawn basic Enemies at random locations along border
        for (int i = 0; i < num; i++) {
            int rand = Greenfoot.getRandomNumber(2);
            int hgt = (rand % 2 == 0) ? 1 : HEIGHT - 1;
            addObject(new Enemy(), Greenfoot.getRandomNumber(WIDTH), hgt);    
        }
    }

    public void act() {
        double curTime = System.currentTimeMillis();

        // Spawn some basic enemies for every interval completion
        if (curTime - time >= ENEMY_SPAWN_INTERVAL) {
            spawnEnemies(2);
            time = curTime;
        }
    }
}


