/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestEndTurn;

import ClasseAdvencedWars.Case.Building.Base;
import ClasseAdvencedWars.Case.Building.Town;
import ClasseAdvencedWars.Team;
import static java.time.Clock.system;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ordinateur
 */
public class EndTurnTestBastien 
{
    private Team team1;
    private Town town1;
    private Town town2;
    private Base base;
    
    public EndTurnTestBastien()
    {}
    
    @Before
    public void Setup(){
        team1 = new Team("team1");
        base = new Base(team1);
        town1 = new Town();
        town1.setOwner(team1);
        town2=new Town();
        town2.setOwner(team1);
    }
    
    @After
    public void TearDown()
    {
        base = null;
        team1 = null;
        town1 = null;
        town2 = null;
    }
    
    @Test
    public void TestEndTurnTownWithOneTown()
    {
        town1.onEndTurn();
        team1.onEndTurn();
        assertEquals(7, team1.getMoney());
    }
    
    @Test
    public void TestEndTurnWithOneBase()
    {
        base.onEndTurn();
        team1.onEndTurn();
        assertEquals(team1.getMoney(),10);
    }
    
    
    
    @Test
    public void TestEndTurnWithSeveralBuildings()
    {   
        town1.onEndTurn();
        base.onEndTurn();
        town2.onEndTurn();
        team1.onEndTurn();
        assertEquals(24, team1.getMoney());
    }
    
    @Test
    public void TestEndTurnWithNothing()
    {
        team1.onEndTurn();
        assertEquals(team1.getMoney(),0);
    }
}
