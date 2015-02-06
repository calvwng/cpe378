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
    final int WAVE_INTERVAL = 5000;
    static int enemyCount;
    static int enemySpawn;
    static int enemyDeath;
    int waveCount;
    int spawnRate;
    Player player;

    Text scoreDisplay, waveDisplay;

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

        //--- Add Score Display
        scoreDisplay = new Text("");
        addObject(scoreDisplay, getWidth() / 3, 20);

        //--- Wave Display
        waveDisplay = new Text("");
        addObject(waveDisplay, getWidth() - getWidth() / 3, 20);
        toggleCaption(false);

        //--- Set start time
        oldTime = System.currentTimeMillis();
        
        //initialize enemy counter
        enemyCount = 30;     // WIN CONDITION: Defeat this many enemies
        enemySpawn = 0;
        enemyDeath = 0;
        PlayerBullet.score = 0;
        waveCount = 1;
        spawnRate = 2;
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
            if (enemySpawn <= enemyCount) {
                int rand = Greenfoot.getRandomNumber(2);
                int hgt = (rand % 2 == 0) ? 1 : HEIGHT - 1;
                addObject(new Enemy(), Greenfoot.getRandomNumber(WIDTH), hgt);
                enemySpawn++;
            }
        }
    }

    /**
    * Spawn |num| shooting enemies at random corners of the World
    */
    public void spawnShootingEnemies(int num) {
        //--- Spawn ShootingEnemies at random locations along border
        for (int i = 0; i < num; i++) {
            if (enemySpawn <= enemyCount) {
                int rand = Greenfoot.getRandomNumber(2);
                int width = (rand % 2 == 0) ? 1 : WIDTH - 1;
                addObject(new ShootingEnemy(), width, Greenfoot.getRandomNumber(HEIGHT));
                enemySpawn++;
            }
        }
    }    

    public void act() {
        // Spawn some basic enemies for every interval completion
        if((enemySpawn <= enemyCount) && (enemyDeath != enemyCount)) {
            if (Time.now - oldTime >= ENEMY_SPAWN_INTERVAL) {
                spawnEnemies(spawnRate);
                oldTime = Time.now;
            }
        }
        else {
            if (Time.now - oldTime >= WAVE_INTERVAL) {
                waveCount++;
                spawnRate++;
                enemyDeath = 0;
                enemyCount += 20;
                enemySpawn = 0;
            
                oldTime = Time.now;
            }
            
            if (waveCount > 3) {
                    Greenfoot.setWorld(new WinScreen());
                }
            
            //uncomment for boss implementation, will lighten spawning of enemies.
            /*if (wave == 3) {
            /*    spawnRate -= 2;
            }*/
        }

        // Update score and wave
        scoreDisplay.setText(PlayerBullet.score + " pts");
        waveDisplay.setText("Wave " + waveCount);
    }
}


