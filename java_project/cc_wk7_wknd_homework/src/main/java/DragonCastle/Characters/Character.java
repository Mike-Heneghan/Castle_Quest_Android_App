package DragonCastle.Characters;

import java.util.Random;

public abstract class Character {

    protected String name;
    protected int hp;
    protected int imageId;

    public Character(String name){
        this.name = name;
        this.imageId = 0;
        this.hp = 100;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public int diceRoll() {
        Random rand = new Random();
        return 2 + rand.nextInt((12 - 2) + 1);

    }

    public int getRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public void takeDamage(int damage){
        hp -= damage;
    }

    public void beHealed(int health){
        hp += health;
    }

    public boolean shouldDoMove(int chanceValue){
        if(diceRoll() <= chanceValue){return true;}
        else{return false;}
    }

    //move1
    public String standardMove(Character characterToAttack){
    return "";
    }

    //move2
    public String signatureMove(Character characterToAttack){
        return "";
    }

    public boolean characterDead(){
        if(this.hp <= 0){return true;}
        else
        {return false;}
    }


}




