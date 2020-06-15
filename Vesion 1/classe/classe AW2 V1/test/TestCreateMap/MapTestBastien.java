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
import ClasseAdvencedWars.Location;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.units.Infantry;
import Exception.FriendException;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ordinateur
 */
public class MapTestBastien 
{
    Maps map;
    
    Plain plainA;
    Plain plainB;
    
    Plain plainC;
    
    Plain plainD;
    
    
    Town town1;
    
    Town town2;
    
    Team teamR;
    
    Base baseA;
    
    private Case[][] test;
    
    Infantry infantryR;
    
    
    
    int width;
    int height;
    
    public MapTestBastien()
    {}
    
    @Before
    public void Startup()
    {
        
        town1 = new Town();
        
        teamR = new Team("team1");
        baseA = new Base(teamR);
        
        infantryR = new Infantry(teamR);
        
        plainA = new Plain(baseA);
        plainB = new Plain(town1);
        plainC = new Plain();
        
        
        width = 3;
        height = 3;
        
        test = new Case[width][height];

        
    }
    
    @After
    public void TearDown()
    {
        plainA = null;
        plainB = null;
        plainC = null;
        
        town1 = null;
        baseA = null;
        
        infantryR = null;
        
        test = null;
        
        map = null;
    }
    
    private void mapViewer()
    {
        System.out.println("La carte :\n");
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                if(map.getCase(j, i) instanceof Plain)
                {
                    if(map.getCase(j, i).getBuilding() instanceof Town)
                    {
                        System.out.print("T");
                    }
                    else if(map.getCase(j, i).getBuilding() instanceof Base)
                    {
                        System.out.print("B");
                    }
                    else
                    {
                        System.out.print("P");
                    }
                }
                else if(map.getCase(j, i) instanceof Ocean)
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
    public void TestCreateMapWithAll()
    {
        boolean testMap =false;
        test[0][0] = plainA;
        test[0][1] = plainB;
        test[1][0] = plainC;
        test[1][1] = new Ocean();
        map = new Maps(1,2,test);
        if (map.getCase(0, 0).getBuilding() instanceof Base)
        {
            if (map.getCase(0, 1).getBuilding() instanceof Town)
            {
               if (map.getCase(1, 0) instanceof Plain)
               {
                   if (map.getCase(1, 1) instanceof Ocean)
                    {
                        testMap = true;
                    }
               } 
            }
        }
        assertTrue(testMap);
    }
    
    private void mapBuilder()
    {
        test[0][0] = plainA;
        test[1][0] = plainB;
        test[2][0] = plainC;
        test[0][2] = new Plain();
        test[1][0] = new Plain();
        test[2][0] = new Plain();
        for(int i = 0; i < 3; i++){
            test[i][1] = new Ocean();
        }
    }
    
    /*private void mapViewer()
    {
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
    }*/
    
    /*@Test
    public void MapTestOceanPlainTownBase()
    {
        mapBuilder();
        map = new Maps(width,height,test);
        mapViewer();
    }*/
    
    
    private void buildingViewer(HashMap<Location, Case> hBuild)
    {
        System.out.println("Type et posisiton Batiment :");
        hBuild.entrySet().forEach((e) -> {
            System.out.println("X : " + e.getKey().getX() + 
                    " Y : " + e.getKey().getY() + 
                    " "+e.getValue().getBuilding());
        });
    }
    
    
    @Test
    public void TestSortieGetBuilding()
    {
        mapBuilder();
        map = new Maps(width,height, test);
        HashMap<Location, Case> cBuilding = new HashMap<>();
        cBuilding = map.getBuilding();
        buildingViewer(cBuilding);
    }
    /*
    @Test
    public void TestPositionUnits() throws FriendException
    {
        Location local;
        mapBuilder();
        map = new Maps(width,height, test);
        map.getCase(2, 1).setUnit(inf1);
        local = map.GetLocalUnit(inf1);
        System.out.println("Posisiton inf A :\nX : "+local.getX()+" Y : "+local.getY()+"\n");
    } */     
}