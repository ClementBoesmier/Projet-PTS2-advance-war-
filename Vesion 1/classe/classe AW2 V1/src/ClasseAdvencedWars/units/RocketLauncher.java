package ClasseAdvencedWars.units;

import ClasseAdvencedWars.Team;


/**
 * 
 */
public class RocketLauncher extends Units {
    /**
     * 
     */
    private static final int VISION = 0;

    /**
     * 
     */
    private static final int MAXTRAVEL = 4;
    
    /**
     * 
     */
    private static final int COST = 5;
    public RocketLauncher(Team owner) {
        super(owner);
    }
    
    public static int getCost() {
        return COST;
    }
}