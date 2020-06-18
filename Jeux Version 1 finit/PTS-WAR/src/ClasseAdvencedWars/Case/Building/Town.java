package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Team;
import ressource.BibliotequeImage;


/**
 * 
 */
public class Town extends Building {

    /**
     * 
     */
    private static final int PAYOUT = 7;
    
    private boolean onCapture, captureAlreadyCall = false;
    
    private int nbTurnOnCapture=0;
    
    /**
     * 
     */
    private Team owner;
    
    /**
     * Default constructor
     */
    public Town(Case aCase) {
        super(aCase, BibliotequeImage.redVille,BibliotequeImage.blueVille, BibliotequeImage.ville);
        this.owner = null;
    }

    public Town() {
        super(BibliotequeImage.redVille,BibliotequeImage.blueVille, BibliotequeImage.ville);
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
        if(this.owner == null)
        {
            if(capture() && this.myCase.getUnit() != null)
            {
                this.setOwner(this.myCase.getUnit().getOwner());
                this.owner.ChangeIncome(this.getPayout());
            }
        }else
        {
            if(myCase.getUnit() != null)
            {
                if(owner != myCase.getUnit().getOwner())
                {
                    if(capture())
                    {
                        this.owner.ChangeIncome(-this.getPayout());
                        this.owner = myCase.getUnit().getOwner();
                        this.owner.ChangeIncome(this.getPayout());
                        nbTurnOnCapture = 0;
                    }
                }
            }
        }
        myCase.refreshAff();
        captureAlreadyCall = false;
    }

    @Override
    public boolean isOnCapture() {
        return onCapture;
    }

    @Override
    public boolean capture() {
        if(nbTurnOnCapture == 2)
        {
            return true;
        }else
        {
            if(myCase.getUnit() != null || captureAlreadyCall == true)
            {
                nbTurnOnCapture++;
            }else
            {
                nbTurnOnCapture = 0;
            }
        }
        if (nbTurnOnCapture > 2)
        {
            nbTurnOnCapture = 0;
        }

        captureAlreadyCall = true;
        return false;
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