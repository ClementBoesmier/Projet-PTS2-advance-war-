package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Team;



/**
 * 
 */
public abstract class Building {

    /**
     * Default constructor
     */
    public Building() {
    }


    /**
     * @return
     */
    public abstract Team getOwner();

    /**
     * @return
     */
    public void onEndTurn() {
        // TODO implement here
    }

}