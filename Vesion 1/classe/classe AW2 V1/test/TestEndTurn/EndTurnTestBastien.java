/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestEndTurn;

import ClasseAdvencedWars.Case.Building.Base;
import ClasseAdvencedWars.Case.Building.Town;
import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Case.Ocean;
import ClasseAdvencedWars.Case.Plain;
import ClasseAdvencedWars.Game;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.units.Infantry;
import ClasseAdvencedWars.units.RocketLauncher;
import ClasseAdvencedWars.units.Tank;
import Exception.FriendException;
import Exception.MoveException;
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
    private Team teamR;
    private Team teamB;
    
    private Base baseR;
    private Base baseB;
    
    private Town townR;
    private Town townB;
    
    private Infantry infantryR;
    private RocketLauncher infantryB;
    
    private Case[][] carte;
    
    private Maps Lamap;
    
    private Game game;
    
    
    public EndTurnTestBastien()
    {}
    
    @Before
    public void Setup()
    {
        this.teamR = new Team("fifi");
        teamB = new Team("fofo");
        this.baseR = new Base(teamR);
        baseB = new Base(teamB);
        this.townR = new Town();
        this.townR.setOwner(teamR);
        this.townB = new Town();
        this.townB.setOwner(teamB);
        this.infantryR = new Infantry(teamR);
        infantryB =  new RocketLauncher(teamB);
        this.carte = new Case[3][3];
        for(int i = 0; i < 3; i++)
        {
            this.carte[i][0] = new Plain();
        }
        this.carte[0][1] = new Plain(this.townR);
        this.carte[1][1] = new Plain(this.baseR);
        this.carte[2][1] = new Plain(baseB);
        carte[0][2] = new Plain();
        carte[1][2] = new Ocean();
        carte[2][2] = new Ocean();
        Lamap = new Maps(3, 3, carte);
        game = new Game(Lamap, teamR, teamB);
    }
    
    @After
    public void TearDown()
    {
        this.teamR = null;
        this.baseR = null;
        baseB = null;
        this.townR = null;
        townB = null;
        this.infantryR = null;
        this.carte = null;
        this.Lamap = null;
    }
    
    //@Test
    public void TestEndTurnTownWithOneTown()
    {
        townR.onEndTurn();
        teamR.onEndTurn();
        assertEquals(7, teamR.getMoney());
    }
    
    //@Test
    public void TestEndTurnWithOneBase()
    {
        baseR.onEndTurn();
        teamR.onEndTurn();
        assertEquals(teamR.getMoney(),10);
    }
    
    
    
    //@Test
    public void TestEndTurnWithSeveralBuildings()
    {   
        townR.onEndTurn();
        baseR.onEndTurn();
        townB.onEndTurn();
        teamR.onEndTurn();
        assertEquals(24, teamR.getMoney());
    }
    
    //@Test
    public void TestEndTurnWithNothing()
    {
        teamR.onEndTurn();
        assertEquals(teamR.getMoney(),0);
    }
    
    
    private void mapViewer()
    {
        System.out.println("La carte :\n");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++)
            {
                if(Lamap.getCase(j, i) instanceof Plain)
                {
                    if(Lamap.getCase(j, i).getUnit() instanceof Infantry)
                    {
                        System.out.print("I");
                    }
                    else if(Lamap.getCase(j, i).getBuilding() instanceof Town)
                    {
                        System.out.print("T");
                    }
                    else if(Lamap.getCase(j, i).getBuilding() instanceof Base)
                    {
                        System.out.print("B");
                    }
                    else
                    {
                        System.out.print("P");
                    }
                }
                else if(Lamap.getCase(j, i) instanceof Ocean)
                {
                    System.out.print("O");
                }
                else
                {
                    System.out.print("X");
                }
            }
        System.out.println();
        }
    }
    @Test
    public void TestEndTurn() throws FriendException, MoveException
    {
        mapViewer();
        game.getMAPS().getCase(0, 0).setUnit(infantryR);
        Lamap.getCase(0, 0).getUnit().moveStep(1, 0, Lamap);
        Lamap.getCase(1, 0).getUnit().moveStep(1, 0, Lamap);
        Lamap.getCase(2, 0).getUnit().moveStep(0, 1, Lamap);
        mapViewer();
        game.getMAPS().getCase(0, 2).setUnit(infantryB);
        System.out.println(game.gettTurn().getMoney());
        System.out.println(game.gettTurn().getIncome());
        System.out.println(game.getTurnNb());
        game.endTurn();
        System.out.println(game.gettTurn().getMoney());
        System.out.println(game.gettTurn().getIncome());
        System.out.println(game.getTurnNb());
        game.endTurn();
        System.out.println(game.gettTurn().getMoney());
        System.out.println(game.gettTurn().getIncome());
        System.out.println(game.getTurnNb());
        game.endTurn();
        System.out.println(game.gettTurn().getMoney());
        System.out.println(game.gettTurn().getIncome());
        System.out.println(game.getTurnNb());
        game.endTurn();
        System.out.println(game.gettTurn().getMoney());
        System.out.println(game.gettTurn().getIncome());
        System.out.println(game.getTurnNb());
        Lamap.getCase(2, 1).getUnit().moveStep(0, -1, Lamap);
        Lamap.getCase(2, 0).getUnit().moveStep(-1, 0, Lamap);
        Lamap.getCase(1, 0).getUnit().moveStep(-1, 0, Lamap);
        mapViewer();
    }
}
