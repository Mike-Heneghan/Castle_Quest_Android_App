package DragonCastle.Characters.Creatures;

import java.util.Random;

public enum CreatureType {

    TROLL("Trolly", 100, 30, 8, 90, 2, 6 ),
    DRAGON("Dragony", 150, 40, 6, 95, 2, 7),
    GIANTSPIDER("Spidery", 100, 25, 9, 80, 3, 8),
    EX("The Dreaded Ex", 150, 20, 6, 60, 12, 9);

    public final String name;
    public final int hp;
    public final int mv1DamageValue;
    public final int mv1ChanceValue;
    public final int mv2DamageValue;
    public final int mv2ChanceValue;
    public final int imageId;
    private static final CreatureType[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();


    CreatureType(String name, int hp, int mv1DamageValue, int mv1ChanceValue, int mv2DamageValue, int mv2ChanceValue, int imageId) {
        this.name = name;
        this.hp = hp;
        this.mv1DamageValue = mv1DamageValue;
        this.mv1ChanceValue = mv1ChanceValue;
        this.mv2DamageValue = mv2DamageValue;
        this.mv2ChanceValue = mv2ChanceValue;
        this.imageId = imageId;
    }


    public int getMv1ChanceValue() {
        return mv1ChanceValue;
    }

    public int getMv1DamageValue() {
        return mv1DamageValue;
    }

    public int getMv2ChanceValue() {
        return mv2ChanceValue;
    }

    public int getMv2DamageValue() {
        return mv2DamageValue;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public static CreatureType getRandomCreature() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }

}
