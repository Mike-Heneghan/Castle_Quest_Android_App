package DragonCastleTests;

import DragonCastle.Characters.Creatures.Creature;
import DragonCastle.Characters.Creatures.CreatureType;
import DragonCastle.Characters.Heroes.Fighters.Defence;
import DragonCastle.Characters.Heroes.Fighters.Knight;
import DragonCastle.Characters.Heroes.Fighters.Weapon;
import DragonCastle.Characters.Heroes.Treasure;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class KnightTest {
    private Knight knight1;
    private Weapon sword1;
    private Defence defence1;
    private Creature dragon1;
    private Treasure treasure1;

    @Before
    public void before(){
        knight1 = new Knight("Mike");
        sword1 = Weapon.SWORD;
        defence1 = Defence.SHIELD;
        dragon1 = new Creature(CreatureType.DRAGON);
        treasure1 = Treasure.DIAMOND;
    }

    @Test
    public void canAssert() {
        assertEquals(1, 1);
    }

    @Test
    public void hasName(){
        assertEquals("Mike", knight1.getName());
    }

    @Test
    public void hasSword(){
        assertEquals(sword1, knight1.getWeapon());
    }

    @Test
    public void hasShield(){
        assertEquals(defence1, knight1.getDefence());
    }

    @Test
    public void shieldReducesDamageByHalf(){
        knight1.takeDamage(50);
        assertEquals(75, knight1.getHp());
    }

    @Test
    public void canUseSignatureMove(){
        knight1.signatureMove(dragon1);
        assertEquals(130, dragon1.getHp());
    }

    @Test
    public void canReturnSwordChance(){
        assertEquals(10, knight1.getWeapon().getChanceValue());
    }

    @Test
    public void canGetTreasure(){
        knight1.addToInventory(treasure1);
        assertEquals(Treasure.DIAMOND, knight1.getInventory().get(0));
    }

    @Test
    public void canGetTreasureValue(){
        knight1.addToInventory(treasure1);
        assertEquals(50, knight1.getTotalTreasureValue());

    }

    @Test
    public void signatureReturnsString(){
        assertEquals("Mike attacked Dragony successfully.",knight1.signatureMove(dragon1));
    }
}
