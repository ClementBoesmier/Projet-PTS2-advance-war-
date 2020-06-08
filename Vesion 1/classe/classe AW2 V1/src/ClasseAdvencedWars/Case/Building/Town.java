package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Team;


/**
 * 
 */
public class Town extends Building {

    /**
     * 
     */
    private static final int PAYOUT = 7;
    
    /**
     * 
     */
    private Team owner;
    
    /**
     * Default constructor
     */
    public Town() {
        super();
        this.owner = null;
    }


    public void setOwner(Team owner) {
        this.owner = owner;
    }

    @Override
    public Team getOwner() {
        return this.owner;
    }

    @Override
    public int getPayout() {
        return this.PAYOUT;
    }
    
}