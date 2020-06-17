package ClasseAdvencedWars.Case;


import ClasseAdvencedWars.Case.Building.Building;
import ClasseAdvencedWars.units.Units;
import sample.BibliotequeImage;

import java.util.*;

/**
 * 
 */
public class Ocean extends Case {

    /**
     * Default constructor
     */
    public Ocean() {
        super(BibliotequeImage.ocean);
    }

    //Ne crée pas de canvas
    public Ocean(Building building, boolean test) {
        super(null, false);
    }

    @Override
    public boolean getWalkable(Units aThis) {
        boolean sortie = false;
        return sortie;    }

}