package ClasseAdvencedWars;


import ClasseAdvencedWars.Case.Building.Town;

import java.util.ArrayList;

/**
 * 
 */
public class Team {
    private TeamID teamID;
    
    /**
     * 
     */
    private int money;

    /**
     * 
     */
    private int income;
    
    /**
     * 
     */
    private final String name;

    private ArrayList<Town> captureTown;
    
    /**
     * Default constructor
     */
    public Team(String name, TeamID teamID){
        this.name = name;
        this.money = 0;
        this.income = 0;
        this.teamID = teamID;
        captureTown = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
    
    public void ChangeIncome(int i){
        this.income += i;
    }
    
    public void onEndTurn(){
        this.money+=this.income;
    }

    public TeamID getTeamID() {
        return teamID;
    }

    //TEST PROVISIOIRE
    public int getIncome(){
        return this.income;
    }
}