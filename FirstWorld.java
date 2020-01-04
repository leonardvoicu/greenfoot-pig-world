 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Leonard VOICU
 * @version 1.0.0
 */

public class FirstWorld extends World
{
    public final int WORLD_WIDTH = 600;
    public final int WORLD_HEIGHT = 400;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public FirstWorld()
    {    
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Score score= new Score(0);
        addObject(score, 20, 20); 

        Kangoo kangooChar = new Kangoo(score);
        addObject(kangooChar, WORLD_WIDTH-580 , WORLD_HEIGHT - 20 );

        Platform platform1 = new Platform(100, 20);
        addObject(platform1, WORLD_WIDTH - (WORLD_WIDTH-150), WORLD_HEIGHT - (WORLD_HEIGHT - 280)); 

        Platform platform2 = new Platform(70, 20);
        addObject(platform2, WORLD_WIDTH - (WORLD_WIDTH-320), WORLD_HEIGHT - (WORLD_HEIGHT - 300)); 

        Platform platform3 = new Platform(70, 20);
        addObject(platform3, WORLD_WIDTH - (WORLD_WIDTH-450), WORLD_HEIGHT - (WORLD_HEIGHT - 250)); 

        Pizza pizza = new Pizza();
        addObject(pizza,558,106);
        Pizza pizza2 = new Pizza();
        addObject(pizza2,199,127);
        Pizza pizza3 = new Pizza();
        addObject(pizza3,416,331);
        pizza2.setLocation(139,354);
        pizza3.setLocation(214,368);
        pizza.setLocation(346,370);
     
    }
}
