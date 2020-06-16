package ClasseAdvencedWars;


import ClasseAdvencedWars.Case.Building.Town;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;

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

    private DoubleProperty argentAff, incomAff;

    
    /**
     * Default constructor
     */
    public Team(String name, TeamID teamID){
        this.name = name;
        this.money = 0;
        this.income = 0;
        this.teamID = teamID;
        argentAff = new SimpleDoubleProperty();
        incomAff = new SimpleDoubleProperty();
        argentAff.set(money);
        incomAff.set(income);
    }

    public Team(String patrick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
    
    public void ChangeIncome(int i){
        this.income += i;
        this.incomAff.set(income);
    }
    
    public void onEndTurn(){
        this.money+=this.income;
        this.argentAff.set(money);
    }

    public TeamID getTeamID() {
        return teamID;}

    public void pay(int price){
        this.money -= price;
        this.argentAff.set(this.money);
    }

    public DoubleProperty getArgentAffProperty() {
        return argentAff;
    }

    public DoubleProperty getIncomAffProperty() {
        return incomAff;
    }

    //TEST PROVISIOIRE
    public int getIncome(){
        return this.income;
    }
}