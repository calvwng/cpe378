import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Image here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Image extends Actor
{
    public Image() 
    {
       getImage().scale(300, 200);
    }    

    @Override
    public void setImage(GreenfootImage img) {
       super.setImage(img);
       getImage().scale(300, 200);
    }
}
