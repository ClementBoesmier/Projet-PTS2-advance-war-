package ClasseAdvencedWars.Case;


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

    @Override
    public boolean getWalkable(Units aThis) {
        boolean sortie = false;
        return sortie;    }

}