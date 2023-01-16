import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snowball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snowball extends Actor
{
    // Set the inital speed of the snowball and image
    public int speed = 20;
    
    GreenfootSound snowballSound = new
        GreenfootSound("snowball.mp3");
    GreenfootImage snowball = new
        GreenfootImage("images/temp_snowball.png");
    
    public Snowball(int snowballSpeed)
    {
        // Resizes the size of the snowball image and sets
        // speed to either move left (-20) or right (20)
        snowball.scale(snowball.getWidth()/60, 
            snowball.getHeight()/60);
        setImage(snowball);
        snowballSound.play();
        speed = snowballSpeed;
    }
    
    /**
     * Act - do whatever the Snowball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Moves the snowball and removes if touching edge
        // of the map
        move(speed);
        removeSnowball();
    }
    
    public void removeSnowball()
    {
        if(getX() >= getWorld().getWidth() - 1 ||
           getX() == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
