// Wall that ghosts can go through but Pacman can't
public class GhostWall extends Wall{
    public GhostWall(){
        super();
        getImage().scale(Wall.SIZE,Wall.SIZE /2);
    
    }
    public void act(){

    }     
}
