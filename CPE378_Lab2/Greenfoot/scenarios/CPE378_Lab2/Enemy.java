import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Character {
   public Enemy() {
       
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
   }    
}
