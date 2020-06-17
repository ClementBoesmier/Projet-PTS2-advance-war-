/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSpawn;

import ClasseAdvencedWars.Case.Building.Base;
import ClasseAdvencedWars.Case.Building.Town;
import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Case.Ocean;
import ClasseAdvencedWars.Case.Plain;
import ClasseAdvencedWars.Exception.FriendException;
import ClasseAdvencedWars.Exception.MoveException;
import ClasseAdvencedWars.Exception.SpawnException;
import ClasseAdvencedWars.Game;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.TeamID;
import ClasseAdvencedWars.units.Infantry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author clement
 */
public class TestSpawnClement {
    
    private Game gParty;
    
    private Case[][] carte;
    
    private Team team1;
    private Team team2;
    
    private Maps map;
    
    public TestSpawnClement(){};
    
    @Before
    public void Startup(){
        
        this.team1 = new Team("Michel", TeamID.BLUE);
        this.team2 = new Team("Patrick", TeamID.RED);
        this.carte = new Case[3][3];
        
        for(int i = 0; i < 3; i++){
            this.carte[i][1] = new Plain();
        }
        
        for(int i = 0; i < 3; i++){
            this.carte[i][2] = new Plain();
        }
        
        
        this.carte[0][0] = new Plain(new Base(team1));
        this.carte[1][0] = new Plain(new Town());
        this.carte[2][0] = new Plain();
        
        this.map = new Maps(3,3,carte);
        gParty = new Game(map);
    }
    
    @After
    public void TearDown(){
        this.carte = null;
        this.gParty = null;
        this.map = null;
        this.team2 = null;
        this.team2 = null;
    }
    
    private void mapViewer(){
        System.out.println("\nLa carte :\n");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(gParty.getMAPS().getCase(j, i) instanceof Plain){
                    if(gParty.getMAPS().getCase(j, i).getUnit() instanceof Infantry){
                        System.out.print("I");
                    }else if(gParty.getMAPS().getCase(j, i).getBuilding() instanceof Town){
                        System.out.print("T");
                    }else if(gParty.getMAPS().getCase(j, i).getBuilding() instanceof Base){
                        System.out.print("B");
                    }else{
                        System.out.print("P");
                    }
                }else if(gParty.getMAPS().getCase(j, i) instanceof Ocean){
                    System.out.print("O");
                }else{
                    System.out.print("X");
                }
            }
        System.out.println();
        }
    }
    
    @Test
    public void spawnTest() throws FriendException, SpawnException{
        mapViewer();
        Base baseTest = (Base)gParty.getMAPS().getCase(0, 0).getBuilding();
        int moneyStart = baseTest.getOwner().getMoney();
        System.out.println("\n"+moneyStart);
        baseTest.spawn(new Infantry(baseTest.getOwner(),gParty.getMAPS().getCase(0, 0)));
        mapViewer();
        System.out.println("\n"+baseTest.getOwner().getMoney());
        assert(baseTest.getOwner().getMoney() == moneyStart - 5);
    }
    @Test (expected=SpawnException.class)
    public void spawnTestSpawnExceptionCase() throws FriendException, SpawnException{
        mapViewer();
        Base baseTest = (Base)gParty.getMAPS().getCase(0, 0).getBuilding();
        baseTest.spawn(new Infantry(baseTest.getOwner(),gParty.getMAPS().getCase(0, 0)));
        baseTest.spawn(new Infantry(baseTest.getOwner(),gParty.getMAPS().getCase(0, 0)));
    }
    @Test (expected=SpawnException.class)
    public void spawnTestSpawnExceptionMoney() throws FriendException, SpawnException, MoveException{
        mapViewer();
        Base baseTest = (Base)gParty.getMAPS().getCase(0, 0).getBuilding();
        baseTest.spawn(new Infantry(baseTest.getOwner(),gParty.getMAPS().getCase(0, 0)));
        gParty.getMAPS().getCase(0, 0).getUnit().moveStep(0, 1, map);
        baseTest.spawn(new Infantry(baseTest.getOwner(),gParty.getMAPS().getCase(0, 0)));
        gParty.getMAPS().getCase(0, 0).getUnit().moveStep(1, 0, map);
        mapViewer();
        baseTest.spawn(new Infantry(baseTest.getOwner(),gParty.getMAPS().getCase(0, 0)));
    }
}
