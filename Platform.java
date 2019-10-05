import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Leonard VOICU
 * @version 1.0.0
 */
public class Platform extends Actor
{
    public Platform() {
        this(100, 25);
    }
    
    public Platform(int width, int height){
        GreenfootImage image = getImage();
        image.scale(width, height);
        setImage(image);
    }
}
