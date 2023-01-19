import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (Vincent) 
 * @version (version1 | 12/22/2022)
 */
public class Enemy extends Actor
{
    // Sets the speed, gravity and health of snowman
    public int speed = 4;
    public int gravity;
    public int health = 3;
    
    // Gets image's height and width to make into integers
    public int spriteHeight = getImage().getHeight();
    public int spriteWidth = getImage().getWidth();
    
    // Create integers for enemy to detect dimensions of
    // platform to move side to side
    public int lookForWalls = spriteWidth/2;
    public int lookForEdge = spriteWidth/4;
    public int lookForGround = spriteHeight/2;
    
    GreenfootImage snowmanFull = new 
        GreenfootImage("images/snowman/snowman3.png");
    
    public Enemy()
    {
        snowmanFull.scale(snowmanFull.getWidth()/4, 
            snowmanFull.getHeight()/4);
        
        setImage(snowmanFull);
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        checkFall();
        moveBadGuy();
        getsHit();
    }
    
    public void checkFall()
    {
        // If on ground, stop gravity (don't fall through
        // platform), if not, have gravity and snowman falls
        if(onGround() == true)
        {
            gravity = 0;
        }
        if(onGround() == false)
        {
            gravity = 4;
            fall();
        }
    }
    
    public void fall()
    {
        // Constantly sets snowman's location to 2 pixels
        // below the previous, change snowman's orientation
        setLocation(getX(), getY() + gravity);
        // fallDirection();
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
    
    public void moveBadGuy()
    {
        Actor wall = getOneObjectAtOffset(lookForWalls, 0,
            Platform.class);
        
        Actor cliff = getOneObjectAtOffset(lookForEdge,
            lookForGround, Platform.class);
        
        if(wall == null && cliff == null)
        {
            speed = speed * -1;
            lookForWalls = lookForWalls * -1;
            lookForEdge = lookForEdge * -1;
        }
        else if(wall != null && cliff != null)
        {
            speed *= -1;
            lookForWalls *= -1;
            lookForEdge *= -1;
            
        }
        else
        {
            move(speed);
        }
        
    }
    
    public void getsHit()
    {
        if(isTouching(Snowball.class))
        {
            damage();
        }
    }
    
    public void damage()
    {
        // Gets the snowball and world classes to edit
        // and put into the damage() scope of Enemy.java
        Actor snowball = 
            getOneIntersectingObject(Snowball.class);
        MyWorld world = (MyWorld) getWorld();
        // Removes the snowball when it hits the snowman
        world.removeObject(snowball);        
        // Reduces the health of snowman by 1
        health--;
        speed = speed + (speed/2);
        if(health == 0)
        {
            world.removeObject(this);
            world.spawnSnowman();
            world.increaseScore();
            return;
        }
        GreenfootImage currentSnowman = new 
            GreenfootImage("images/snowman/snowman" 
            + health + ".png");
        currentSnowman.scale(21 * health, 20 * health);
        setImage(currentSnowman);
    }
}
