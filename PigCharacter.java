import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Leonard VOICU
 * @version 1.0.0
 */
public class PigCharacter extends Actor
{
    private final int GRAVITY = 1;
    private final int STEP = 3;
    private int velocity;
    private final int DISTANCE_WALL = 20;
    
    public PigCharacter() {
        velocity = 0;
    }
    
    public void act() 
    {
        fall();
        if(Greenfoot.isKeyDown("space") && isOnPlatform()){
            jump();
        }
        move();
    }    
    
    public void fall() {
        setLocation(getX(), getY() + velocity);
        if(isOnPlatform()) {
            velocity = 0;
            while(isOnPlatform()) {
                setLocation(getX(), getY()-1);
            }
            setLocation(getX(), getY()+1);
        }
        else if(velocity < 0 && didBumpHead()){
            velocity = 0;
            while(didBumpHead()){
                setLocation(getX(), getY()+1);
            }
        }
        else {
            velocity += GRAVITY;
        }
    }
    
    public void jump() {
        velocity = -20;
    }
    
    public void move(){
        int x = getX();
        int y = getY();
        if(Greenfoot.isKeyDown("D") && canMoveLeft()){
            x+=STEP;
        }
        if(Greenfoot.isKeyDown("A") && canMoveRight()){
            x-=STEP;
        }
        setLocation(x, y);
    }
    
    public boolean isOnPlatform() {
        boolean isOnGround = false;
        
        if(getY() > getWorld().getHeight() - DISTANCE_WALL) {
            isOnGround = true;
        }
        
        int imageWidth = getImage().getWidth();
        int imageHeight  = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth/ -2, imageHeight/ 2, Platform.class) != null ||
         getOneObjectAtOffset(imageWidth/ 2, imageHeight/ 2, Platform.class) != null
        ) {
            isOnGround = true;
        }
        return isOnGround;
    }
    
    public boolean didBumpHead() {
        boolean bumpedHead = false;
        int imageWidth = getImage().getWidth();
        int imageHeight  = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth/ -2, imageHeight/ -2, Platform.class) != null ||
         getOneObjectAtOffset(imageWidth/ 2, imageHeight/ -2, Platform.class) != null
        ) {
            bumpedHead = true;
        }
        return bumpedHead;
    }
    
    public boolean canMoveLeft(){
        boolean canMoveLeft = true;
        int imageWidth = getImage().getWidth();
        int imageHeight  = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth/ -2 -STEP, imageHeight/ -2 -1, Platform.class) != null ||
         getOneObjectAtOffset(imageWidth/ 2 - STEP, imageHeight/ -2 -1, Platform.class) != null
        ) {
            canMoveLeft = false;
        }
        return canMoveLeft;
    }
    
    public boolean canMoveRight(){
        boolean canMoveRight = true;
        int imageWidth = getImage().getWidth();
        int imageHeight  = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth/ -2 +STEP, imageHeight/ -2 -1, Platform.class) != null ||
         getOneObjectAtOffset(imageWidth/ 2 +STEP, imageHeight/ -2 -1, Platform.class) != null
        ) {
            canMoveRight = false;
        }
        return canMoveRight;
    }
}
