package ClasseAdvencedWars.Case;

import ClasseAdvencedWars.Case.Building.Building;
import ClasseAdvencedWars.units.Infantry;
import ClasseAdvencedWars.units.RocketLauncher;
import ClasseAdvencedWars.units.Tank;
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
        Class<? extends Units> aClass = this.unit.getClass();
        
        if(attack instanceof aClass){
            this.unit = null;
        }
        else if(attack instanceof Tank){
            if(this.unit instanceof Infantry){
                this.unit = attack;
            }
            else{
                //TODO : il meurt
            }
        }
        else if(attack instanceof RocketLauncher){
            if(this.unit instanceof Tank){
                this.unit = attack;
            }
            else{
                //TODO : il meurt
            }
        }
        else if(attack instanceof Infantry){
            if(this.unit instanceof RocketLauncher){
                this.unit = attack;
            }
            else{
                //TODO : il meurt
            }
        }
    }
}