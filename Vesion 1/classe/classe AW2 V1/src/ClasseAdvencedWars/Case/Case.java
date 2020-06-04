package ClasseAdvencedWars.Case;

import ClasseAdvencedWars.Case.Building.Building;
import ClasseAdvencedWars.units.Units;

/**
 * 
 */
public abstract class Case {

    private Units unit;
    
    private final Building building;
    
    /**
     * Default constructor
     */
    public Case(Building building) {
        this.building = building;
    }
    public Case(){
        this.building = null;
    }

    /**
     * @return
     */
    public Units getUnit() {
        return unit;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
    }
    
    /**
     * @return
     */
    public Building getBuilding() {
        return building;
    }

}