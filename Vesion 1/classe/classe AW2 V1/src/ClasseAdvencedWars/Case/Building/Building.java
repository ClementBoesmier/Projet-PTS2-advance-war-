package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Team;



/**
 * 
 */
public abstract class Building {
    
    private boolean captured;

    /**
     * Default constructor
     */
    public Building() {
        captured = false;
    }


    /**
     * @return
     */
    public abstract Team getOwner();
    
    
    public abstract int getPayout();
    

    /**
     * @return
     */
    public abstract void onEndTurn();

}