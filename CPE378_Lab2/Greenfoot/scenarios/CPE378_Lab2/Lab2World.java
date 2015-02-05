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
<<<<<<< HEAD
    static int enemyCount;
    static int enemySpawn;
    static int enemyDeath;
=======
    Player player;
>>>>>>> FETCH_HEAD

    /**
     * Constructor for objects of class Lab2World.
     * 
     */
    public Bar bar;
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
        
        //initialize enemy counter
        enemyCount = 5;
        enemySpawn = 0;
    }
    
    public void populate() {
        initTime();

        player = new Player();
        addObject(player, getWidth()/2, getHeight()/2);
                
        spawnEnemies(4);

        //--- Text

        //--- Scale the background image.
        getBackground().scale(708, 400);
        //--- health bar
       bar = new Bar("Player 1", "Health Points", player.getHealth(), player.getHealth());
       addObject(bar, 250, 40);
        
       
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
            if (enemySpawn < enemyCount) {
                int rand = Greenfoot.getRandomNumber(2);
                int hgt = (rand % 2 == 0) ? 1 : HEIGHT - 1;
                addObject(new Enemy(), Greenfoot.getRandomNumber(WIDTH), hgt);
                enemySpawn++;
            }
        }
    }

    public void act() {
        // Spawn some basic enemies for every interval completion
        if((enemySpawn <= enemyCount) && (enemyDeath != enemyCount)) {
            if (Time.now - oldTime >= ENEMY_SPAWN_INTERVAL) {
                spawnEnemies(2);
                oldTime = Time.now;
            }
        }
        else {
            Greenfoot.setWorld(new WinScreen());
        }
    }
}


