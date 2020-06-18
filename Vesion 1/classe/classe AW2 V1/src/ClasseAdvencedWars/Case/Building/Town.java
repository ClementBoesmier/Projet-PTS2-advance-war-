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
    
    
    private boolean onCapture;
    
    /**
     * Default constructor
     */
    public Town(Case aCase) {
        super(aCase, BibliotequeImage.ville,BibliotequeImage.ville,BibliotequeImage.ville);
        this.owner = null;
        this.onCapture = false;
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
    public void onEndTurn() {
        if(!onCapture){
            onCapture = true;
            this.getOwner().ChangeIncome(this.PAYOUT);
        }
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