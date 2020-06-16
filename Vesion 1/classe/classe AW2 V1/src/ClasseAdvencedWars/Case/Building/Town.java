package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Team;
import sample.BibliotequeImage;


/**
 * 
 */
public class Town extends Building {

    /**
     * 
     */
    private static final int PAYOUT = 7;
    
    private boolean onCapture;
    
    private int nbTurnOnCapture=0;
    
    /**
     * 
     */
    private Team owner;
    
    /**
     * Default constructor
     */
    public Town(Case aCase) {
        super(aCase, BibliotequeImage.ville,BibliotequeImage.ville,BibliotequeImage.ville);
        this.owner = null;
    }


    public void setOwner(Team owner) {
        this.owner = owner;
    }

    @Override
    public Team getOwner() {
        return this.owner;
    }

    @Override
    public int getPayout() {
        return this.PAYOUT;
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
                        case 1 : this.owner=this.getMyCase().getUnit().getOwner();break;
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