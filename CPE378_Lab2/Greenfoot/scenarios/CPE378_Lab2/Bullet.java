import greenfoot.*;

/**
 * Bullets that the players and enemies shoot.
 * 
 * @author Ian Anderson
 * @version Jan 25, 2015
 */
public class Bullet extends Mover {
   public Bullet() {
      getImage().scale(10, 10);
   }
    
   /**
    * Act - do whatever the Bullet wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
   public void act() {
      move(10.0);
      
      if (getX() == 0 || getX() == getWorld().getWidth() || getY() == 0 || getY() == 399) {
         getWorld().removeObject(this);
      }
   }    
}
