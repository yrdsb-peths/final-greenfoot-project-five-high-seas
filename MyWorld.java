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
    Label scoreLabel;

    GreenfootImage background = new 
        GreenfootImage("bg-icebergs-1.png");

    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        background.scale(600, 400);

        Penguin penguin  = new Penguin();
        addObject(penguin, 300, 300);

        Enemy snowman = new Enemy();
        addObject(snowman, 150, 100);

        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);

        prepare();
    }

    public void increaseScore()
    {
        // Increases score by 1 and displays on screen
        score++;
        scoreLabel.setValue(score);
    }

    public void spawnSnowman()
    {
        Enemy snowman = new Enemy();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(400);
        addObject(snowman, x, y);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Platform platform = new Platform();
        addObject(platform,154,369);
        platform.setLocation(98,388);
        Platform platform2 = new Platform();
        addObject(platform2,330,388);
        platform2.setLocation(500,388);
        Platform platform3 = new Platform();
        addObject(platform3,453,247);
        platform3.setLocation(508,222);
        Platform platform4 = new Platform();
        addObject(platform4,232,130);
        Platform platform5 = new Platform();
        addObject(platform5,516,131);
        platform5.setLocation(526,98);
        Platform platform6 = new Platform();
        addObject(platform6,554,309);
        platform6.setLocation(300, 388);
    }
}
