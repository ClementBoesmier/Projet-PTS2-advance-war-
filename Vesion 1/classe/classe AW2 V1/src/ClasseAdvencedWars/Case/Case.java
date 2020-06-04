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
    
    public void fight(Units attack){
        if(attack.toString() == this.unit.toString()){
            this.unit = null;
        }
        else if(attack.toString() == "Tank"){
            if(this.unit.toString() == "Infantry"){
                this.unit = attack;
            }
            else{
                //TODO : il meurt
            }
        }
        else if(attack.toString() == "RocketLauncher"){
            if(this.unit.toString() == "Tank"){
                this.unit = attack;
            }
            else{
                //TODO : il meurt
            }
        }
        else if(attack.toString() == "Infantry"){
            if(this.unit.toString() == "RocketLauncher"){
                this.unit = attack;
            }
            else{
                //TODO : il meurt
            }
        }
    }
}