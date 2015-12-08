import greenfoot.*;

/**
 * Write a description of class Pacman here.
 * 
 * @author (the communist revolution starts with you) 
 * @version (a version number or a date)
 */
public class Pacman extends MovingObject 
{
    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //My change line : in soviet russia, revolution starts you.
    //THE COMMUNIST REVOLUTION STARTS WITH YOU
    private int score;
    private final GreenfootImage pacmanOpen = new GreenfootImage("Original_PacMan (1).png");
    private final GreenfootImage pacmanClosed = new GreenfootImage("closedPacman.png"); //TODO make this image
    int anim = 0;
    private boolean moving = true;
    public Pacman(int oldScore){
        super();
        getImage().scale(Wall.SIZE, Wall.SIZE);
        pacmanOpen.scale(Wall.SIZE, Wall.SIZE);
        pacmanClosed.scale(Wall.SIZE, Wall.SIZE);
        score = oldScore;
    }
    public int getScore(){
        return score;
    }
    
    public void animate(){
           if(anim > 1000){
              anim = 0;
            }
       
            
            if((anim % 2) == 0 && !wallInFront(getRotation())){
                //This is similar to the code called in the super when deciding on whether or not to move.
                setImage(pacmanClosed);
            }else{
                setImage(pacmanOpen);
            }
        anim++;
    }
    
    public void act(){
        animate();
        if(Greenfoot.isKeyDown("d") && !wallInFront(0)){
            setRotation(0);
        }else if(Greenfoot.isKeyDown("a") && !wallInFront(180)){
            setRotation(180);
        }else if(Greenfoot.isKeyDown("s") && !wallInFront(90)){
            setRotation(90);
        }else if(Greenfoot.isKeyDown("w") && !wallInFront(270)){
           setRotation(270);
        }

        super.act();
        flipWorld();
        if(isTouching(Pellet.class)){
            removeTouching(Pellet.class);
            //Greenfoot.playSound();
            score++;
            String scoreOutput = "Score: ";
            if(score < 10){
                scoreOutput += "   " + score;
            }else if(score < 100){
                scoreOutput += "  " + score;
            }else if(score < 1000){
                scoreOutput += " " + score;
            }else if(score <10000){
                scoreOutput += score;
            }

            getWorld().showText(scoreOutput, 4, 0);
        }
        if(score % 240 ==0){
            //code to reset world
            score++;
            Greenfoot.setWorld(new PacWorld(score));
            
        }
    }    
}
