package ClasseAdvencedWars.units;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Team;
import sample.BibliotequeImage;


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
    private static final int COST = 5;
    public Tank(Team owner, Case aCase) {
        super(owner, aCase, BibliotequeImage.redBazooka, BibliotequeImage.blueBazooka);
        super.movePoint = Tank.MAXTRAVEL;
    }

    public static int getCost() {
        return COST;
    }
    
    @Override
    public void onEndTurn(){
        super.movePoint = Tank.MAXTRAVEL;
    }

}