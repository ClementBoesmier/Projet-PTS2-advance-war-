package ClasseAdvencedWars;

import ClasseAdvencedWars.Case.Building.Base;
import ClasseAdvencedWars.Case.Building.Building;
import ClasseAdvencedWars.Case.Building.Town;
import ClasseAdvencedWars.Case.Case;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class Game {

    /**
     * 
     */
    private int nbTurn = 0;

    /**
     * 
     */
    private final Maps MAPS;
    
    /**
     * 
     */
    public Team tBlue;
    
    /**
     * 
     */
    public Team tRed;
    
    
    public static Team tTurn;

    private IntegerProperty nbTurnPropeties;

    private HashMap<Location, Case> hMBuilding,hMUnits;
    

    public Game(String maps , Team redTeam, Team blueTeam)
    {
        nbTurnPropeties = new SimpleIntegerProperty();
        this.MAPS = new Maps(maps,redTeam,blueTeam);
        this.tRed = redTeam;
        this.tBlue = blueTeam;
        tTurn = tRed;
        hMBuilding = new HashMap<>();
        hMBuilding = this.MAPS.getBuilding();

        hMUnits = new HashMap<>();
        hMUnits = this.MAPS.getUnits();
        endTurn();
    }

    /**
     * @return
     */
    public boolean endTurn() {
        nbTurnPropeties.set(nbTurn);
        hMUnits = this.MAPS.getUnits();

        //Boucle d'action des batiment
        for(Map.Entry<Location, Case> e : hMBuilding.entrySet()){
            e.getValue().getBuilding().onEndTurn();
        }

        //Boucle d'action des uniter
        for(Map.Entry<Location, Case> e : hMUnits.entrySet()){
            if(e.getValue().getUnit().getOwner() == tTurn)
            {
                e.getValue().getUnit().onEndTurn();
            }
        }

        //Changement de tours et action de fin de tours
        this.tTurn.onEndTurn();
        if(this.tTurn.equals(this.tRed)){
            this.nbTurn ++;
            this.tTurn = this.tBlue;
        }else{
            this.tTurn = this.tRed;
        }
        return false;
    }
    
    /**
     * @return
     */
    public int getTurnNb() {
        return this.nbTurn;
    }

    public Maps getMAPS() {
        return MAPS;
    }

    public Team gettTurn() {
        return tTurn;
    }

    public Team gettBlue() {
        return tBlue;
    }

    public Team gettRed() {
        return tRed;
    }

    public IntegerProperty getNbTurnPropeties() {
        return nbTurnPropeties;
    }
}