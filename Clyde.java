import greenfoot.*;

/**
 * Write a description of class Clyde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clyde extends Ghost
{
    /**
     * Act - do whatever the Clyde wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Pacman samePacman;
    private int frame;
    public Clyde(){
        super();
        getImage().scale(Wall.SIZE, Wall.SIZE);
        frame = 0;
    }
    public void addedToWorld(World world){//needed so that we don't have getWorld() return null in the constructor
        super.addedToWorld(world);
        samePacman = (Pacman)(world.getObjects(Pacman.class).toArray()[0]);
    }    
    private int getDistToPacman(){
        return (int)(Math.sqrt(Math.pow(samePacman.getX()-getX(),2) + Math.pow(samePacman.getY()-getY(),2))
                    );
    }
    public void act() 
    {
        frame++;
        if(samePacman.getScore() > 80 ){
            if(frame% 30 >4 && getDistToPacman()>8){
                moveTowardThis(samePacman.getX(),samePacman.getY());
            }else{
                moveTowardThis(0,33);
            }
        }
        flipWorld();
    }    
}
