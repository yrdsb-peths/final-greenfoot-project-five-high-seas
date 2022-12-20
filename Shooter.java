import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooter here.
 * 
 * @author (Vincent) 
 * @version (version1 | 12/20/2022)
 */
public class Shooter extends Actor
{
    int speed = 1;
    
    public Shooter()
    {
        GreenfootImage shooter = new GreenfootImage("rocket.png");
        
        setImage(shooter);
    }
    /**
     * Act - do whatever the Shooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            move(-(speed));
        }
        
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            move(speed);
        }
    }
}
