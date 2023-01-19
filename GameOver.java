import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    Label titleLabel = new Label("Game Over", 125);
    Label description = new Label("Press enter to restart", 50);
    public int currentHighScore;
    public int currentScore;
    
    GreenfootSound buttonSound = new 
        GreenfootSound("button.mp3");
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        currentHighScore = MyWorld.highScore;
        currentScore = MyWorld.gameScore;
        
        addObject(titleLabel, getWidth()/2, 75);
        addObject(description, getWidth()/2, 350);
        
        String highScore = "High Score:";
        Label highScoreWord = new Label(highScore, 50);
        addObject(highScoreWord, 250, getHeight()/2);
        
        Label highScoreLabel = new Label(currentHighScore, 60);
        addObject(highScoreLabel, 395, getHeight()/2);
        
        String score = "Score:";
        Label scoreWord = new Label(score, 50);
        addObject(scoreWord, 300, 250);
        
        Label currentScoreLabel = new Label(currentScore, 60);
        addObject(currentScoreLabel, 395, 250);
        
    }
    
    public void act()
    {
        // Starts the game when user presses space bar
        if(Greenfoot.isKeyDown("enter"))
        {
            buttonSound.play();
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
}
