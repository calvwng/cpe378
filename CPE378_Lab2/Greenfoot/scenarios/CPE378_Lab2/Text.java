import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.StringTokenizer;

/**
 * Write a description of class Text here.
 * 
 * @author Calvin Wong
 * @version 1-27-15
 */
public class Text extends Actor
{
    final int CHARS_PER_LINE = 80;
    GreenfootImage g = new GreenfootImage("", 20, Color.GREEN, null); 

   public Text() {

   }
    
    public Text(String text) {
       setText(text);
       setImage(g);
    }
    
    public void act() 
    {
        
    }
    
    public void setText(String newText) {
       if (newText.length() > CHARS_PER_LINE) {
          StringTokenizer tok = new StringTokenizer(newText);
          String block = "";
          String line = "";

          while (tok.hasMoreTokens()) {
             String nextWord = tok.nextToken();
             if (line.length() + nextWord.length() < CHARS_PER_LINE) {
                line += nextWord + " ";
             }
             else {
                block += line + "\n";   // Flush line and add it to the block
                line = nextWord + " ";
             }
          }
          if (line != "") {
            block += line;
          }
          newText = block;
       }       
       g = new GreenfootImage(newText, 20, Color.GREEN, null);
       setImage(g);
    }
}
