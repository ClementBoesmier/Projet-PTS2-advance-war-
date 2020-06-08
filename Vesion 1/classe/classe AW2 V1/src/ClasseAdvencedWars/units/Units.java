package ClasseAdvencedWars.units;

import ClasseAdvencedWars.Location;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.Team;



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
     */
    public Units(Team owner) {
        this.OWNER = owner;
    }
    /**
     * 
     */
    public void moveStep(Maps map){
        Location localPos = map.GetLocalUnit(this);
    }

    /**
     * @return
     */
    public Team getOwner() {
        return this.OWNER;
    }
    
}