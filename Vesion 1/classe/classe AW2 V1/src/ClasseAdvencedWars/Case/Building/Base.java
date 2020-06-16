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
    
    private boolean onCapture=false;
    
    private int nbTurnOnCapture=0;
    
    private boolean isDestroyed=false;
    
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
        }else if(this.OWNER.getMoney()< unit.getCost()){
            throw new SpawnException("units is too expencive");
        }else {
            this.OWNER.pay(unit.getCost());
            terrain.setUnit(unit);
        }
    }
    @Override
    public void onEndTurn(){
                if(!captured){
            captured = true;
            this.getOwner().ChangeIncome(this.getPayout());
            
        }
                
    }
    
    public void capture(){
        if(onCapture==true){
                    switch(this.nbTurnOnCapture){
                        case 0 : this.nbTurnOnCapture++;break;
                        case 1 : this.nbTurnOnCapture++;break;
                        case 2 : this.nbTurnOnCapture++;break;
                        case 3 : this.captured=true;break;
                    }
            }
    }

    @Override
    public boolean isOnCapture() {
        return onCapture;
    }
    
    @Override
    public void setOnCapture(boolean onCapture) {
        this.onCapture = onCapture;
    }

    public int getNbTurnOnCapture() {
        return nbTurnOnCapture;
    }

    public void setNbTurnOnCapture(int nbTurnOnCapture) {
        this.nbTurnOnCapture = nbTurnOnCapture;
    }
    
}