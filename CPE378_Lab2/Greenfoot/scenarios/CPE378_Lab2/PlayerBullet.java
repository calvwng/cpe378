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
   
   public static int score = 0;
   GreenfootSound killSound = new GreenfootSound("sounds/crunch.wav");
   
   public void act() {
      Actor a = this.getOneIntersectingObject(Enemy.class);
      
      if (a != null) {
         score += a instanceof ShootingEnemy ? 500 : 100;
         getWorld().removeObject(a);
         getWorld().removeObject(this);
         killSound.play();
         Lab2World.enemyDeath++;
         return;
      }
      
      super.act();
   }    
}
