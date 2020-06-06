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
       if(this.unit == null){
           this.unit = unit;
       }else if(this.unit.getOwner()== unit.getOwner()){
           throw new FriendException("error : ally unit allredy in the case");
       }else{
           this.fight(unit);
       }
    }
    
    /**
     * @return
     */
    public Building getBuilding() {
        return this.building;
    }
    
    private void fight(Units attack){
        
        if(attack.getClass().equals(this.unit.getClass())){
            this.unit = null;
        }
        else if(attack instanceof Tank){
            if(this.unit instanceof Infantry){
                this.unit = attack;
            }
            else{
                attack = null;
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