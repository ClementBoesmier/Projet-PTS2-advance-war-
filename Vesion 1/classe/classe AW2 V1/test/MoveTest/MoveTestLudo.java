/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import ClasseAdvencedWars.Case.Building.Base;
import ClasseAdvencedWars.Case.Building.Town;
import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Case.Ocean;
import ClasseAdvencedWars.Case.Plain;
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
 * @author nosni
 */
public class MoveTestLudo {
    
    private Team team1;
    private Infantry inf1;
    
    
    private Case[][] carte;
    
    private Maps map;
    
    private final int height = 7;
    private final int width = 2;

    
    public MoveTestLudo(){}
    
    @Before
    public void startup() throws FriendException{
        team1 = new Team("Blue");
        inf1 = new Infantry(team1);
        
        carte = new Case[width][height];
        
        carte[0][0] = new Plain();
        carte[1][0] = new Plain();
        carte[0][1] = new Ocean();
        carte[1][1] = new Plain();
        carte[1][2] = new Plain();
        carte[1][3] = new Plain();
        carte[1][4] = new Plain();
        carte[1][5] = new Plain();
        carte[1][6] = new Plain();
        carte[0][0].setUnit(inf1);
        
        map = new Maps(2, 7, carte);
    }
    
    @After
    public void TearDown(){
        team1 = null;
        inf1 = null;
        carte = null;
        map = null;
    }
    
        private void mapViewer(){
        System.out.println("La carte :\n");
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
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
    public void TestMove() throws MoveException, FriendException{
        System.out.println("Test 1 : ");
        mapViewer();
        inf1.moveStep(1, 0, map);
        mapViewer();
        System.out.println(" \n");
    }
    
    @Test (expected=MoveException.class)
    public void TestMoveOcean() throws MoveException, FriendException{
        System.out.println("Test 2 : ");
        mapViewer();
        inf1.moveStep(0, 1, map);
        mapViewer();
        System.out.println(" \n");
    }
    
    @Test (expected=MoveException.class)
    public void TestMoveHorsMap() throws FriendException, MoveException{
        System.out.println("Test 3 : ");
        mapViewer();
        inf1.moveStep(1, 0, map);
        inf1.moveStep(1, 0, map);
        mapViewer();
        System.out.println(" \n");
    }
    @Test (expected=MoveException.class)
    public void TestMoveDiagonal() throws MoveException, FriendException{
        System.out.println("Test 4 : ");
        mapViewer();
        inf1.moveStep(1, 1, map);
        mapViewer();
        System.out.println(" \n");
    }
    @Test (expected=MoveException.class)
    public void TestMoveJump() throws MoveException, FriendException{
        System.out.println("Test 5 : ");
        mapViewer();
        inf1.moveStep(2, 0, map);
        mapViewer();
        System.out.println(" \n");
    }
    @Test (expected=MoveException.class)
    public void TestMoveMax() throws MoveException, FriendException{
        System.out.println("Test 6 : ");
        mapViewer();
        inf1.moveStep(1, 0, map);
        inf1.moveStep(-1, 0, map);
        inf1.moveStep(1, 0, map);
        inf1.moveStep(-1, 0, map);
        inf1.moveStep(1, 0, map);
        mapViewer();
        System.out.println(" \n");
    }
}
