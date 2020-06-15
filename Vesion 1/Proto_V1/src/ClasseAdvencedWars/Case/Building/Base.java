package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.units.Units;
import ClasseAdvencedWars.Exception.FriendException;
import ClasseAdvencedWars.Exception.SpawnException;
import sample.BibliotequeImage;


/**
 * 
 */
public class Base extends Building {
    
    private final static int PAYOUT = 10;
    
    private final Team OWNER;
    /**
     * Default constructor
     */
    public Base(Team owner, Case acase) {
        super(BibliotequeImage.usine, BibliotequeImage.usine,acase, owner);
        this.OWNER = owner;
    }

    @Override
    public Team getOwner() {
        return this.OWNER;
    }

    @Override
    public int getPayout() {
        return this.PAYOUT;
    }
    
    public void spawn(Maps map, Units unit) throws FriendException, SpawnException{
        Case terrain = map.getCase(map.GetLocal(this).getX(), map.GetLocal(this).getY());
        if(terrain.getUnit() != null){
            throw new SpawnException("case occuped");
        }else{
            terrain.setUnit(unit);
        }
    }
}