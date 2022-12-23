import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooter here.
 * 
 * @author (Vincent) 
 * @version (version3 | 12/22/2022)
 */
public class Shooter extends Actor
{
    int speed = 4;
    int gravity;
    public Shooter()
    {
        // Sets image to penguin.png and scales it down to use
        GreenfootImage shooter = new GreenfootImage("icon_penguin.png");
        shooter.scale(shooter.getWidth()/30, shooter.getHeight()/30);
        setImage(shooter);
        
        
    }
    
    /**
     * Act - do whatever the Shooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Checks if on a platform, if not the penguin falls
        checkFall();
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
            setLocation(getX(), getY() - speed - gravity);
        }
        /*
        // Using "s" and down arrow keys to move down
        if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + speed/2);
        }
        */
    }
    
    public void checkFall()
    {
        if(onGround() == true)
        {
            gravity = 0;
        }
        if(onGround() == false)
        {
            gravity = 2;
            fall();
        }
    }
    
    public void fall()
    {
        setLocation(getX(), getY() + gravity);
        
        gravity += 1;
    }
    
    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int lookForGround = spriteHeight/2;
        
        Actor ground = getOneObjectAtOffset(0, lookForGround,
        Platform.class);
        
        if(ground == null)
        {
            return false;
        }
        else
        {
            moveToGround(ground);            
        }
        return true;
    }
    
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() -
        (groundHeight + getImage().getHeight())/2;
        
        setLocation(getX(), newY);
    }
    
}
