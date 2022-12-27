import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooter here.
 * 
 * @author (Vincent) 
 * @version (version3 | 12/22/2022)
 */
public class Penguin extends Actor
{
    // Sets speed of movement to 4 and creates gravity
    int speed = 4;
    int gravity;
    
    // Sets penguin to face right and creates arrays storing
    // 5 total images to animate walk cycle
    String facingDirection = "right";
    SimpleTimer animationSpeed = new SimpleTimer();
    
    // Creates arrays for walk cycles left and right
    GreenfootImage[] walkingRight = new GreenfootImage[4];
    GreenfootImage[] walkingLeft = new GreenfootImage[4];
    
    GreenfootImage[] glidingRight = new GreenfootImage[6];
    GreenfootImage[] glidingLeft = new GreenfootImage[6];
    
    // Creates objects for idle images
    GreenfootImage idleImage = new 
        GreenfootImage("images/idle_penguin_jetpack.png");
    GreenfootImage idleLeft = new 
        GreenfootImage("images/idle_penguin_jetpack.png");
        
    // Creates images for penguin flying
    GreenfootImage flyingRight = new
        GreenfootImage("images/flying_penguin_jetpack.png");
    GreenfootImage flyingLeft = new
        GreenfootImage("images/flying_penguin_jetpack.png");
    
    // Creates images for penguin falling
    GreenfootImage fallingRight = new
        GreenfootImage("images/falling_penguin_jetpack.png");    
    GreenfootImage fallingLeft = new
        GreenfootImage("images/falling_penguin_jetpack.png");
    
    public Penguin()
    {
        // Sets penguin image to idle facing right when a
        // OBJECT is created and then scales it down
        idleImage.scale(idleImage.getWidth()/30, 
            idleImage.getHeight()/30);
        
        animationSpeed.mark();
        setImage(idleImage);
        
        // Creates an image of idle penguin FACING LEFT
        idleLeft.mirrorHorizontally();
        idleLeft.scale(idleImage.getWidth(), 
            idleImage.getHeight());
        
        // Fills image array for WALKING right
        for(int i = 0; i < walkingRight.length; i++)
        {
            walkingRight[i] = new 
                GreenfootImage("images/penguin_walk/penguin_walk" 
                + i + ".png");
            walkingRight[i].scale(idleImage.getWidth(), 
                idleImage.getHeight());
        }
        // Fills image array for walking left
        for(int i = 0; i < walkingLeft.length; i++)
        {
            walkingLeft[i] = new 
                GreenfootImage("images/penguin_walk/penguin_walk" 
                + i + ".png");
            walkingLeft[i].mirrorHorizontally();
            walkingLeft[i].scale(idleImage.getWidth(), 
                idleImage.getHeight());
        }
        
        flyingRight.scale(idleImage.getWidth(),
            idleImage.getHeight());
        
        flyingLeft.mirrorHorizontally();
        flyingLeft.scale(idleImage.getWidth(), 
            idleImage.getHeight());
        
        // Scaling down the penguin images for falling
        fallingRight.scale(idleImage.getWidth(),
            idleImage.getHeight());
        
        fallingLeft.mirrorHorizontally();
        fallingLeft.scale(idleImage.getWidth(),
            idleImage.getHeight());
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
        
        
        
    }
    
    public void checkFall()
    {
        if(onGround() == true)
        {
            gravity = 0;
            if(facingDirection.equals("right"))
            {
                setImage(idleImage);
            }
            else
            {
                setImage(idleLeft);
            }
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
            fallDirection();
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
    
    public void fallDirection()
    {
        if(facingDirection.equals("right"))
        {
            setImage(fallingRight);
        }
        if(facingDirection.equals("left"))
        {
            setImage(fallingLeft);
        }
    }
    
    
}
