import greenfoot.*;

/**
 * The projectile for the player character.
 * 
 * @author Ian Anderson
 * @version Jan 28, 2015
 */
public class PlayerBullet extends Bullet {
   /**
    * Act - do whatever the PlayerBullet wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
   public void act() {
      Actor a = this.getOneIntersectingObject(Enemy.class);
      
      if (a != null) {
         getWorld().removeObject(a);
         getWorld().removeObject(this);
         return;
      }
      
      super.act();
   }    
}
