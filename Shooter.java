import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooter here.
 * 
 * @author (Vincent) 
 * @version (version3 | 12/22/2022)
 */
public class Shooter extends Actor
{
    // Sets speed of movement and creates gravity
    int speed = 4;
    int gravity;
    
    // Sets penguin to face right and creates arrays storing
    // 4 images to animate
    String facingDirection = "right";
    SimpleTimer animationSpeed = new SimpleTimer();
    
    GreenfootImage[] walkingRight = new GreenfootImage[4];
    GreenfootImage[] walkingLeft = new GreenfootImage[4];
    
    GreenfootImage[] glidingRight = new GreenfootImage[6];
    GreenfootImage[] glidingLeft = new GreenfootImage[6];
    
    public Shooter()
    {
        // Sets image to penguin.png and scales it down to use
        GreenfootImage idleImage = new 
            GreenfootImage("idle_penguin_jetpack.png");
        idleImage.scale(idleImage.getWidth()/30, 
        idleImage.getHeight()/30);
        
        animationSpeed.mark();
        setImage(idleImage);
        
        // Takes the image file name and puts it into the game
        for(int i = 0; i < walkingRight.length; i++)
        {
            walkingRight[i] = new 
            GreenfootImage("images/penguin_walk/penguin_walk" 
            + i + ".png");
            walkingRight[i].scale(idleImage.getWidth(), 
            idleImage.getHeight());
        }
        // Takes the image and flips it so the elephant faces LEFT
        for(int i = 0; i < walkingLeft.length; i++)
        {
            walkingLeft[i] = new 
            GreenfootImage("images/penguin_walk/penguin_walk" 
            + i + ".png");
            walkingLeft[i].mirrorHorizontally();
            walkingLeft[i].scale(idleImage.getWidth(), 
            idleImage.getHeight());
        }
        
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
            facingDirection = "left";
            animateWalk();
        }
        // Using "d" and right arrow keys to move right
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + speed, getY());
            facingDirection = "right";
            animateWalk();
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
    
    // Image index sets the arrays to 0 (first image)
    int imageIndex = 0;
    public void animateWalk()
    {
        // If penguin is not on ground or 42 milliseconds
        // has not passed, do not animate the walk
        if(animationSpeed.millisElapsed() <= 42 || !onGround())
        {
            return;
        }
        // Takes note of the time for next cycle
        animationSpeed.mark();
        // If ON ground, the if/else statement changes the
        // image depending on if user presses right or left
        if(facingDirection.equals("right"))
        {
            setImage(walkingRight[imageIndex]);
            imageIndex = 
                (imageIndex + 1) % walkingRight.length;
        }
        else
        {
            setImage(walkingLeft[imageIndex]);
            imageIndex =
                (imageIndex + 1) % walkingLeft.length;
        }
    }
    
}
