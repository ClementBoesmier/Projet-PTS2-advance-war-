package ClasseAdvencedWars;

import ClasseAdvencedWars.Case.Building.Base;
import ClasseAdvencedWars.Case.Building.Building;
import ClasseAdvencedWars.Case.Case;
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
    public static Team tBlue = new Team("test",TeamID.BLUE);
    
    /**
     * 
     */
    public static Team tRed = new Team("test2",TeamID.RED);;
    
    
    private Team tTurn;
    
    //CONSTRUCTEUR TEMPORAIRE
    public Game(Maps maps, Team teamB, Team teamR) {
        this.MAPS = maps;
        this.tBlue = teamB;
        this.tRed = teamR;
        this.tTurn = tBlue;
        this.endTurn();
        this.endTurn();
    }

    /*public Game(String team1, String team2){
       //this.MAPS = new Maps();
       this.tBlue = new Team(team1, TeamID.BLUE);
       this.tRed = new Team(team2, TeamID.RED);
    }*/

    /**
     * @return
     */
    public boolean endTurn() {
        HashMap<Location, Case> hMBuilding = this.MAPS.getBuilding();
        HashMap<Location, Case> hMUnits = this.MAPS.getUnits();
        for(Map.Entry<Location, Case> e : hMBuilding.entrySet()){
            if((e.getValue().getBuilding().getOwner() == this.tTurn)){
                e.getValue().getBuilding().onEndTurn();
            }
            e.getValue().getBuilding().capture();
            /*if((e.getValue().getBuilding() instanceof Base)&&(e.getValue().getBuilding().isCaptured()==true)){
                return true;
            }*/
        }
        for(Map.Entry<Location, Case> e : hMUnits.entrySet()){
            if(e.getValue().getUnit().getOwner() == this.tTurn){
                e.getValue().getUnit().onEndTurn();
            }
        }
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
    
}