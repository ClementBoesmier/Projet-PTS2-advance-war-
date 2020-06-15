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
    
}