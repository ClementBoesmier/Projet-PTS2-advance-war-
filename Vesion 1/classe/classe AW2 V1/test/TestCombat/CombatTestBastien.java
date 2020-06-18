/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCombat;

import ClasseAdvencedWars.Case.Plain;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.units.Infantry;
import ClasseAdvencedWars.units.RocketLauncher;
import ClasseAdvencedWars.units.Tank;
import Exception.FriendException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ordinateur
 */
public class CombatTestBastien 
{
    private Tank tankB;
    private Tank tankR;
    private Infantry infantryB;
    private Infantry infantryR;
    private RocketLauncher rocketLauncherB;
    private RocketLauncher rocketLauncherR;
    private Plain TestFight;
    private Team TeamBlue;
    private Team TeamRed;
    
    public CombatTestBastien() 
    {}
    
    @Before
    public void setup()
    {
        TeamBlue = new Team("Team1");
        TeamRed = new Team("Team2");
        
        tankB = new Tank(TeamBlue);
        tankR = new Tank(TeamRed);
        infantryB = new Infantry(TeamBlue);
        infantryR = new Infantry(TeamRed);
        rocketLauncherB = new RocketLauncher(TeamBlue);
        rocketLauncherR = new RocketLauncher(TeamRed);
        TestFight = new Plain();
        


    }
    
    @After
    public void TearDown(){
        TeamBlue = null;
        TeamRed = null;
        
        tankB = null;
        tankR = null;
        infantryB = null;
        infantryR = null;
        rocketLauncherB = null;
        rocketLauncherR =null;
        TestFight = null;
    }
    
    @Test
    public void TestFightInfantryVSInfantry() throws FriendException
    {
        TestFight.setUnit(infantryB);
        TestFight.setUnit(infantryR);
        assertEquals(null, TestFight.getUnit());
    } 
    
    @Test
    public void TestFightRocketLauncherVSRocketLauncher() throws FriendException
    {
        TestFight.setUnit(rocketLauncherB);
        TestFight.setUnit(rocketLauncherR);
        assertEquals(null, TestFight.getUnit());
    } 
    
    @Test
    public void TestFightTankVSTank() throws FriendException
    {
        TestFight.setUnit(tankB);
        TestFight.setUnit(tankR);
        assertEquals(null, TestFight.getUnit());
    }
    
    @Test
    public void TestFightUnitVSNothing() throws FriendException{
        TestFight.setUnit(null);
        TestFight.setUnit(infantryR);
        assertEquals(TestFight.getUnit(),infantryR);
        TestFight.setUnit(null);
        assertEquals(TestFight.getUnit(),null);        
    }
    
    @Test
    public void TestSetInfantry() throws FriendException
    {
        TestFight.setUnit(infantryB);
        assertEquals(TestFight.getUnit(),infantryB);
    } 
    
    @Test
    public void TestSetRocketLauncher() throws FriendException
    {
        TestFight.setUnit(rocketLauncherB);
        assertEquals(TestFight.getUnit(),rocketLauncherB);
    }
    
    @Test
    public void TestSetTank() throws FriendException
    {
        TestFight.setUnit(tankB);
        assertEquals(TestFight.getUnit(), tankB);
    }
    
    @Test
    public void TestFightRocketLauncherVSTank() throws FriendException
    {
        TestFight.setUnit(tankB);
        TestFight.setUnit(rocketLauncherR);
        assertEquals(rocketLauncherR, TestFight.getUnit());
        TestFight.setUnit(tankB);
        assertEquals(rocketLauncherR, TestFight.getUnit());
    }
    
    @Test
    public void TestFightTankVSInfantry() throws FriendException
    {
        TestFight.setUnit(infantryB);
        TestFight.setUnit(tankR);
        assertEquals(tankR, TestFight.getUnit());
        TestFight.setUnit(infantryB);
        assertEquals(tankR, TestFight.getUnit());
    }
    
    @Test
    public void TestFightRocketLauncherVSInfantry() throws FriendException
    {
        TestFight.setUnit(rocketLauncherB);
        TestFight.setUnit(infantryR);
        assertEquals(infantryR, TestFight.getUnit());
        TestFight.setUnit(rocketLauncherB);
        assertEquals(infantryR, TestFight.getUnit());
    }
    
    @Test (expected=FriendException.class)
    public void TestFightUnitSameTeam() throws FriendException{
        TestFight.setUnit(infantryB);
        TestFight.setUnit(tankB);
    }
    
    
}
