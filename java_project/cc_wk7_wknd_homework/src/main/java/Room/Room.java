package Room;

import Characters.Character;
import Characters.Creatures.Creature;
import Characters.Creatures.CreatureType;
import Characters.Heroes.Healers.Cleric;
import Characters.Heroes.Hero;
import Characters.Heroes.Treasure;
import Characters.Narrator;

import java.util.ArrayList;

public class Room {

    private Character monster;
    private Treasure treasure;
    private ArrayList<Hero> heroes;


    public Room(){
        this.monster = new Creature(CreatureType.getRandomCreature());
        this.treasure = Treasure.getRandomTreasure();
        this.heroes = new ArrayList<>();
    }

    public Character getMonster() {
        return monster;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public Boolean noHeroesAlive(){
        return heroes.isEmpty();
    }

    public void addHeroes(Hero hero){
        heroes.add(hero);
    }

    public void addHeroesFromHallway(ArrayList<Hero> heroesFromHallway){
        heroes = heroesFromHallway;
    }


    public boolean isFightOver(){
        if (monster.getHp()<= 0 || areAllHeroesDefeated()) {
            return true;
        }
        return false;
    }

    public boolean areAllHeroesDefeated() {
        int aliveCounter = 0;
        for (Hero h : heroes) {
            if (h.getHp() > 0) {aliveCounter++;}
        }
        if (aliveCounter == 0) { return true; }

        else return false;
    }

    public void heroStandardMove(Hero hero){
        if (hero.getHp() > 0){
            if (hero.getType() == "Healer"){
                Narrator.getInstance().addStoryLine(hero.standardMove(heroWithLowestHealth()));
            }
            else Narrator.getInstance().addStoryLine(hero.standardMove(monster));
        }
        else Narrator.getInstance().addStoryLine(hero.getName() + " is dead!");

    }

    public void heroSignatureMove(Hero hero){
        if (hero.getHp() > 0){
            if (hero.getType() == "Healer"){
                Narrator.getInstance().addStoryLine(hero.signatureMove(heroWithLowestHealth()));
            }
            Narrator.getInstance().addStoryLine(hero.signatureMove(monster));}
        else Narrator.getInstance().addStoryLine(hero.getName() + " is dead!");
        }

    public Hero heroWithLowestHealth(){
        Hero heroToHeal = null;
        for (Hero h: heroes) {
            if (heroToHeal == null){
                heroToHeal = h;
            }
            else {
                if (heroToHeal.getHp() > h.getHp()){
                    heroToHeal = h;
                }
            }
        }
        return heroToHeal;
    }



//    //For encounter- collectTreasure to be used as a conditional if any heroes remain alive.
//    public void heroesCollectTreasure(){
//        Hero hero = heroes.get(0);
//        hero.addToInventory(this.treasure);
//        this.treasure = null;
//    }
//
//    //For encounter - returning our heroes at the end of a fight if any remain alive afterwards.
//    public ArrayList<Hero> returnRemainingHeroes(){
//        ArrayList<Hero> remainingHeroes = new ArrayList<>();
//        for (Hero hero : heroes){
//            if(!hero.characterDead()){
//                remainingHeroes.add(hero);
//            }
//        }
//        for (Hero h: remainingHeroes) {
//            Narrator.getInstance().addStoryLine(h.getName() + " survived the encounter" + " Treasure: " + h.getTotalTreasureValue() + " Health Points: " + h.getHp());
//        }
//        return remainingHeroes;
//    }
//
//    //For encounter. The heroes will all have a go at monster and monster will have a go at heroes.
//    public void heroesFightMonster(){
//        for(Hero hero : heroes){
//            if (hero.getType() == "Healer"){
//                Narrator.getInstance().addStoryLine(hero.standardMove(heroes.get(0)));
//                Narrator.getInstance().addStoryLine(monster.standardMove(hero)); }
//            else {Narrator.getInstance().addStoryLine(hero.standardMove(monster));
//            Narrator.getInstance().addStoryLine(monster.standardMove(hero));}
//        }
//
//    }
//
//    //For encounter. A boolean to check is there are any heroes left alive after the fight round. Can probably remove this and use remainingHeroes.isempty() as a conditional.
//    public boolean allHeroesDead(){
//        return returnRemainingHeroes().isEmpty();
//    }
//
//    //For encounter. A loop to have heroes and creatures fight until there is a winner.
//    public void fight(){
//        while(!monster.characterDead() && !allHeroesDead()){
//            heroesFightMonster();
//        }
//
//    }
//
//    public void encounter(){
//        fight();
//        if(!returnRemainingHeroes().isEmpty()){
//            heroesCollectTreasure();
//
//        }
//    }
}
