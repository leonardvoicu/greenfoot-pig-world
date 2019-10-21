import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public Score(int score) {
       GreenfootImage img = new GreenfootImage(100,30);
       img.drawString("Score: " + score, 50, 20);
       setImage(img);
    }
    
    public void setText(int score) {
        GreenfootImage img = getImage();
        img.clear();
       img.drawString("Score: " + score, 50, 20);
    }
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
