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
import Exception.FriendException;
import Exception.MoveException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author clement
 */
public class TestEndTurnClement {
    
    private Team team1;
    
    private Team team2;
    
    private Base base1;
    
    private Town town1;
    
    private Infantry inf1;
    
    private Case[][] carte;
    
    private Maps map;
    
    private Game gParty;
    
    public TestEndTurnClement(){}
    

    @Before
    public void Setup(){
        this.team1 = new Team("michel");
        this.base1 = new Base(team1);
        this.town1 = new Town();
        this.town1.setOwner(team1);
        
        this.inf1 = new Infantry(team1);
        this.carte = new Case[3][3];
        
        for(int i = 0; i < 3; i++){
            this.carte[i][0] = new Plain();
        }
        this.carte[0][1] = new Plain(this.town1);
        this.carte[1][1] = new Plain(this.base1);
        this.carte[2][1] = new Plain();
        
        this.carte[0][2] = new Plain();
        this.carte[1][2] = new Ocean();
        this.carte[2][2] = new Ocean();
        
        this.map = new Maps(3, 3, carte);
        
        this.team2 = new Team("patrick");
        this.gParty = new Game(map, team1, team2);
    }
    @After
    public void TearDown(){
        this.team1 = null;
        this.base1 = null;
        this.town1 = null;
        this.inf1 = null;
        this.carte = null;
        this.map = null;
    }
    private void mapViewer(){
        System.out.println("La carte :\n");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(map.getCase(j, i) instanceof Plain){
                    if(map.getCase(j, i).getUnit() instanceof Infantry){
                        System.out.print("I");
                    }else if(map.getCase(j, i).getBuilding() instanceof Town){
                        System.out.print("T");
                    }else if(map.getCase(j, i).getBuilding() instanceof Base){
                        System.out.print("B");
                    }else{
                        System.out.print("P");
                    }
                }else if(map.getCase(j, i) instanceof Ocean){
                    System.out.print("O");
                }else{
                    System.out.print("X");
                }
            }
        System.out.println();
        }
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
    
    //@Test
    public void TestEndTurnUnit() throws FriendException, MoveException{
        this.mapViewer();
        this.map.getCase(0, 0).setUnit(inf1);
        this.map.getCase(0, 0).getUnit().moveStep(1, 0, map);
        this.mapViewer();
        this.map.getCase(1, 0).getUnit().moveStep(1, 0, map);
        this.mapViewer();
        this.map.getCase(2, 0).getUnit().moveStep(0, 1, map);
        this.mapViewer();
        this.map.getCase(2, 1).getUnit().moveStep(-1, 0, map);
        this.mapViewer();
        this.map.getCase(1, 1).getUnit().onEndTurn();
        System.out.print("----FIN TOUR !!----");
        this.mapViewer();
        this.map.getCase(1, 1).getUnit().moveStep(1, 0, map);
        this.mapViewer();
        this.map.getCase(2, 1).getUnit().moveStep(0, -1, map);
        this.mapViewer();
        this.map.getCase(2, 0).getUnit().moveStep(-1, 0, map);
        this.mapViewer();
        this.map.getCase(1, 0).getUnit().moveStep(-1, 0, map);
        this.mapViewer();
    }
    @Test
    public void TestEndTurnGame() throws MoveException, FriendException{
        this.mapViewer();
        this.gParty.getMAPS().getCase(0, 0).setUnit(inf1);
        this.map.getCase(0, 0).getUnit().moveStep(1, 0, map);
        this.mapViewer();
        this.map.getCase(1, 0).getUnit().moveStep(1, 0, map);
        this.mapViewer();
        this.map.getCase(2, 0).getUnit().moveStep(0, 1, map);
        this.mapViewer();
        System.out.println("\n" + this.gParty.gettTurn().getMoney());
        System.out.println(this.gParty.gettTurn().getIncome());
        System.out.println(this.gParty.getTurnNb());
        System.out.println(this.gParty.gettTurn());
        this.gParty.endTurn();
        System.out.println("\n" + this.gParty.gettTurn().getMoney());
        System.out.println(this.gParty.gettTurn().getIncome());
        System.out.println(this.gParty.getTurnNb());
        System.out.println(this.gParty.gettTurn());
        this.gParty.endTurn();
        System.out.println("\n" + this.gParty.gettTurn().getMoney());
        System.out.println(this.gParty.gettTurn().getIncome());
        System.out.println(this.gParty.getTurnNb());
        System.out.println(this.gParty.gettTurn());
        this.gParty.endTurn();
        System.out.println("\n" + this.gParty.gettTurn().getMoney());
        System.out.println(this.gParty.gettTurn().getIncome());
        System.out.println(this.gParty.getTurnNb());
        System.out.println(this.gParty.gettTurn());
        this.gParty.endTurn();
        System.out.println("\n" + this.gParty.gettTurn().getMoney());
        System.out.println(this.gParty.gettTurn().getIncome());
        System.out.println(this.gParty.getTurnNb());
        System.out.println(this.gParty.gettTurn());
        this.map.getCase(2, 1).getUnit().moveStep(0, -1, map);
        this.mapViewer();
        this.map.getCase(2, 0).getUnit().moveStep(-1, 0, map);
        this.mapViewer();
        this.map.getCase(1, 0).getUnit().moveStep(-1, 0, map);
        this.mapViewer();
    }
}
