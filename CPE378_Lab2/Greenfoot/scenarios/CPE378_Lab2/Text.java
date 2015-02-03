import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class Text here.
 * 
 * @author Calvin Wong
 * @version 1-27-15
 */
public class Text extends Actor
{
    GreenfootImage g;

   public Text() {
       g = new GreenfootImage("", 20, Color.BLACK, Color.WHITE);  
   }
    
    public Text(String text) {
       //GreenfootImage g = new GreenfootImage(getWorld().getWidth(), 50);
       //g.drawString("This is test text for game dialogue and descriptions.", 5, 25);
       
       g = new GreenfootImage(text, 20, Color.BLACK, Color.WHITE);
       setImage(g);
    }
    
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public void setText(String newText) {
       g = new GreenfootImage(newText, 20, Color.BLACK, Color.WHITE);
       setImage(g);
    }
}
