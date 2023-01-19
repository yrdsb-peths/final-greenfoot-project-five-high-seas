import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{

    GreenfootSound buttonSound = new 
        GreenfootSound("button.mp3");
    
    GreenfootImage penguinImage = new 
        GreenfootImage("images/idle_penguin_jetpack.png");
    
    GreenfootImage snowmanImage = new 
        GreenfootImage("images/snowman/snowman3.png");
        
    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        penguinImage.scale(penguinImage.getWidth()/15, 
            penguinImage.getHeight()/15);
        getBackground().drawImage(penguinImage, 
            40, 250);
        
        snowmanImage.scale(snowmanImage.getWidth()/2, 
            snowmanImage.getHeight()/2);
        getBackground().drawImage(snowmanImage, 
            485, 225); 
        
        prepare();
        
    }

    public void act()
    {
        // Starts the game when user presses space bar
        if(Greenfoot.isKeyDown("space"))
        {
            buttonSound.play();
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label arrowsLabel = new 
            Label("Use <- ^ -> to move penguin", 40);
        addObject(arrowsLabel,290,78);
        arrowsLabel.setLocation(300,105);
        
        Label instructionsTitle = new 
            Label("Instructions:", 80);
        addObject(instructionsTitle, 300, 48);
        
        Label label3 = new 
            Label("Press and hold spacebar", 40);
        addObject(label3, 300, 145);
        
        Label spacebarLabel2 = new 
            Label("to fire snowball", 40);
        addObject(spacebarLabel2, 300, 185);
            
        Label label4 = new Label("Objective:", 80);
        addObject(label4, 300, 240);
        
        Label label5 = new Label("Eliminate as many", 40);
        addObject(label5, 300, 300);
        
        Label label6 = new Label("snowmen as possible", 40);
        addObject(label6, 300, 335);
        
        Label startGame = new 
            Label("Press space to start game", 30);
        addObject(startGame, 300, 375);
        
        Label penguinHealth = new Label("5hp", 40);
        addObject(penguinHealth, 75, 225);
        
        Label snowmanHealth = new Label("3hp", 40);
        addObject(snowmanHealth, 525, 200);
    }
}
