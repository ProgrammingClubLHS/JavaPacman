
/**
 * Write a description of class MovingObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingObject extends Actor
{
    /**
     * Act - do whatever the MovingObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * THE COMMUNIST REVOLUTION STARTS WITH YOU!
     */
    protected boolean wallInFront(){
        Object[] inFront = (getObjectsAtOffset(
                                    (int)(Math.cos(getRotation() * Math.PI / 180)),
                                    (int)(Math.sin(getRotation() * Math.PI / 180)),
                                    Wall.class).toArray()
                                );
        boolean wallPresence = false;
        if(inFront != null && inFront.length > 0){
            for(int index = 0; index < inFront.length; index++){
                Wall possibleWall = (Wall)(inFront[index]);
                if(possibleWall != null){
                    wallPresence = true;
                }
            }
        }               
        return wallPresence;
    }
    public void act() 
    {
        for(int i = 0;i < 3; i++){
            try{
                if(!wallInFront()){
                    move(1);
                }
            }catch( RuntimeException e){
            Greenfoot.ask(e.getMessage());
            }
        }
        if(Greenfoot.isKeyDown(" ")){
            move(3);
        }
    }    
}
