package ClasseAdvencedWars.Case;

import ClasseAdvencedWars.Case.Building.Building;
import ClasseAdvencedWars.units.Infantry;
import ClasseAdvencedWars.units.RocketLauncher;
import ClasseAdvencedWars.units.Tank;
import ClasseAdvencedWars.units.Units;
import Exception.FriendException;

/**
 * 
 */
public abstract class Case {

    private Units unit = null;
    
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
        return this.unit;
    }

    public void setUnit(Units unit) throws FriendException {
        if(unit == null){
            this.unit = null;
        }else if(this.unit == null){
            this.unit = unit;
        }else if(this.unit.getOwner()== unit.getOwner()){
            throw new FriendException("error : ally unit allredy in the case");
        }else{
            this.unit = this.fight(unit);
        }
    }
    
    /**
     * @return
     */
    public Building getBuilding() {
        return this.building;
    }
    
    private Units fight(Units attack){
        Units sortie = null;
        if(attack.getClass().equals(this.unit.getClass())){
            sortie = null;
        }
        else if(attack instanceof Tank){
            if(this.unit instanceof Infantry){
                sortie = attack;
            }
            else{
                sortie = this.unit;
            }
        }
        else if(attack instanceof RocketLauncher){
            if(this.unit instanceof Tank){
                sortie = attack;
            }
            else{
                sortie = this.unit;
            }
        }
        else if(attack instanceof Infantry){
            if(this.unit instanceof RocketLauncher){
                sortie = attack;
            }
            else{
                sortie = this.unit;
            }
        }
        return sortie;
    }
}