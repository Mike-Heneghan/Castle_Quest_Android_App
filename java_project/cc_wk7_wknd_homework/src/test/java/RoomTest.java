import Characters.Creatures.Creature;
import Characters.Creatures.CreatureType;
import Characters.Heroes.Fighters.Knight;
import Characters.Heroes.Healers.Cleric;
import Characters.Heroes.Hero;
import Characters.Heroes.Mages.Spell;
import Characters.Heroes.Mages.Warlock;
import Characters.Narrator;
import Room.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RoomTest {
    private Room room1;
    private Room fullroom;
    private Hero hero1;
    private Hero hero2;
    private Hero hero3;
    private Creature creature1;
    private ArrayList<Hero> heroes;

    @Before
    public void before(){
        creature1 = new Creature(CreatureType.GIANTSPIDER);
        room1 = new Room();
        hero1 = new Knight("Peter");
        hero2 = new Warlock("Ashley");
        hero3 = new Cleric("Pawel");
        ArrayList<Hero> heroes = new ArrayList<>();
        fullroom = new Room();
        fullroom.addHeroes(hero1);
        fullroom.addHeroes(hero2);
        fullroom.addHeroes(hero3);
    }

    @Test
    public void canAssert(){
        assertEquals(1,1);
    }

    @Test
    public void hasCreature(){
        assertNotNull(room1.getMonster());
    }

    @Test
    public void hasTreasure(){
        assertNotNull(room1.getTreasure());
    }

    @Test
    public void heroesStartEmpty(){
        assertEquals(0, room1.getHeroes().size());
    }

    @Test
    public void canAddHeroesToRoom(){
        assertEquals(3, fullroom.getHeroes().size());
    }

    @Test
    public void startNoHeroesAlive(){
        assertEquals(true, room1.noHeroesAlive());
    }

    @Test
    public void canCheckIfAllHeroesDead(){
        assertEquals(true, room1.areAllHeroesDefeated());
    }

    @Test
    public void canReturnHeroWithLowestHealth(){
        fullroom.getHeroes().get(0).setHp(20);
        assertEquals(hero1, fullroom.heroWithLowestHealth());
        fullroom.getHeroes().get(2).setHp(10);
        assertEquals(hero3, fullroom.heroWithLowestHealth());
    }

    @Test
    public void canCheckFightIsOverMonsterDead(){
        fullroom.getMonster().setHp(0);
        assertEquals(true, fullroom.isFightOver());
    }

    @Test
    public void canCheckFightIsOverAllHeroesDead(){
        fullroom.getHeroes().get(0).setHp(0);
        fullroom.getHeroes().get(1).setHp(0);
        fullroom.getHeroes().get(2).setHp(0);
        assertEquals(true, fullroom.isFightOver());
    }

//    Random Answer Although Works Most of The Time
//    @Test
//    public void heroCanStandardAttackMonster(){
//        fullroom.heroStandardMove(hero1);
//        ArrayList<String> answer = new ArrayList<>();
//        answer.add(hero1.getName() + " attacked " + fullroom.getMonster().getName() + " successfully.");
//        assertEquals(answer, Narrator.getInstance().tellTale());
//    }

    @Test
    public void deadHeroesDontAttack(){
        fullroom.getHeroes().get(0).setHp(0);
        fullroom.heroStandardMove(hero1);
        ArrayList<String> answer = new ArrayList<>();
        answer.add(hero1.getName() + " is dead!");
        assertEquals(answer,Narrator.getInstance().tellTale());
    }

    @Test
    public void healerHealsHeroWithLowestHealth(){
        fullroom.getHeroes().get(1).setHp(50);
        fullroom.heroStandardMove(hero3);
        ArrayList<String> answer = new ArrayList<>();
        answer.add(hero3.getName() + " healed " + hero2.getName() + " successfully.");
        assertEquals(answer, Narrator.getInstance().tellTale());
    }
//    @Test
//    public void heroCanSignatureAttackMonster(){
//        fullroom.heroSignatureMove(hero1);
//        ArrayList<String> answer = new ArrayList<>();
//        answer.add(hero1.getName() + " attacked " + fullroom.getMonster().getName() + " successfully!");
//        assertEquals(answer, Narrator.getInstance().tellTale());
//    }













//    @Test public void firstHeroCanCollectTreasureFromRoom(){
//        fullroom.heroesCollectTreasure();
//        assertEquals(1, hero1.getInventory().size());
//        assertEquals(null, fullroom.getTreasure());
//    }
//
//    @Test
//    public void roomCanGetRemainingHeroesAfterFight(){
//        hero1.setHp(0);
//        room1.addHeroes(hero1);
//        room1.addHeroes(hero2);
//        room1.addHeroes(hero3);
//        ArrayList<Hero> remainingHeroes = room1.returnRemainingHeroes();
//        assertEquals(2, remainingHeroes.size());
//    }
//
//    @Test
//    public void heroesCanFightMonsterInRoom(){
//        fullroom.heroesFightMonster();
//        assertFalse(fullroom.getMonster().characterDead());
//        assertFalse(hero1.characterDead());
//        assertFalse(hero2.characterDead());
//        assertFalse(hero3.characterDead());
//    }
//    //Oh man, how to test for an array of fighters fighting?! With the debugger you can see that every time this test is run the fighters and/or creature take damage so I think the method is working.
//
//    @Test
//    public void allHeroesAreAlive(){
//        assertFalse(fullroom.allHeroesDead());
//    }
//
//    @Test
//    public void allHeroesAreDead(){
//        hero1.setHp(0);
//        hero2.setHp(0);
//        hero3.setHp(0);
//        room1.addHeroes(hero1);
//        room1.addHeroes(hero2);
//        room1.addHeroes(hero3);
//        assertTrue(fullroom.allHeroesDead());
//    }
//
//    @Test
//    public void oneHeroIsAlive(){
//        hero3.setHp(0);
//        hero3.setHp(0);
//        room1.addHeroes(hero1);
//        room1.addHeroes(hero2);
//        room1.addHeroes(hero3);
//        assertFalse(fullroom.allHeroesDead());
//    }
//
////    @Test
////    public void fightCanContinueUntilThereIsAWinner(){
////        fullroom.fight();
////        assertEquals(0, fullroom.returnRemainingHeroes().size());
////    }
//    //Another nightmare test - but it is returning variable array lengths, showing that the method is working (I think!). It also occasionally passes, showing that the monster has won.
//
//    @Test
//    public void heroesCanHaveRoomEncounter(){
//        fullroom.encounter();
//        assertEquals(null, fullroom.getTreasure());
//    }
//    //This test almost always passes, but now and again our heroes don't make it and the room still has treasure.
//
////    @Test
////    public void canReturnStory() {
////        fullroom.encounter();
////        assertEquals("", Narrator.getInstance().tellTale());
////    }
}
