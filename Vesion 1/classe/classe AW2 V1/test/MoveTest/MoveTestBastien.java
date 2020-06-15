/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;


import ClasseAdvencedWars.Case.Building.Base;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Case.Ocean;
import ClasseAdvencedWars.Case.Plain;
import ClasseAdvencedWars.Location;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.Team;

import ClasseAdvencedWars.units.Tank;
import Exception.FriendException;
import Exception.MoveException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ordinateur
 */
public class MoveTestBastien 
{
    private Team TeamTest;
    
    private Tank tank;
    
    
    private Case[][] Lacarte;
    
    private Maps Lamap;
    
    private final int width = 3;
    private final int height = 3;
    

    
    public MoveTestBastien(){}
    
    @Before
    public void startup() throws FriendException
    {
        TeamTest = new Team("B2-2");
        Base base = new Base(TeamTest);
        tank = new Tank(TeamTest);
        
        Lacarte = new Case[width][height];
        
        Lacarte[0][0] = new Plain();
        Lacarte[1][0] = new Plain();
        Lacarte[0][1] = new Ocean();
        Lacarte[1][1] = new Plain(base);
        Lacarte[0][2] = new Plain();
        Lacarte[1][2] = new Plain();
        Lacarte[2][2] = new Ocean();
        Lacarte[2][0] = new Plain(base);
        Lacarte[2][1] = new Ocean();
        
        Lacarte[0][0].setUnit(tank);
        
        Lamap = new Maps(3, 3, Lacarte);
    }
    
    @After
    public void TearDown()
    {
        TeamTest = null;
        tank = null;
        Lacarte = null;
        Lamap = null;
    }
     
    
    @Test
    public void TestMoveUnit() throws MoveException, FriendException
    {
        tank.moveStep(1, 0, Lamap);
        tank.moveStep(0, 1, Lamap);
        Location local = Lamap.GetLocal(tank);
        assertEquals(local.getX(),1);
        assertEquals(local.getY(),1);   
    }
    
    @Test
    public void TestLongMoveUnit() throws MoveException, FriendException
    {
        tank.moveStep(1, 0, Lamap);
        tank.moveStep(0, 1, Lamap);
        tank.moveStep(0, 1, Lamap);
        Location local = Lamap.GetLocal(tank);
        assertEquals(local.getX(),1);
        assertEquals(local.getY(),2);    
    }
    
    @Test
    public void TestLongMoveUnitWithOtherMethode() throws MoveException, FriendException
    {
        Lamap.getCase(0, 0).getUnit().moveStep(1, 0, Lamap);
        Lamap.getCase(1, 0).getUnit().moveStep(0, 1, Lamap);
        Lamap.getCase(1, 1).getUnit().moveStep(0, 1, Lamap);
        Location local = Lamap.GetLocal(tank);
        assertEquals(local.getX(),1);
        assertEquals(local.getY(),2);    
    }
    
    @Test (expected=MoveException.class)
    public void TestMoveUnitOcean() throws MoveException, FriendException
    {
        tank.moveStep(0, 1, Lamap); 
    }
    
    @Test (expected=MoveException.class)
    public void TestMoveUnitTooLong() throws MoveException, FriendException
    {   
        tank.moveStep(0, 3, Lamap);   
    }
    
    @Test (expected=MoveException.class)
    public void TestMoveUnitHorsMap() throws MoveException, FriendException
    {
        tank.moveStep(0, 1, Lamap);
        tank.moveStep(-1, 0, Lamap);    
    }
    
    @Test (expected=MoveException.class)
    public void TestMoveUnitNull() throws MoveException, FriendException
    {
        tank.moveStep(0, 0, Lamap);
    }
    
    
    
}
