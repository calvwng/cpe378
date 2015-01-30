import greenfoot.*;

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author Ian Anderson
 * @version Jan 29, 2015
 */
public class EnemyBullet extends Bullet {
   /**
    * Act - do whatever the EnemyBullet wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
   public void act() {
      Actor a = this.getOneIntersectingObject(Player.class);
      
      if (a != null) {
         ((Player) a).decreaseHealth();
         getWorld().removeObject(this);
         return;
      }
      
      super.act();
   }    
}

