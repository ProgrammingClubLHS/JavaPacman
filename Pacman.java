import greenfoot.*;

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends MovingObject 
{
    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Pacman(){
        super();
        getImage().scale(Wall.size,Wall.size);
    
    }
    public void act() 
    {
       if(Greenfoot.isKeyDown("d") && !wallInFront(0)){
            setRotation(0);
        }else if(Greenfoot.isKeyDown("a") && !wallInFront(180)){
            setRotation(180);
        }else if(Greenfoot.isKeyDown("s") && !wallInFront(90)){
            setRotation(90);
        }else if(Greenfoot.isKeyDown("w") && !wallInFront(270)){
            setRotation(270);
        }
        if(getX() == 0 && getRotation() == 180){
            setLocation(getWorld().getWidth(),getY());
        }
        
        if(getX() == getWorld().getWidth() && getRotation() == 0){
            setLocation(0,getY());
        }
        super.act();
        if(isTouching(Pellet.class)){
            removeTouching(Pellet.class);
            score++;
        }
    }    
}
