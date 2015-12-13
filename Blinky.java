import greenfoot.*;

/**
 * Write a description of class Clyde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blinky extends Ghost
{
    private Pacman samePacman;
    private int frame;
    public Blinky(){
        super();
        getImage().scale(Wall.SIZE, Wall.SIZE);
        frame = 0;
    }
    public void act() 
    {
        if(frame==0){
            samePacman = (Pacman)(getWorld().getObjects(Pacman.class).toArray()[0]);
        }
        if(samePacman.getScore()==30){
            setLocation(13,12);
        }
        frame++; //samePacman.getScore
        if(samePacman.getScore() > 30){
            if(frame% 30 >4){
                moveTowardThis(samePacman.getX(),samePacman.getY());
                getWorld().showText("chase",getWorld().getWidth()*3 / 4, 0);
            }else{
                moveTowardThis(26,33);
                getWorld().showText("scatter",getWorld().getWidth()*3 / 4, 0);
            }
        }
        flipWorld();
    }    
}