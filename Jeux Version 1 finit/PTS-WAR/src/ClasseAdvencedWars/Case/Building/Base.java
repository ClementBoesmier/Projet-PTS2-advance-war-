package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Game;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.units.Infantry;
import ClasseAdvencedWars.units.RocketLauncher;
import ClasseAdvencedWars.units.Tank;
import ClasseAdvencedWars.units.Units;
import ClasseAdvencedWars.Exception.FriendException;
import ClasseAdvencedWars.Exception.SpawnException;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import ressource.BibliotequeImage;


/**
 * 
 */
public class Base extends Building {
    
    private final static int PAYOUT = 10;
    
    private Team owner;
    
    private boolean onCapture=false, firstTurn;
    
    private int nbTurnOnCapture=0;
    
    private boolean isDestroyed=false;
    
    /**
     * Default constructor
     */
    public Base(Team owner, Case acase) {
        super(BibliotequeImage.redUsine, BibliotequeImage.blueUsine,acase, owner);
        this.OWNER = owner;
        firstTurn = true;
    }

    public Base(Team owner) {
        super(BibliotequeImage.redUsine, BibliotequeImage.blueUsine, owner);
        this.OWNER = owner;
        firstTurn = true;
    }

    @Override
    public Team getOwner() {
        return this.OWNER;
    }

    @Override
    public int getPayout() {
        return this.PAYOUT;
    }
    
    public void spawn(Units unit) throws FriendException, SpawnException{
        if(myCase.getUnit() != null){
            throw new SpawnException("Casse occuper");
        }else if(this.OWNER.getMoney()< unit.getCost()){
            throw new SpawnException("Uniter trop chére");
        }else {
            this.OWNER.pay(unit.getCost());
            myCase.setUnit(unit);
        }
    }
    @Override
    public void onEndTurn(){
        if(firstTurn == true)
        {
            this.getOwner().ChangeIncome(this.getPayout());
            firstTurn = false;
        }
        if(myCase.getUnit() != null)
        {
            if(owner != myCase.getUnit().getOwner())
            {
                if(capture())
                {
                    this.owner = myCase.getUnit().getOwner();
                }
            }
        }

    }
    
    public boolean capture(){
        if(myCase.getUnit() != null)
        {
            if(myCase.getUnit().getOwner() != owner)
            {
                switch(this.nbTurnOnCapture){
                    case 0 : this.nbTurnOnCapture++;break;
                    case 1 : this.nbTurnOnCapture++;break;
                    case 2 : this.nbTurnOnCapture++;break;
                    case 3 : this.captured=true;
                    return true;
                }
            }
        }
        return false;
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

    @Override
    public Menu getAction() {
        if(getOwner() != Game.tTurn)
        {
            return new Menu("Pas ton tour !!!!");
        }
        Menu menu = new Menu("Batiment");
        Menu spawn = new Menu("Acheter Unité");
        MenuItem spawnInfantry = new MenuItem("Acheter Infantry (" + Infantry.COST+"PO)");
        MenuItem spawnTank = new MenuItem("Acheter Tank (" + Tank.COST+"PO)");
        MenuItem spawnRocketLauncher = new MenuItem("Acheter Lance Rockette (" + RocketLauncher.COST+"PO)");
        spawnInfantry.setOnAction(event -> {
            try {
                spawn(new Infantry(this.OWNER, this.myCase));
            } catch (FriendException e) {
                e.printStackTrace();
            } catch (SpawnException e) {
                e.printStackTrace();
            }
        });

        spawnTank.setOnAction(event -> {
            try {
                spawn(new Tank(this.OWNER, this.myCase));
            } catch (FriendException e) {
                e.printStackTrace();
            } catch (SpawnException e) {
                e.printStackTrace();
            }
        });

        spawnRocketLauncher.setOnAction(event -> {
            try {
                spawn(new RocketLauncher(this.OWNER, this.myCase));
            } catch (FriendException e) {
                e.printStackTrace();
            } catch (SpawnException e) {
                e.printStackTrace();
            }
        });

        spawn.getItems().add(spawnInfantry);
        spawn.getItems().add(spawnTank);
        spawn.getItems().add(spawnRocketLauncher);
        menu.getItems().add(spawn);
        return menu;
    }

}