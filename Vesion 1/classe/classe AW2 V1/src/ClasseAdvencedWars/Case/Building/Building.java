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
    
    public abstract void capture();

    /**
     * @return
     */
    public void onEndTurn() {
        if(!captured){
            captured = true;
            this.getOwner().ChangeIncome(this.getPayout());
            this.capture();
        }
    }

}