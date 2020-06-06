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
    private final int VISION;

    /**
     * 
     */
    private final int MAXTRAVEL;

    /**
     * 
     */
    private int movePoint;

    /**
     * 
     */
    private final int COST;

    private final Team OWNER;
    
    
    /**
     * Default constructor
     */
    public Units(Team owner, int vision, int maxTravel, int cost) {
        this.OWNER = owner;
        this.COST = cost;
        this.MAXTRAVEL = maxTravel;
        this.VISION = vision;
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