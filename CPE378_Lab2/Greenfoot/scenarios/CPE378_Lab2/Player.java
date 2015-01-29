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
    
    public Player() {
       getImage().scale(50, 50);
       getImage().rotate(90);
       setRotation(270);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if (Greenfoot.isKeyDown("left")) {
          setLocation(getX() - MOVE_DELTA, getY()); 
       }
       if (Greenfoot.isKeyDown("right")) {
          setLocation(getX() + MOVE_DELTA, getY()); 
       }
       if (Greenfoot.isKeyDown("up")) {
          setLocation(getX(), getY() - MOVE_DELTA); 
       }
       if (Greenfoot.isKeyDown("down")) {
          setLocation(getX(), getY() + MOVE_DELTA); 
       }       
       
       if ("space".equals(Greenfoot.getKey())) {
          super.fire();
       } 
       
       MouseInfo mouse = Greenfoot.getMouseInfo();
       if (mouse != null && mouse.getButton() == 1 && mouse.getClickCount() == 1) {
          super.fire();
       }
    }    
}
