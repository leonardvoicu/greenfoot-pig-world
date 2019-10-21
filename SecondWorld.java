import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SecondWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondWorld extends World
{

    /**
     * Constructor for objects of class SecondWorld.
     * 
     */
    public SecondWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Kangoo kangoo = new Kangoo();
        addObject(kangoo,29,33);
        Snakey snakey = new Snakey();
        addObject(snakey,308,308);
        Butterfly butterfly = new Butterfly();
        addObject(butterfly,493,238);
    }
}
