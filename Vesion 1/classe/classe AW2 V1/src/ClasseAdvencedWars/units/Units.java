package ClasseAdvencedWars.units;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Location;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.Exception.FriendException;
import ClasseAdvencedWars.Exception.MoveException;
import ClasseAdvencedWars.TeamID;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;


/**
 * 
 */
public abstract class Units{
    //affichage
    private Image redFac,blueFac;
    private Case aCase;
    private Menu menu;
    
    /**
     * 
     */
    protected int movePoint;


    private final Team OWNER;
    
    
    /**
     * Default constructor
     * @param owner
     */
    public Units(Team owner, Case aCase, Image redFac, Image blueFac) {
        this.OWNER = owner;
        this.aCase = aCase;
        this.redFac = redFac;
        this.blueFac = blueFac;
    }
    /**
     * 
     * @param x
     * @param y
     * @param map
     * @throws Exception.MoveException
     * @throws Exception.FriendException
     */
    public void moveStep(int x, int y, Maps map) throws MoveException, FriendException{
        int localY = 0;
        int localX = 0;
        Location localPos;
        if(this.movePoint <= 0){
            throw new MoveException("no more MP");
        }else if((x != 0 && y != 0) || (x < -1 || x > 1) || (y < -1 || y > 1) || ( y == 0 && x == 0)){
            throw new MoveException("Illegale Step move");
        }else{
            localPos = map.GetLocal(this);
            localX = localPos.getX();
            localY = localPos.getY();
        }
        if(map.getCase(localX+x, localY+y) == null){
            throw new MoveException("hors map");
        }else if(!map.getCase(localX+x, localY+y).getWalkable(this)){
            throw new MoveException("aera not walkable");
        }else{
            map.getCase(localX+x, localY+y).setUnit(this);
            map.getCase(localX, localY).setUnit(null);
            this.movePoint-=1;
        }
    }

    /**
     * @return
     */
    public Team getOwner() {
        return this.OWNER;
    }
    
    /**
     *
     */
    public abstract void onEndTurn();
    
    public abstract int getCost();
}