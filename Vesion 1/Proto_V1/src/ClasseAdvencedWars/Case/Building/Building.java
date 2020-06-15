package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Game;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.TeamID;
import javafx.scene.image.Image;


/**
 * 
 */
public abstract class Building {
    //affichage
    private Image redFac,blueFac, neutral;
    private Case myCase;

    private boolean captured;
    private Team OWNER;

    /**
     * Default constructor
     */
    public Building(Case myCase) {
        captured = false;
        this.myCase = myCase;
    }

    public Building(Case myCase, Image redFac,Image blueFac,Image neutral) {
        captured = false;
        this.myCase = myCase;
    }

    public Building(Image redFac, Image blueFac, Image neutral, Case myCase, Team OWNER) {
        this.redFac = redFac;
        this.blueFac = blueFac;
        this.neutral = neutral;
        this.myCase = myCase;
        this.OWNER = OWNER;
    }

    public Building(Image redFac, Image blueFac, Image neutral, Case myCase) {
        this.redFac = redFac;
        this.blueFac = blueFac;
        this.neutral = neutral;
        this.myCase = myCase;
    }

    public Building(Image redFac, Image blueFac, Case myCase, Team OWNER) {
        this.redFac = redFac;
        this.blueFac = blueFac;
        this.myCase = myCase;
        this.OWNER = OWNER;
    }

    /**
     * @return
     */
    public abstract Team getOwner();
    
    
    public abstract int getPayout();

    /**
     * @return
     */
    public void onEndTurn() {
        if(!captured){
            captured = true;
            this.getOwner().ChangeIncome(this.getPayout());
        }
    }

    //affichage
    public Image getImage()
    {
        if(getOwner() != null)
        {
            if(getOwner().getTeamID() == TeamID.BLUE)
            {
                return blueFac;
            }else
            {
                return redFac;
            }
        }else
        {
            return neutral;
        }
    }

}