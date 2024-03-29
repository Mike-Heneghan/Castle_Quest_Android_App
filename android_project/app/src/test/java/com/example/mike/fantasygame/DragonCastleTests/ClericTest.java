package com.example.mike.fantasygame.DragonCastleTests;


import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Healers.Cleric;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Healers.HealingTool;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Treasure;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class ClericTest {


    private Cleric cleric;
    private Cleric cleric2;
    private Cleric cleric3;
    private HealingTool clericHealingTool;

    @Before
    public void setup() {
        cleric = new Cleric("Tony");
        cleric2 = new Cleric("random");
        clericHealingTool = cleric.getHealingTool();
        cleric3 = new Cleric("Brian");
//        Attempt to save the randomised healingTool of cleric in a different "parking spot" to cleric itself by creating a new cleric who has a set value."
        cleric3.setHealingTool(clericHealingTool);
    }

    @Test
    public void canGetName() {
        assertEquals("Tony", cleric.getName());
    }

    @Test
    public void canGetHealth(){
        assertEquals(100, cleric.getHp());
    }

    @Test
    public void canSetHealth(){
        cleric.setHp(150);
        assertEquals(150, cleric.getHp());
    }

    @Test
    public void canSetHealingTool(){
        cleric.setHealingTool(HealingTool.BITTEROOT);
        assertEquals(HealingTool.BITTEROOT, cleric.getHealingTool());
    }

    @Test
    public void isCleric3ItsOwnParkingSpot(){
        assertEquals(cleric.getHealingTool(),cleric3.getHealingTool());
        cleric.getHealingTool();
        cleric.standardMove(cleric2);
        cleric.getHealingTool().getChanceValue();
        cleric.getHealingTool().getHealingValue();
        assertEquals(cleric.getHealingTool(), cleric3.getHealingTool());
    }

//    @Test
//    public void canGetHealingTool(){
//        assertEquals(HealingTool.AGOODSNOOZE, cleric.getHealingTool());
//    }


    @Test
    public void canGetHealingToolValue(){
        assertEquals(clericHealingTool.getHealingValue(), cleric.getHealingTool().getHealingValue());
    }

    @Test
    public void canGetHealingToolChanceValue(){
        assertEquals(clericHealingTool.getChanceValue(), cleric.getHealingTool().getChanceValue());
    }

//    @Test
//    public void canRollDice(){
//        assertEquals(2, cleric.diceRoll());
//    }
    //This test is working for the dice roll, but doesn't always pass.

    @Test
    public void canTakeDamage(){
        cleric.takeDamage(20);
        assertEquals(80, cleric.getHp());
    }

    @Test
    public void canBeHealed(){
        cleric.beHealed(10);
        assertEquals(110, cleric.getHp());
    }

    @Test
    public void canAddToInventory(){
        cleric.addToInventory(Treasure.DIAMOND);
        assertEquals(1, cleric.getInventory().size());
    }

    @Test
    public void canGetTotalTreasureValue(){
        cleric.addToInventory(Treasure.DIAMOND);
        cleric.addToInventory(Treasure.FAKEMOUSTACHE);
        assertEquals(51, cleric.getTotalTreasureValue());
    }



    @Test
    public void canGetHealingTool(){
        assertEquals(clericHealingTool, cleric.getHealingTool());
    }
// So this test is failing but it's defo bringing back a random HealingTool object. Each test has returned a different int - not the same random one, argh. Bug to fix.

    @Test
    public void signatureReturnsString(){
        assertEquals("Tony missed Brian!", cleric.signatureMove(cleric3));
    }



}

