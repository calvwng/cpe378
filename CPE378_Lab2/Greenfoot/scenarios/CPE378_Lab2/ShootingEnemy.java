import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class ShootingEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShootingEnemy extends Enemy
{
    double targetTime = Time.now;
    double fireTime = Time.now;
    final double FIRE_INTERVAL = 1000;
    final double TARGET_INTERVAL = 500; 

    int pX, pY;

    /**
     * Act - do whatever the ShootingEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //--- A.I. involving player
        List<Object> playerList = getWorld().getObjects(Player.class);
        Player player = null;
        if (playerList != null && playerList.size() > 0) {
            if ((player = (Player)playerList.get(0)) != null) {
                // Fire in intervals
                if (Time.now - fireTime >= FIRE_INTERVAL){
                   super.fire(new EnemyBullet());
                   fireTime = Time.now;
                }                

                // Update enemy's knowledge of player location in intervals
                if (Time.now - targetTime >= TARGET_INTERVAL) {
                   pX = player.getX();
                   pY = player.getY();
                   this.turnTowards(pX, pY);   // Turn towards the player
                   targetTime = Time.now;
                }

                // Move towards last known player location
                if (distance(getX(), getY(), pX, pY) > 150) {
                   move(1);
                }
            }
        }
    }    
}
