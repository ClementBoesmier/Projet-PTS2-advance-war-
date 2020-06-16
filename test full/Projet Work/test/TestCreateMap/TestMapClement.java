/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCreateMap;

import ClasseAdvencedWars.Case.Building.Base;
import ClasseAdvencedWars.Case.Building.Town;
import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Case.Ocean;
import ClasseAdvencedWars.Case.Plain;
import ClasseAdvencedWars.Exception.FriendException;
import ClasseAdvencedWars.Location;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.Team;
import static ClasseAdvencedWars.TeamID.BLUE;
import ClasseAdvencedWars.units.Infantry;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author clement
 */
public class TestMapClement {
    Maps map;
    
    Plain plain1;
    Plain plain2;
    Plain plain3;
    
    
    Town town1;
    
    Team team1;
    Base base1;
    
    Infantry inf1;
    
    private Case[][] test;
    
    int width;
    int height;
    
    public TestMapClement(){
    }
    
    @Before
    public void Startup(){
        
        town1 = new Town();
        
        team1 = new Team("michel", BLUE);
        base1 = new Base(team1);
        
        inf1 = new Infantry(team1,new Plain());
        
        plain1 = new Plain(base1);
        plain2 = new Plain(town1);
        plain3 = new Plain();
        
        
        width = 3;
        height = 2;
        
        test = new Case[width][height];

        
    }
    
    @After
    public void TearDown(){
        plain1 = null;
        plain2 = null;
        plain3 = null;
        
        town1 = null;
        base1 = null;
        
        inf1 = null;
        
        test = null;
        
        map = null;
    }
    
    @Test
    public void Maps2X1TestPlain(){
        test[0][0] = plain1;
        test[0][1] = plain2;
        map = new Maps(1,2,test);
    //    System.out.println(map.getCase(0, 0));
    //    System.out.println(map.getCase(0, 1));
    }
    
    private void mapBuilder(){
        test[0][0] = plain1;
        test[1][0] = plain2;
        test[2][0] = plain3;
        for(int i = 0; i < 3; i++){
            test[i][1] = new Ocean();
        }
    }
    
    private void mapViewer(){
        System.out.println("La carte :\n");
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(map.getCase(j, i) instanceof Plain){
                    if(map.getCase(j, i).getBuilding() instanceof Town){
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
    public void MapTestOceanPlainTownBase(){
        mapBuilder();
        map = new Maps(width,height,test);
        mapViewer();
    }
    
    
    private void buildingViewer(HashMap<Location, Case> hBuild){
        System.out.println("Type et posisiton Batiment :");
        hBuild.entrySet().forEach((e) -> {
            System.out.println("X : " + e.getKey().getX() + 
                    " Y : " + e.getKey().getY() + 
                    " "+e.getValue().getBuilding());
        });
    }
    
    @Test
    public void TestSortieGetBuilding(){
        mapBuilder();
        map = new Maps(width,height, test);
        HashMap<Location, Case> cBuilding = new HashMap<>();
        cBuilding = map.getBuilding();
        buildingViewer(cBuilding);
    }
    @Test
    public void TestPositionUnits() throws FriendException{
        Location local;
        mapBuilder();
        map = new Maps(width,height, test);
        map.getCase(2, 1).setUnit(inf1);
        local = map.GetLocal(inf1);
        System.out.println("Posisiton inf A :\nX : "+local.getX()+" Y : "+local.getY()+"\n");
    }
}
