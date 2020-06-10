/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestEndTurn;

import ClasseAdvencedWars.Case.Building.Base;
import ClasseAdvencedWars.Case.Building.Town;
import ClasseAdvencedWars.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author clement
 */
public class TestEndTurnClement {
    
    private Team team1;
    
    private Base base1;
    
    private Town town1;
    
    
    public TestEndTurnClement(){}
    
    @Before
    public void Setup(){
        this.team1 = new Team("michel");
        this.base1 = new Base(team1);
        this.town1 = new Town();
        this.town1.setOwner(team1);
    }
    @After
    public void TearDown(){
        this.team1 = null;
        this.base1 = null;
        this.town1 = null;
    }
    
    @Test
    public void TestEndTurnBase(){
        int tempIncome = this.team1.getIncome();
        this.base1.onEndTurn();
        assert(this.team1.getIncome() == tempIncome+10);
    }
    
    @Test
    public void TestEndTurnTown(){
        int tempIncome = this.team1.getIncome();
        this.town1.onEndTurn();
        assert(this.team1.getIncome() == tempIncome+7);
    }
        @Test
    public void TestEndTurnTeam(){
        int tempMoney = this.team1.getIncome();
        this.base1.onEndTurn();
        this.team1.onEndTurn();
        this.base1.onEndTurn();
        this.team1.onEndTurn();
        assert(this.team1.getMoney()== tempMoney+20);
    }
}
