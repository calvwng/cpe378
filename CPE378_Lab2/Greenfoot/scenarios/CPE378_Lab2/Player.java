import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Character
{
    static final int MOVE_DELTA = 2;
    private int frame;
    private boolean moving;
    
    private GreenfootImage[] ship_left = new GreenfootImage[] { new GreenfootImage("ship_left1.png"), new GreenfootImage("ship_left2.png"), new GreenfootImage("ship_left3.png"), new GreenfootImage("ship_left4.png")};
    private GreenfootImage[] ship_right = new GreenfootImage[] { new GreenfootImage("ship_right1.png"), new GreenfootImage("ship_right2.png"), new GreenfootImage("ship_right3.png"), new GreenfootImage("ship_right4.png")};
    private GreenfootImage idle = new GreenfootImage("idle.png");
    public Player() {
       getImage().scale(50, 50);
       getImage().rotate(90);
       image_setup();
       frame = 0;
       setRotation(270);
       moving = false;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       moving = false;
       if (Greenfoot.isKeyDown("left")) {
          moving = true;
          setLocation(getX() - MOVE_DELTA, getY()); 
          animate(1);
       }
       if (Greenfoot.isKeyDown("right")) {
          moving = true;
          setLocation(getX() + MOVE_DELTA, getY()); 
          animate(2);
       }
       if (Greenfoot.isKeyDown("up")) {
          moving = true;
          setLocation(getX(), getY() - MOVE_DELTA); 
       }
       if (Greenfoot.isKeyDown("down")) {
          moving = true;
          setLocation(getX(), getY() + MOVE_DELTA); 
       }       
       
       if ("space".equals(Greenfoot.getKey())) {
          super.fire();
       } 
       
       MouseInfo mouse = Greenfoot.getMouseInfo();
       if (mouse != null && mouse.getButton() == 1) {
          super.fire();
       }
       
       if(!moving)
       {
           setImage(idle);
       }
    }  
    
    public void image_setup()
    {
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
   
    public void animate(int anim)
    {
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
            frame += 1.0; 
        } else { 
            frame = 0; 
        }
       
    }
}
