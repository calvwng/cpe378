import greenfoot.*;

/**
 * A class for enemy characters and the player character.
 * 
 * @author Ian Anderson
 * @version Jan 25, 2015
 */
public class Character extends Actor {
   /**
    * Act - do whatever the Character wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
   public void act() {
      // Add your action code here.
   }
    
   protected void fire() {
      Greenfoot.playSound("blast.wav");
      Bullet b = new Bullet();
      getWorld().addObject(b, getX(), getY());
      b.setRotation(getRotation());
   }
}