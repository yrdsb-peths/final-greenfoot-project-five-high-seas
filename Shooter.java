import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooter here.
 * 
 * @author (Vincent) 
 * @version (version1 | 12/20/2022)
 */
public class Shooter extends Actor
{
    int speed = 2;
    
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
        
        // Using "a" and left arrow keys to move left
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - speed, getY());
        }
        // Using "d" and right arrow keys to move right
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + speed, getY());
        }
        // Using "w" and up arrow keys to move up
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - speed);
        }
        // Using "s" and down arrow keys to move down
        if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + speed);
        }
        
        
    }
}
