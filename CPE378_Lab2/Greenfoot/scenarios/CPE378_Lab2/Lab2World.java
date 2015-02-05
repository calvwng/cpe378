import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lab2World here.
 * 
 * @author Calvin Wong
 * @version 1-27-15
 */
public class Lab2World extends GameWorld
{
    static double oldTime;
    static GreenfootSound bgMusic = new GreenfootSound("sounds/ufo.mp3");
    final int ENEMY_SPAWN_INTERVAL = 1500;

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
        oldTime = System.currentTimeMillis();
    }
    
    public void populate() {
        initTime();

        Player player = new Player();
        addObject(player, getWidth()/2, getHeight()/2);
                
        spawnEnemies(4);

        //--- Text

        //--- Scale the background image.
        getBackground().scale(708, 400);
    }

    /**
    * Start representation of time/clock
    */
    public void initTime() {
        Time time = new Time();
        time.getImage().setTransparency(0);
        addObject(time, 0, 0);
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
        // Spawn some basic enemies for every interval completion
        if (Time.now - oldTime >= ENEMY_SPAWN_INTERVAL) {
            //spawnEnemies(2);
            oldTime = Time.now;
        }
    }
}


