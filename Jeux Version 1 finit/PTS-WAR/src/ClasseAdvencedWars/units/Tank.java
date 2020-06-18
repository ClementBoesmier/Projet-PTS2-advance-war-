package ClasseAdvencedWars.units;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Team;
import ressource.BibliotequeImage;


/**
 * 
 */
public class Tank extends Units {
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

    public Tank(Team owner, Case aCase) {
        super(owner, aCase, BibliotequeImage.redTank, BibliotequeImage.blueTank);
        super.movePoint = Tank.MAXTRAVEL;
    }

    public int getCost() {
        return COST;
    }

    @Override
    public void onEndTurn(){
        super.movePoint = Tank.MAXTRAVEL;
    }

}