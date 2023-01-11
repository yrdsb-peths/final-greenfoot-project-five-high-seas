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
    public int speed = 5;
    public int gravity;
    public int health = 5;
    
    public int snowballSpeed = 20;
    // Sets penguin to face right and creates arrays storing
    // 5 total images to animate walk cycle
    String facingDirection = "right";
    SimpleTimer animationSpeed = new SimpleTimer();
    
    // Creates arrays for walk cycles left and right
    GreenfootImage[] walkingRight = new GreenfootImage[4];
    GreenfootImage[] walkingLeft = new GreenfootImage[4];
    
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
    
    GreenfootImage hurtRight = new
        GreenfootImage("images/penguin_hurt.png");
    GreenfootImage hurtLeft = new
        GreenfootImage("images/penguin_hurt.png");
    
    public Penguin()
    {
        // Sets penguin image to idle facing right when a
        // OBJECT is created and then scales it down
        idleImage.scale(idleImage.getWidth()/30, 
            idleImage.getHeight()/30);
        
        animationSpeed.mark();
        hurtSpeed.mark();
        //hurtImageSpeed.mark();
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
        // Scaling down the penguin images for flying
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
        
        hurtRight.scale(idleImage.getWidth(),
            idleImage.getHeight());
        
        hurtLeft.mirrorHorizontally();
        hurtLeft.scale(idleImage.getWidth(),
            idleImage.getHeight());
    }
    
    /**
     * Act - do whatever the Shooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // The time integer controls the speed the snowballs are
    // thrown by the penguin
    private int time = 0;
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
            snowballSpeed = -20;
        }
        // Using "d" and right arrow keys to move right
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + speed, getY());
            facingDirection = "right";
            animateWalk();
            snowballSpeed = 20;
        }
        // Using "w" and up arrow keys to move up
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - speed - gravity);
            flyDirection();
        }
        // If the spacebar is pressed and 5 cycles have
        // passed, create a snowball object at same location
        // as the penguin, firing the snowball
        if(Greenfoot.isKeyDown("space"))
        {
            if(time <= 0) 
            {
                time = 5;
                getWorld().addObject(new 
                    Snowball(snowballSpeed), getX(),
                    getY());
                
            }   
            else 
            {
                time--;
            }
        }
        
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Enemy.class))
        {
            getsHurt();
        }
        if(health > 0)
        {
            showHealth();
        }
        else
        {
            world.removeObject(currentHealth);
        }
    }
    
    public void checkFall()
    {
        // If on ground, stop gravity (don't fall through
        // platform), if not, have gravity and penguin falls
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
        // Constantly sets penguin's location to 2 pixels
        // below the previous, change penguin's orientation
        setLocation(getX(), getY() + gravity);
        fallDirection();
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
    public int imageIndex = 0;
    public void animateWalk()
    {
        // If penguin is not on ground or 42 milliseconds
        // has not passed, do not animate the walk
        if(animationSpeed.millisElapsed() <= 42 || 
            !onGround())
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
    
    public void flyDirection()
    {
        if(facingDirection.equals("right"))
        {
            setImage(flyingRight);
        }
        if(facingDirection.equals("left"))
        {
            setImage(flyingLeft);
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
    
    SimpleTimer labelDisplay = new SimpleTimer();
    SimpleTimer hurtSpeed = new SimpleTimer();
    public void getsHurt()
    {
        
        if(hurtSpeed.millisElapsed() >= 100)
        {
            health--;
        }
        hurtSpeed.mark();
        if(health == 0)
        {
            dies();
        }
        if(hurtSpeed.millisElapsed() <= 5000)
        {
            
            if(facingDirection.equals("right"))
            {
                setImage(hurtRight);
            }
            if(facingDirection.equals("left"))
            {
                setImage(hurtLeft);
            }
        }
        
        
    }
    
    public void dies()
    {
        MyWorld world = (MyWorld) getWorld();
        world.removeObject(this);
    }
    Label currentHealth = new Label(0, 50);
    public void showHealth()
    {
        
        labelDisplay.mark();
        currentHealth.setValue(health);
        
        MyWorld world = (MyWorld) getWorld();
        world.addObject(currentHealth, 0, 0);
        if(labelDisplay.millisElapsed() <= 1000)
        {
            
            currentHealth.setLocation(getX(), getY() - 50);
        }
        else
        {
            world.removeObject(currentHealth);
        }
        
        labelDisplay.mark();
    }
}
