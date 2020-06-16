package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.units.Infantry;
import ClasseAdvencedWars.units.RocketLauncher;
import ClasseAdvencedWars.units.Tank;
import ClasseAdvencedWars.units.Units;
import ClasseAdvencedWars.Exception.FriendException;
import ClasseAdvencedWars.Exception.SpawnException;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import sample.BibliotequeImage;


/**
 * 
 */
public class Base extends Building {
    
    private final static int PAYOUT = 10;
    
    private final Team OWNER;
    
    private boolean onCapture=false, firstTurn = true;
    
    private int nbTurnOnCapture=0;
    
    private boolean isDestroyed=false;
    
    /**
     * Default constructor
     */
    public Base(Team owner, Case acase) {
        super(BibliotequeImage.redUsine, BibliotequeImage.blueUsine,acase, owner);
        this.OWNER = owner;
    }

    public Base(Team owner) {
        super(BibliotequeImage.redUsine, BibliotequeImage.blueUsine, owner);
        this.OWNER = owner;
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
            throw new SpawnException("case occuped");
        }else if(this.OWNER.getMoney()< unit.getCost()){
            throw new SpawnException("units is too expencive");
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

    }
    
    public boolean capture(){
        if(onCapture==true){
                    switch(this.nbTurnOnCapture){
                        case 0 : this.nbTurnOnCapture++;break;
                        case 1 : this.nbTurnOnCapture++;break;
                        case 2 : this.nbTurnOnCapture++;break;
                        case 3 : this.captured=true;break;
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

        spawn.getItems().add(spawnInfantry);
        spawn.getItems().add(spawnTank);
        spawn.getItems().add(spawnRocketLauncher);
        menu.getItems().add(spawn);
        System.out.println("Base GetAction");
        return menu;
    }
}