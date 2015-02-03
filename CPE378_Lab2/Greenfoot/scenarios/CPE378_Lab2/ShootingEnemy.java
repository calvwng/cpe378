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
                int pX = player.getX();
                int pY = player.getY();  
                
                if (distance(getX(), getY(), pX, pY) < 20) {
                   
                }
            }
        }
    }    
}
