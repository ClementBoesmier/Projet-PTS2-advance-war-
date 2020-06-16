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
        System.out.println("OnEndTurn");
        if(this.owner != null)
        {
            if(this.myCase.getUnit().getOwner() != this.getOwner())
            {
                if(this.owner != null)
                {
                    this.owner.ChangeIncome(-this.getPayout());
                }else
                {
                    owner = myCase.getUnit().getOwner();
                    this.owner.ChangeIncome(this.getPayout());
                    myCase.refreshAff();
                }
            }
        }else
        {
            if(this.myCase.getUnit() != null)
            {
                owner = myCase.getUnit().getOwner();
                this.owner.ChangeIncome(this.getPayout());
                myCase.refreshAff();
            }
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