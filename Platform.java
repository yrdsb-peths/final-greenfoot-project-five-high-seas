import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (Vincent) 
 * @version (version1 | 12/21/2022)
 */
public class Platform extends Actor
{
    GreenfootImage tempIce = new 
        GreenfootImage("tempIce.png");
    
    public Platform()
    {
        tempIce.scale(200, 20);
        setImage(tempIce);
    }
    
    public Platform(int length, int width)
    {
        tempIce.scale(length, width);
        setImage(tempIce);
    }
    
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
