import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Vincent) 
 * @version (version2 | 12/22/2022)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Penguin penguin  = new Penguin();
        addObject(penguin, 300, 300);
        
        Platform tile1 = new Platform();
        
        addObject(tile1, 500, 100);
        
        Platform tile2 = new Platform();
        addObject(tile2, 200, 200);
        
        Enemy snowman = new Enemy();
        addObject(snowman, 150, 100);
        
    }
    
    public void spawnSnowman()
    {
        Enemy snowman = new Enemy();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(400);
        addObject(snowman, x, y);
    }
    
}
