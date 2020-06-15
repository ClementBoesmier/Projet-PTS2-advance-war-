/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testMapsBD;

import ClasseAdvencedWars.Case.Building.Base;
import ClasseAdvencedWars.Case.Building.Town;
import ClasseAdvencedWars.Case.Ocean;
import ClasseAdvencedWars.Case.Plain;
import ClasseAdvencedWars.Game;
import ClasseAdvencedWars.units.Infantry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author clement
 */
public class TestBDMapsClement {
    
    private Game gParty;
    
    public TestBDMapsClement(){}
    
    @Before
    public void startup(){
        gParty = new Game("michel","patrick");
    }
    
    @After
    public void teardown(){
        gParty = null;
    }
    
    
        private void mapViewer(){
        System.out.println("\nLa carte :\n");
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
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
    public void test(){
        mapViewer();
    }
    
}
