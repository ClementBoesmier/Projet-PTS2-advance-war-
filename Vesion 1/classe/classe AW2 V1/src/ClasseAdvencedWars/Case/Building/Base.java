package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Team;


/**
 * 
 */
public class Base extends Building {
    
    private final static int PAYOUT = 10;
    
    private final Team OWNER;
    /**
     * Default constructor
     */
    public Base(Team owner) {
        super();
        this.OWNER = owner;
    }

    @Override
    public Team getOwner() {
        return this.OWNER;
    }

    @Override
    public int getPayout() {
        return this.PAYOUT;
    }

}