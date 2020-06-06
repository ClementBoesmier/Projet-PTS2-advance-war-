/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseAdvencedWars.Case;

import ClasseAdvencedWars.Case.Building.Building;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.units.Tank;
import ClasseAdvencedWars.units.Units;
import Exception.FriendException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author clement
 */
public class CaseTest {
    Tank tank1;
    Tank tank2;
    
    
    Plain battleField;
    
    Team teamB;
    Team teamR;
    
    public CaseTest() {
    }
    
    @Before
    public void setup(){
        teamB = new Team("patrick");
        teamR = new Team("michel");
        
        tank1 = new Tank(teamB);
        tank2 = new Tank(teamR);
        
        battleField = new Plain();
    }
    
    @After
    public void TearDown(){
        teamB = null;
        teamR = null;
        
        tank1 = null;
        tank2 = null;
        
        battleField = null;
    }
    @Test
    public void AttackEgaliterTestTank() throws FriendException{
        battleField.setUnit(tank1);
        battleField.setUnit(tank2);
        assert(battleField.getUnit() == null);
    }
 //   @Test
 //   public void setUnitTest() throws FriendException{
 //       battleField.setUnit(tank1);
 //       assert(battleField.getUnit().equals(tank1));
 //   }

}
