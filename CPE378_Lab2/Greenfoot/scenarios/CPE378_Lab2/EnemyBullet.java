import greenfoot.*;

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author Ian Anderson
 * @version Jan 29, 2015
 */
public class EnemyBullet extends Bullet {

   public void act() {
      Actor a = this.getOneIntersectingObject(Player.class);
      
      if (a != null) {
         ((Lab2World)getWorld()).bar.subtract(1);
         ((Player) a).decreaseHealth();
         //getWorld().removeObject(this);
         return;
      }
      
      move(5.0);
      
      if (getX() == 0 || getX() == getWorld().getWidth() - 1 || getY() == 0 || getY() == getWorld().getHeight() - 1) {
         getWorld().removeObject(this);
      }
   }    
}

