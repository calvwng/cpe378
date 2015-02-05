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
    int storyIdx = 1;

    /**
     * Constructor for objects of class TransitionScreen.
     */
    public TransitionScreen()
    {    
        story[0] = "In the year 2077, a 3-year drought threw Earth’s water supply and ecosystems into disarray, "
                   + "and global warming could no longer be ignored.";
        story[1] = "In response, NASA quickly started an experimental "
                   + "program to rebuild Earth’s damaged Ozone layer, in an effort to protect our terran environment from "
                   + "further global warming. They rushed development and launched Ozone maintenance bots into the orbit "
                   + "with the goal of upkeeping our precious Ozone layer.";
        story[2] = "Due to their rushed development, the bots’ software contained blaring vulnerabilities. Several "
                   + "cyber-terrorist organizations banded together, calling themselves the “New Suns,” and sought "
                   + "to accelerate the global warming process in order to cleanse the Earth of the life that had failed it";
        story[3] = "Using spies within NASA and sophisticated computer viruses, the New Suns disabled most of the world’s "
                   + "technological defenses and took control of the maintenance bots, dubbing them “Harvesters” and "
                   + "outfitting them for an attack against the rest of the world.";
        story[4] = "For 11 months, the seized bots have been harvesting the Earth’s Ozone layer as fuel for a secret "
                   + "weapon meant to wipe out the world’s current inhabitants. In those 11 months, you have been "
                   + "training with the Earth’s remaining resistance force for an elite operation to destroy the "
                   + "terrorists’ Harvesters and prevent global warming from destroying the only home you know.";
        setCaption(story[0]);
        toggleCaption(true);
    }

    public void act() {
        if(Greenfoot.mouseClicked(null)) {
            if (storyIdx <= 4) {
                setCaption(story[storyIdx]);
            }
            else {
                Greenfoot.setWorld(new Lab2World());
            }
            storyIdx++;
        }
    }
}
