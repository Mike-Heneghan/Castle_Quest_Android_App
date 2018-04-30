package com.example.mike.fantasygame.DragonCastleTests;

import DragonCastle.Characters.Creatures.Creature;
import DragonCastle.Characters.Creatures.CreatureType;
import DragonCastle.Characters.Heroes.Fighters.Barbarian;
import DragonCastle.Characters.Heroes.Fighters.Dwarf;
import DragonCastle.Characters.Heroes.Fighters.Knight;
import DragonCastle.Characters.Heroes.Healers.Cleric;
import DragonCastle.Characters.Heroes.Hero;
import DragonCastle.Characters.Heroes.Mages.Spell;
import DragonCastle.Characters.Heroes.Mages.Warlock;
import org.junit.Before;
import org.junit.Test;

import DragonCastle.Game.Game;
import DragonCastle.Characters.Character;
import DragonCastle.Characters.*;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private Game game1;
    private Game game2;
    private Game game3;
    private Hero knight1;
    private Hero dwarf1;
    private Hero barbarian1;
    private Hero cleric1;
    private Hero warlock1;
    private Creature dragon1;

    @Before
    public void before(){
        game1 =  new Game("M&C's Castle of Madness",5);
        game2 = new Game("Second Castle", 3);
        game3 = new Game("Third one", 10);
        knight1 = new Knight("Mike");
        dwarf1 = new Dwarf("Simon");
        barbarian1 = new Barbarian("Tom");
        cleric1 = new Cleric("Claire");
        dragon1 = new Creature(CreatureType.DRAGON);
        warlock1 = new Warlock("Dave");

    }

    @Test
    public void canAssert(){
        assertEquals(1,1);
    }

    @Test
    public void hasName(){
        assertEquals("M&C's Castle of Madness", game1.getName());
    }

    @Test
    public void hasRandomRooms(){
        assertEquals(5, game1.getNewRooms().size());
    }

    @Test
    public void canAddNewKnight(){
        game1.addKnight("Mike");
        assertEquals(1, game1.getHeroes().size());
        assertEquals(knight1.getName(), game1.getHeroes().get(0).getName());
    }

    @Test
    public void canAddNewDwarf(){
        game1.addDwarf("Simon");
        assertEquals(1, game1.getHeroes().size());
        assertEquals(dwarf1.getName(), game1.getHeroes().get(0).getName());
    }

    @Test
    public void canAddNewBarbarian(){
        game1.addBarbarian("Tom");
        assertEquals(1, game1.getHeroes().size());
        assertEquals(barbarian1.getName(), game1.getHeroes().get(0).getName());
    }

    @Test
    public void canAddNewCleric(){
        game1.addCleric("Claire");
        assertEquals(1, game1.getHeroes().size());
        assertEquals(cleric1.getName(), game1.getHeroes().get(0).getName());
    }

    @Test
    public void canAddNewWarlock(){
        game1.addWarlock("Dave");
        assertEquals(1, game1.getHeroes().size());
        assertEquals(warlock1.getName(), game1.getHeroes().get(0).getName());
    }

    @Test
    public void canHandCharacterToFirstRoom(){
        game1.addKnight("Mike");
        Hero knightAdded = game1.getHeroes().get(0);
        assertEquals(1, game1.getHeroes().size());
        game1.addHeroesToFirstRoom();
        assertEquals(0, game1.getHeroes().size());
        assertEquals(1, game1.getNewRooms().get(0).getHeroes().size());
        assertEquals(knightAdded, game1.getNewRooms().get(0).getHeroes().get(0));
    }

    @Test
    public void canAddMultipleCharactersToFirstRoom(){
        game1.addKnight("Mike");
        game1.addBarbarian("Mariana");
        game1.addDwarf("Simon");
        Hero knightAdded = game1.getHeroes().get(0);
        Hero barbarianAdded = game1.getHeroes().get(1);
        Hero dwarfAdded = game1.getHeroes().get(2);
        assertEquals(3, game1.getHeroes().size());
        game1.addHeroesToFirstRoom();
        assertEquals(0, game1.getHeroes().size());
        assertEquals(3, game1.getNewRooms().get(0).getHeroes().size());
        assertEquals(knightAdded, game1.getNewRooms().get(0).getHeroes().get(0));
        assertEquals(barbarianAdded, game1.getNewRooms().get(0).getHeroes().get(1));
        assertEquals(dwarfAdded, game1.getNewRooms().get(0).getHeroes().get(2));
    }

    @Test
    public void gameCanStartWithSetRooms3(){
        assertEquals(3,game2.getNewRooms().size());
    }

    @Test
    public void gameCanStartWithSetRooms10(){
        assertEquals(10,game3.getNewRooms().size());
    }

    @Test
    public void canMoveToNextRooms() {
        game1.addKnight("Mike");
        game1.addBarbarian("Mariana");
        game1.addDwarf("Simon");
        game1.addHeroesToFirstRoom();
        assertEquals(3, game1.getNewRooms().get(0).getHeroes().size());
        game1.moveToNextRoom();
        assertEquals(1, game1.getCompletedRooms().size());
        assertEquals(4, game1.getNewRooms().size());
        assertEquals(3, game1.getNewRooms().get(0).getHeroes().size());
    }

}

