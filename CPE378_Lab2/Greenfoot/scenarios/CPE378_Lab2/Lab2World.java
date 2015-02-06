import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lab2World here.
 * 
 * @author Calvin Wong
 * @version 1-27-15
 */
public class Lab2World extends GameWorld
{
    static double oldTime, talkTime;
    static GreenfootSound bgMusic = new GreenfootSound("sounds/ufo.mp3");
    final int ENEMY_SPAWN_INTERVAL = 1500;
    final int TALK_INTERVAL = 6000;
    final int WAVE_INTERVAL = 5000;
    static int enemyCount;
    static int enemySpawn;
    static int enemyDeath;
    int waveCount;
    int spawnRate;
    Player player;
    static Portrait portrait;
    
    static GreenfootImage portraitI = new GreenfootImage("portrait_idle.png");
    static GreenfootImage portraitH = new GreenfootImage("portrait_hit.png");
    static GreenfootImage portraitD = new GreenfootImage("portrait_nearDeath.png");

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

        //--- Character
        setCaption("Chad Price: Time for me to make things right!");
        toggleCaption(true);
        talkTime = Time.now;

        //--- Set start time
        oldTime = Time.now;
        
        //initialize enemy counter
        enemyCount = 30;     // WIN CONDITION: Defeat this many enemies
        enemySpawn = 0;
        enemyDeath = 0;
        PlayerBullet.score = 0;
        waveCount = 1;
        spawnRate = 2;
        scaleImages();
    }
    private void scaleImages(){
        portraitI.scale(300, 125);
        portraitH.scale(300, 125);
        portraitD.scale(300, 125);
    }
    public void populate() {
       initTime();
       player = new Player();
       portrait = new Portrait();
       portrait.setImage(portraitI);
       
       //adding portrait  
       addObject(portrait, 86, 340);
       bar = new Bar(player.getHealth(), player.getHealth());
       addObject(bar, 125, 340);
        

        
        addObject(player, getWidth()/2, getHeight()/2);
                
        spawnEnemies(4);

        //--- Text

        //--- Scale the background image.
        getBackground().scale(708, 400);
        //--- health bar
       
       
       
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

                if (waveCount > 1) { // Spawn half as many shooting enemies
                    spawnShootingEnemies(spawnRate / 3);

                    setCaption("Chad Price: Great. Now some of the bots have weapons?!");
                    toggleCaption(true);
                    talkTime = Time.now;                  
                }

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

                setCaption("Chad Price: Look likes another wave's coming in...more practice targets!");
                toggleCaption(true);
                talkTime = Time.now;
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
        
        if (player.getHealth() <= bar.getBreakValue()) {
            portrait.setImage(portraitD);
            setCaption("Chad Price: I guess my team really built these tough suckers with love, huh? Agh.");
            toggleCaption(true);
            talkTime = Time.now;
        }

        if (Time.now - talkTime >= TALK_INTERVAL) {
            toggleCaption(false);
        }
    }
}


