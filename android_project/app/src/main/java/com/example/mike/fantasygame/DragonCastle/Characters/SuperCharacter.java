//package com.example.mike.fantasygame.DragonCastle.Characters;
//
//import com.example.mike.fantasygame.DragonCastle.Characters.Creatures.Creature;
//import com.example.mike.fantasygame.DragonCastle.Characters.Creatures.CreatureType;
//import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters.Defence;
//import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters.Weapon;
//import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Healers.HealingTool;
//import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Mages.Spell;
//import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Treasure;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Random;
//
//public class SuperCharacter  implements Serializable{
//
////    Character
//    protected String name;
//    protected int hp;
//    protected int imageId;
//
//
//
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name){
//        this.name = name;
//    }
//
//    public int getHp() {
//        return this.hp;
//    }
//
//    public void setHp(int hp) {
//        this.hp = hp;
//    }
//
//
//    public int diceRoll() {
//        Random rand = new Random();
//        return 2 + rand.nextInt((12 - 2) + 1);
//
//    }
//
//    public int getRandomNumber(int max) {
//        Random rand = new Random();
//        return rand.nextInt(max);
//    }
//
//    public void takeDamage(int damage){
//        hp -= damage;
//    }
//
//    public void beHealed(int health){
//        hp += health;
//    }
//
//    public boolean shouldDoMove(int chanceValue){
//        if(diceRoll() <= chanceValue){return true;}
//        else{return false;}
//    }
//
//    public boolean characterDead(){
//        if(this.hp <= 0){return true;}
//        else
//        {return false;}
//    }
//
////    Creature
//    private CreatureType type;
//    private int mv1DamageValue;
//    private int mv1ChanceValue;
//    private int mv2DamageValue;
//    private int mv2ChanceValue;
//
//    public SuperCharacter(CreatureType type){
//        this.name = type.getName();
//        this.type = type;
//        this.hp = type.getHp();
//        this.mv1DamageValue = type.getMv1DamageValue();
//        this.mv1ChanceValue = type.getMv1ChanceValue();
//        this.mv2DamageValue = type.getMv2DamageValue();
//        this.mv2ChanceValue = type.getMv2ChanceValue();
//        this.imageId = type.getImageId();
//    }
//
//    public CreatureType getType() {
//        return type;
//    }
//
//
//    public int getMv1DamageValue() {
//        return mv1DamageValue;
//    }
//
//    public int getMv1ChanceValue() {
//        return mv1ChanceValue;
//    }
//
//    public int getMv2DamageValue() {
//        return mv2DamageValue;
//    }
//
//    public int getMv2ChanceValue() {
//        return mv2ChanceValue;
//    }
//
//    //move1. This move uses the first move in the creature's enum.
//    public String standardMove(Character characterToAttack){
//        if(shouldDoMove(this.mv1ChanceValue))
//        {characterToAttack.takeDamage(this.mv1DamageValue);
//            return this.getName() + " attacked " + characterToAttack.getName() + " successfully.";
//        }
//        return this.getName() + " missed " + characterToAttack.getName() + "!";
//    }
//
//    //move2. This move uses the second move in the creature's enum.
//    public String signatureMove(Character characterToAttack){
//        if(shouldDoMove(this.mv2ChanceValue)){characterToAttack.takeDamage(this.mv2DamageValue);
//            return this.getName() + " attacked " + characterToAttack.getName() + " successfully.";}
//        return this.getName() + " missed " + characterToAttack.getName() + "!";
//    }
//
//
//    // Hero
//    private ArrayList<Treasure> inventory;
//    private String typeHero;
//
//    public SuperCharacter(String name, String typeHero){
//        this.name = name;
//        this.typeHero = typeHero;
//        this.inventory = new ArrayList<Treasure>();
//    }
//
//    public void addToInventory(Treasure treasureItem){
//        inventory.add(treasureItem);
//    }
//
//    public Treasure removeFromInventory(){
//        Treasure itemToRemove = null;
//        if(inventory.size() > 0){itemToRemove = inventory.remove(0);}
//        return itemToRemove;
//    }
//
//    public ArrayList<Treasure> getInventory() {
//        return inventory;
//    }
//
//    public int getTotalTreasureValue(){
//        int total = 0;
//        for(Treasure item : inventory){
//            total += item.getTreasureValue();
//        }
//        return total;
//    }
//
//    public String getTypeHero() {
//        return typeHero;
//    }
//
//
////   Fighter
//    protected Weapon weapon;
//    protected Defence defence;
//
////   Knight
//
//    public SuperCharacter(String name){
//        this.name = name;
//        this.imageId = 0;
//        this.hp = 100;
//        this.name = name;
//        this.imageId = 1;
//        this.weapon = Weapon.SWORD;
//        this.defence = Defence.SHIELD;
//    }
//
//    public int stab(){
//        return 20;
//    }
//
//    //move2
//    //For the knight the stab has 100% chance of hitting.
//    public String signatureMove(Character characterToAttack){
//        {characterToAttack.takeDamage(this.stab());}
//        return this.getName() + " attacked " + characterToAttack.getName() + " successfully.";
//    }
////    Dwarf
//
////    Barbarian
//
//
////    Mage
//    private Spell spell;
//    private Creature creature;
//
////    Warlock
//
//
////    Healer
//    private HealingTool healingTool;
////    Cleric
//
//}
