package ClasseAdvencedWars.units;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Team;
import sample.BibliotequeImage;


/**
 * 
 */
public class RocketLauncher extends Units {
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


    public RocketLauncher(Team owner, Case aCase) {
        super(owner, aCase, BibliotequeImage.redBazooka, BibliotequeImage.blueBazooka);
        super.movePoint = RocketLauncher.MAXTRAVEL;
    }
    
    public int getCost() {
        return COST;
    }
    
    @Override
    public void onEndTurn(){
        super.movePoint = RocketLauncher.MAXTRAVEL;
    }
}