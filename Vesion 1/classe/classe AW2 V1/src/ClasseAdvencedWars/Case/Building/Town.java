package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Team;


/**
 * 
 */
public class Town extends Building {

    /**
     * 
     */
    private final int PAYOUT;
    
    /**
     * 
     */
    private Team owner;
    
    /**
     * Default constructor
     */
    public Town(int payout) {
        super();
        this.PAYOUT = payout;
        this.owner = null;
    }


    /**
     */
    @Override
    public void onEndTurn() {
        // TODO implement here
    }

    public void setOwner(Team owner) {
        this.owner = owner;
    }

    @Override
    public Team getOwner() {
        return this.owner;
    }
    
}