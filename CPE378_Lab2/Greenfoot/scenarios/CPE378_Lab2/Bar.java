

import greenfoot.*;
import java.awt.Color;



public class Bar extends Actor
{
    private int barWidth = 100; // the width of the color portion of the bar
    private int barHeight = 10; // the height of the color portion of the bar
    private int breakPercent = 20; // the percentage amount that changes the color of the bar
    private int breakValue = 20; // in tandem with breakPercent
    
    private Color backgroundColor = new Color(1, 1, 1, 0); // the background color of the entire object
    private Color textColor = Color.GREEN; // the color of all text and the frame of the bar itself
    private Color safeColor = Color.GREEN; // the color of the bar while in the safe range
    private Color dangerColor = Color.RED; // the color of the bar while in the danger range

    private int value = 0; // the current value of the bar
    private int maximumValue = 0; // the maximum value of the bar
    private int minimumValue = 0; // the minimum value of the bar
    
    
    public Bar (int initValue, int maxValue)
    {
        maximumValue = maxValue;
        add(initValue);
    }
    
    /**
     * Method 'newImage': builds a new image for the bar, determined by the values set for it
     */
    private void newImage()
    {
        int barValue = (int) (barWidth * (value - minimumValue) / (maximumValue - minimumValue));
        
        
        GreenfootImage barImg = new GreenfootImage(barWidth + 4, barHeight + 4);
        barImg.setColor(backgroundColor);
        barImg.fill();
        barImg.setColor(textColor);
        barImg.drawRect(0, 0, barImg.getWidth() - 1, barImg.getHeight() - 1);
        if (value > minimumValue)
        {
            
            if (value >  breakValue ) barImg.setColor(safeColor);
            else barImg.setColor(dangerColor);
           
            if (value == breakValue)
            {
                int r = (int) ((safeColor.getRed() + dangerColor.getRed()) / 2);
                int g = (int) ((safeColor.getGreen() + dangerColor.getGreen()) / 2);
                int b = (int) ((safeColor.getBlue() + dangerColor.getBlue()) / 2);
                barImg.setColor(new Color(r, g, b));
            }
            barImg.fillRect(2, 2, barValue, barHeight);
        }
        
        setImage(barImg);
    }
    
   
    public void add(int amount)
    {
        value += amount;
        checkValue();
        newImage();
    }
    
    
    public void subtract(int amount)
    {
        value -= amount;
        checkValue();
        newImage();
    }
    
    
    private void checkValue()
    {
        if (value < minimumValue) value = minimumValue;
        if (value > maximumValue) value = maximumValue;
    }
    
    public int getBreakValue(){
        return breakValue;
    }
}
    

   
   
   