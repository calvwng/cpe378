import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Character {
    private static final int MOVE_DELTA = 2;
    private static final int MAX_HEALTH = 3;
    private int health;
    private int frame;
    private int idle_frame;
    private boolean moving;
    
    private GreenfootImage[] ship_left = new GreenfootImage[] { new GreenfootImage("ship_left1.png"), new GreenfootImage("ship_left2.png"), new GreenfootImage("ship_left3.png"), new GreenfootImage("ship_left4.png")};
    private GreenfootImage[] ship_right = new GreenfootImage[] { new GreenfootImage("ship_right1.png"), new GreenfootImage("ship_right2.png"), new GreenfootImage("ship_right3.png"), new GreenfootImage("ship_right4.png")};
    
    private GreenfootImage idle = new GreenfootImage("idle.png");
    
    GreenfootSound crunchSound = new GreenfootSound("sounds/crunch.wav");
    
    public Player() {
       health = MAX_HEALTH;
       getImage().scale(50, 50);
       getImage().rotate(90);
       image_setup();
       frame = 0;
       idle_frame = 0;
       setRotation(270);
       moving = false;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {   
       moving = false;
       //decreaseHealth();
       if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
          moving = true;
          setLocation(getX() - MOVE_DELTA, getY()); 
          animate(1);
       }
       if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
          moving = true;
          setLocation(getX() + MOVE_DELTA, getY()); 
          animate(2);
       }
       if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
          moving = true;
          setLocation(getX(), getY() - MOVE_DELTA); 
       }
       if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
          moving = true;
          setLocation(getX(), getY() + MOVE_DELTA); 
       }       
       
       if ("space".equals(Greenfoot.getKey())) {
          super.fire(new PlayerBullet());
       } 
       
       MouseInfo mouse = Greenfoot.getMouseInfo();
       if (mouse != null) {
          // Face ship towards mouse location if it's within bounds
          this.turnTowards(mouse.getX(), mouse.getY());   

          // Fire once if left mouse button is clicked (pressed and released)
          if (Greenfoot.mouseClicked(null) && mouse.getButton() == 1) {
              super.fire(new PlayerBullet());
          }
       }
       
       
       if(!moving)
       {
           setImage(idle);
           idle_animation();
       }
    }  
    
    public void image_setup() {
        for(int i=0; i<ship_left.length; i++)
        {
            ship_left[i].scale(50, 50);
            ship_left[i].rotate(90);
            ship_right[i].scale(50, 50);
            ship_right[i].rotate(90);
        }
        idle.scale(50,50);
        idle.rotate(90);
    }
   
    public void animate(int anim) {
        switch(anim)
        {
            case 1 : setImage(ship_left[frame]); break; //move left animation
            case 2 : setImage(ship_right[frame]); break; //move right animation
        }
        if(frame == 3)
        {
            frame = 2;
        }
        if(frame < 3) { 
            frame += 1; 
        } else { 
            frame = 0; 
        }
       
    }
    
    public void idle_animation() {
        if(idle_frame < 10)
        {
            idle.scale(50, 50);
        } else if (idle_frame < 20 && idle_frame >=10)
        {
            idle.scale(51,51);
        } else if (idle_frame < 30 && idle_frame >= 20)
        {
            idle.scale(52,52);
        } else if (idle_frame < 40 && idle_frame >= 30)
        {
            idle.scale(51,51);
        } else if (idle_frame < 50 && idle_frame >= 40)
        {
            idle.scale(50,50);
        } else if (idle_frame < 60 && idle_frame >= 50)
        {
            idle.scale(49,49);
        } else if (idle_frame < 70 && idle_frame >= 60)
        {
            idle.scale(48,48);
        } else if (idle_frame < 80 && idle_frame >= 70)
        {
            idle.scale(49,49);
        } else 
        {
            idle.scale(50,50);
        } 
        
        if(idle_frame < 90)
        {
           idle_frame += 1;  
        } else {
            idle_frame = 0;
        }
        
       Actor a = this.getOneIntersectingObject(Enemy.class);
      
       if (a != null) {
          getWorld().removeObject(this);
          GreenfootSound backgroundMusic = new GreenfootSound("sounds/ufo.mp3");
          backgroundMusic.stop();
          Greenfoot.setWorld(new GameOverScreen());
          return;
       }
    }
    
    public void decreaseHealth() {
       if (--health == 0) {
          //getWorld().removeObject(this);
          GreenfootSound backgroundMusic = new GreenfootSound("sounds/ufo.mp3");
          backgroundMusic.stop();
          Greenfoot.setWorld(new GameOverScreen());
          
          crunchSound.play();
       }
    }
}
