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
 * @author clement
 */
public class MoveTestClement {
    private Team team1;
    private Infantry inf1;
    
    
    private Case[][] carte;
    
    private Maps map;
    
    private final int height = 2;
    private final int width = 2;

    
    public MoveTestClement(){}
    
    @Before
    public void startup() throws FriendException{
        team1 = new Team("michel");
        inf1 = new Infantry(team1);
        
        carte = new Case[width][height];
        
        carte[0][0] = new Plain();
        carte[1][0] = new Plain();
        carte[0][1] = new Ocean();
        //carte[1][1] = new Plain();
        
        carte[0][0].setUnit(inf1);
        
        map = new Maps(2, 2, carte);
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
    public void TestMove() throws ClasseAdvencedWars.units.MoveException, FriendException{
        System.out.println(map.getCase(0, 0).getUnit());
        mapViewer();
        inf1.moveStep(1, 0, map);
        mapViewer();
    }
    
    //@Test (expected=ClasseAdvencedWars.units.MoveException.class)
    public void TestMoveOcean() throws ClasseAdvencedWars.units.MoveException, FriendException{
        mapViewer();
        inf1.moveStep(0, 1, map);
        mapViewer();
    }
    
    //@Test (expected=ClasseAdvencedWars.units.MoveException.class)
    public void TestMoveHorsMap() throws ClasseAdvencedWars.units.MoveException, FriendException{
        mapViewer();
        inf1.moveStep(-1, 0, map);
        mapViewer();
    }
}
