package ClasseAdvencedWars.units;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Team;
import sample.BibliotequeImage;


/**
 * 
 */
public class Infantry extends Units {
        /**
     * 
     */
    private static final int VISION = 0;

    /**
     * 
     */
    private static final int MAXTRAVEL = 4;
    
    /**
     * 
     */
    public static final int COST = 5;
    
    public Infantry(Team owner, Case aCase) {
        super(owner, aCase, BibliotequeImage.redInfantrie, BibliotequeImage.blueInfantrie);
        super.movePoint = Infantry.MAXTRAVEL;
    }


    public int getCost() {
        return COST;
    }


    @Override
    public void onEndTurn(){
        super.movePoint = Infantry.MAXTRAVEL;
    }
}