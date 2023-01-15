import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Vincent) 
 * @version (version2 | 12/22/2022)
 */
public class MyWorld extends World
{
    public int score = 0;
    public static int highScore;
    public static int gameScore;
    Label scoreLabel;

    GreenfootImage background = new 
        GreenfootImage("bg-icebergs-1.png");
    
    Penguin penguin  = new Penguin();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        background.scale(600, 400);

        //Penguin penguin  = new Penguin();
        addObject(penguin, 300, 300);

        Enemy snowman = new Enemy();
        addObject(snowman, 150, 100);
        
        spawnSnowman();
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 40);

        prepare();
        
        
    }

    public void increaseScore()
    {
        // Increases score by 1 and displays on screen
        score++;
        gameScore = score;
        scoreLabel.setValue(score);
        if(score >= highScore)
        {
            highScore = score;
        }
    }

    public void spawnSnowman()
    {
        
        Enemy snowman = new Enemy();
        
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(350);
        addObject(snowman, x, y);
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Platform platform = new Platform();
        //addObject(platform,98,395);

        Platform platform2 = new Platform();
        //addObject(platform2,500,395);
        Platform platform3 = new Platform(150, 20);
        addObject(platform3,538,222);
        Platform platform4 = new Platform();
        addObject(platform4,232,130);
        Platform platform5 = new Platform(150, 20);
        addObject(platform5,500,98);
        Platform platform6 = new Platform();
        //addObject(platform6,300, 395);

        Platform testPlatform = new Platform(600, 20);
        addObject(testPlatform, 300, 395);

        Platform testPlatform2 = new Platform(500, 20);
        addObject(testPlatform2, 300, 300);

        Platform testPlatform3 = new Platform();
        addObject(testPlatform3, 300, 222);
        
        Platform testPlatform4 = new Platform(150, 20);
        addObject(testPlatform4, 75, 222);
    }
}
