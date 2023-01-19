import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (Vincent) 
 * @version (version2 | 12/20/2022)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Jetpack Penguin", 90);
    Label description = new Label("Press space to start", 50);
    
    GreenfootSound bgMusic = new 
        GreenfootSound("bgmusic.mp3");

    GreenfootSound buttonSound = new 
        GreenfootSound("button.mp3");
        
    GreenfootImage penguinImage = new
        GreenfootImage("images/flying_penguin_jetpack.png");
    
    
        
    /**
     * Constructor for objects of class TitleScreen.
     * This is the title screen for the "Jetpack Penguin"
     * game
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(titleLabel, 300, 50);
        addObject(description, getWidth()/2, 360);
        
        penguinImage.scale(penguinImage.getWidth()/4, 
            penguinImage.getHeight()/4);
        
        getBackground().drawImage(penguinImage, 
            175, 90);   
        
        
        
        prepare();
        
        bgMusic.play();
    }

    public void act()
    {
        // Starts the game when user presses space bar
        if(Greenfoot.isKeyDown("space"))
        {
            bgMusic.stop();
            buttonSound.play();
            Instructions gameWorld = new Instructions();
            Greenfoot.setWorld(gameWorld);
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
    }
}
