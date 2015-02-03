import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.lang.Math;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Character {
   int targetX, targetY;

   public Enemy() {
       changeRandomTarget();
   }
   
   /**
    * Act - do whatever the Enemy wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    * Enemies 
    */
   public void act() {
      Actor a = this.getOneIntersectingObject(Enemy.class);
     
      if (a != null) {
         a.setRotation(a.getRotation() + 180);
         this.setRotation(this.getRotation() + 180);
      }

      //--- Idle Animation
      GreenfootImage img = getImage();
      img.rotate(2);

      //-- Random Movement
      if (getX() != targetX && getY() != targetY) {
         turnTowards(targetX, targetY);
         move(2);
      }
      else {
         changeRandomTarget();
      }

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

   double distance(double x1, double y1, double x2, double y2) 
   { 
       return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); 
   }

   void changeRandomTarget() {
       targetX = Greenfoot.getRandomNumber(Lab2World.WIDTH);
       targetY = Greenfoot.getRandomNumber(Lab2World.HEIGHT); 
   }
}
