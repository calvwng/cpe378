import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TransitionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransitionScreen extends GameWorld
{
    String[] story = new String[5];
    GreenfootImage[] images = new GreenfootImage[5];
    Image storyImage;
    
    int storyIdx = 1;

    /**
     * Constructor for objects of class TransitionScreen.
     */
    public TransitionScreen()
    {    
        story[0] = "In the year 2077, a 3-year drought threw Earth’s water supply and ecosystems into disarray, "
                   + "and global warming could no longer be ignored.";
        story[1] = "In response, NASA quickly started an experimental program to rebuild Earth’s damaged Ozone layer "
                   + "in an effort to protect our terran environment from further global warming. Under the supervision of "
                   + "the division's team lead, Chad Price, they rushed development and launched Ozone maintenance bots into "
                   + "the orbit with the goal of upkeeping our precious Ozone layer.";
        story[2] = "Due to their rushed development, the bots’ software contained blaring vulnerabilities. Several "
                   + "cyber-terrorist organizations banded together, calling themselves the “New Suns,” and sought "
                   + "to accelerate the global warming process in order to cleanse the Earth of the life that had failed it";
        story[3] = "Using spies within NASA and sophisticated computer viruses, the New Suns disabled most of the world’s "
                   + "technological defenses and took control of the maintenance bots, dubbing them “Harvesters” and "
                   + "outfitted them for an attack against the rest of the world.";
        story[4] = "For 5 months, the New Suns' Harvesters have been consuming the Earth’s Ozone layer to lay waste"
                   + "to the world’s environment and inhabitants. In that time, NASA team lead Chad Price "
                   + "has been training with Earth’s resistance force for a chance to redeem himself. "
                   + "Today is that chance, and no Harvester shall be left intact.";
        setCaption(story[0]);
        toggleCaption(true);

        images[0] = new GreenfootImage("images/drought.jpg");
        images[1] = new GreenfootImage("images/earthsorbit.jpg");
        images[2] = new GreenfootImage("images/cyberterrorist.jpg");
        images[3] = new GreenfootImage("images/earthsatellites.jpg");
        images[4] = new GreenfootImage("images/chad_price_grin.png");        
        storyImage = new Image();
        storyImage.setImage(images[0]);
        addObject(storyImage, getWidth() / 2, getHeight() / 3);
    }

    public void act() {
        if(Greenfoot.mouseClicked(null)) {
            if (storyIdx <= 4) {
                setCaption(story[storyIdx]);
                storyImage.setImage(images[storyIdx]);
            }
            else {
                Greenfoot.setWorld(new Lab2World());
            }
            storyIdx++;
        }
    }
}
