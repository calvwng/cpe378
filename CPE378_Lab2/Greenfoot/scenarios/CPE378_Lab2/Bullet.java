import greenfoot.*;

/**
 * Bullets that the players and enemies shoot.
 * 
 * @author Ian Anderson
 * @version Jan 25, 2015
 */
public class Bullet extends Mover {
   public Bullet() {
      getImage().scale(12, 16);
      getImage().rotate(90);
   }
    
   /**
    * Act - do whatever the Bullet wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
   public void act() {
      move(10.0);
      
      if (getX() == 0 || getX() == getWorld().getWidth() - 1 || getY() == 0 || getY() == getWorld().getHeight() - 1) {
         getWorld().removeObject(this);
      }
   }    
}
