package ClasseAdvencedWars;

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
    private int nbTurn = 1;

    /**
     * 
     */
    private final Maps MAPS;
    
    /**
     * 
     */
    private final Team tBlue;
    
    /**
     * 
     */
    private final Team tRed;
    
    
    private Team tTurn;
    
    //CONSTRUCTEUR TEMPORAIRE
    public Game(Maps maps, Team teamB, Team teamR) {
        this.MAPS = maps;
        this.tBlue = teamB;
        this.tRed = teamR;
        this.tTurn = tBlue;
    }

    public Game(String team1, String team2){
        this.MAPS = new Maps();
        this.tBlue = new Team(team1);
        this.tRed = new Team(team2);
    }

    /**
     * @return
     */
    public void endTurn() {
        HashMap<Location, Case> hMBuilding = this.MAPS.getBuilding();
        HashMap<Location, Case> hMUnits = this.MAPS.getUnits();
        for(Map.Entry<Location, Case> e : hMBuilding.entrySet()){
            if(e.getValue().getBuilding().getOwner() == this.tTurn){
                e.getValue().getBuilding().onEndTurn();
            }
        }
        for(Map.Entry<Location, Case> e : hMUnits.entrySet()){
            if(e.getValue().getUnit().getOwner() == this.tTurn){
                e.getValue().getUnit().onEndTurn();
            }
        }
        if(this.tTurn.equals(this.tRed)){
            this.nbTurn ++;
            this.tTurn = this.tBlue;
        }else{
            this.tTurn = this.tRed;
        }
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
    
}