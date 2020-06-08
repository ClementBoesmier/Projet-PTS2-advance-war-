package ClasseAdvencedWars.units;

import ClasseAdvencedWars.Location;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.Team;
import Exception.FriendException;



/**
 * 
 */
public abstract class Units{

    
    /**
     * 
     */
    private int movePoint;


    private final Team OWNER;
    
    
    /**
     * Default constructor
     * @param owner
     */
    public Units(Team owner) {
        this.OWNER = owner;
    }
    /**
     * 
     * @param x
     * @param y
     * @param map
     * @throws ClasseAdvencedWars.units.MoveException
     * @throws Exception.FriendException
     */
    public void moveStep(int x, int y, Maps map) throws MoveException, FriendException{
        Location localPos = map.GetLocalUnit(this);
        if((x != 0 && y != 0) && (x < -1 || x > 1) && (y < -1 || y > 1)){
            throw new MoveException("Illegale Step move");
        }else if(map.getCase(localPos.getX()+x, localPos.getY()+y) == null){
            throw new MoveException("hors map");
        }else if(map.getCase(localPos.getX()+x, localPos.getY()+y).getWalkable(this)){
            throw new MoveException("aera not walkable");
        }else{
            map.getCase(localPos.getX()+x, localPos.getY()+y).setUnit(this);
            map.getCase(localPos.getX(), localPos.getY()).setUnit(null);
        }
    }

    /**
     * @return
     */
    public Team getOwner() {
        return this.OWNER;
    }
    
}