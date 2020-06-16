package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Game;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.TeamID;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;


/**
 * 
 */
public abstract class Building {
    //affichage
    private Image redFac,blueFac, neutral;
    protected Case myCase;

    protected boolean captured;
    protected Team OWNER;
    
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

    public Building(Image redFac, Image blueFac, Team OWNER) {
        this.redFac = redFac;
        this.blueFac = blueFac;
        this.OWNER = OWNER;
    }

    public Building(Image redFac, Image blueFac, Image neutral) {
        this.redFac = redFac;
        this.blueFac = blueFac;
        this.neutral = neutral;
    }

    /**
     * @return
     */
    public abstract Team getOwner();
    
    
    public abstract int getPayout();

    /**
     * @return
     */
    public abstract void onEndTurn();
    //affichage

    public Image getImage()
    {
        if(getOwner() != null)
        {
            System.out.println("appelle image batiment");
            if(getOwner().getTeamID() == TeamID.BLUE)
            {
                System.out.println("Retour bleux");
                return blueFac;
            }else
            {
                System.out.println("Retour Rouge");
                return redFac;
            }
        }else
        {
            System.out.println("Retour neutral");
            return neutral;
        }
    }

    public Case getMyCase() {
        return myCase;
    }
    
    public abstract void setOnCapture(boolean onCapture);

    public abstract boolean isOnCapture();
    public abstract void capture();

    public void setMyCase(Case myCase) {
        this.myCase = myCase;
    }

    public Menu getAction()
    {
        return null;
    }
}