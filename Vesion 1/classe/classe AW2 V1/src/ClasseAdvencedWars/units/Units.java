package ClasseAdvencedWars.units;

import ClasseAdvencedWars.Location;
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
    public void move(Location location) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Team getOwner() {
        return this.OWNER;
    }

}