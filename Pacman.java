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
        getImage().scale(20,20);
    
    }
    public void act() 
    {
        if(Greenfoot.isKeyDown("d")){
            setRotation(0);
        }else if(Greenfoot.isKeyDown("a")){
            setRotation(180);
        }else if(Greenfoot.isKeyDown("s")){
            setRotation(90);
        }else if(Greenfoot.isKeyDown("w")){
            setRotation(270);
        }
        super.act();
    }    
}
