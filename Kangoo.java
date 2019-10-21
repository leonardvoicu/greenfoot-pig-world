import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Leonard VOICU
 * @version 1.0.0
 */
public class Kangoo extends Actor
{
    private final int GRAVITY = 1;
    private final int STEP = 3;
    private int velocity;
    private final int DISTANCE_WALL = 20;
    private int counterPizza = 0;
    private Score myScore;
    
    public Kangoo() {
        velocity = 0;
    }
    
    public Kangoo(Score score) {
        myScore = score;
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
        
        meetingPizza();
        finishSecondWorld();
        setLocation(x, y);
    }
    
    public void finishSecondWorld() {
        meetingSnakey();
        meetingButterfly();
    }
    
    public void meetingSnakey() {
        int imageWidth = getImage().getWidth();
        int imageHeight  = getImage().getHeight();
        Actor snakey = getOneIntersectingObject(Snakey.class);
        if(snakey != null){
            this.gameOver();
        }
    }
    
    
    public void meetingButterfly() {
        int imageWidth = getImage().getWidth();
        int imageHeight  = getImage().getHeight();
        Actor butterfly = getOneIntersectingObject(Butterfly.class);
        if(butterfly != null){
            this.gameOver();
        }
    }
    
    public void gameOver() {
        World _world = getWorld();
        //_world.removeObject(this);
    }
    
    public void meetingPizza() {
        int imageWidth = getImage().getWidth();
        int imageHeight  = getImage().getHeight();
        Actor pizza = getOneIntersectingObject(Pizza.class);
        if(pizza != null){
                World w = getWorld();
                meetPizza();
                w.removeObject(pizza);
        }
        if(counterPizza == 3) {
            SecondWorld _world_ = new SecondWorld();
            Greenfoot.setWorld(_world_);
        }
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
    
    public void meetPizza() {
        counterPizza++;
        myScore.setText(counterPizza);
    }
}
