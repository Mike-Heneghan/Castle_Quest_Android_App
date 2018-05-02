package com.example.mike.fantasygame.DragonCastle.Characters.Heroes;

import com.example.mike.fantasygame.DragonCastle.Characters.Character;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters.Defence;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters.Knight;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters.Weapon;

import java.io.Serializable;
import java.util.ArrayList;

public class Hero extends Character implements Serializable {

    private ArrayList<Treasure> inventory;
    private String type;

    public Hero(String name, String type){
        super(name);
        this.type = type;
        this.inventory = new ArrayList<Treasure>();
        }
    public class Knight extends Hero{

        private Weapon weapon;
        private Defence defence;

        public Knight(String name, String type) {
            super(name, "Attacker");
            this.weapon = null;
            this.defence = null;
        }
        public int stab(){
            return 20;
        }

        //move2
        //For the knight the stab has 100% chance of hitting.
        public String signatureMove(Character characterToAttack){
            {characterToAttack.takeDamage(this.stab());}
            return this.getName() + " attacked " + characterToAttack.getName() + " successfully.";
        }

    }

    public void addToInventory(Treasure treasureItem){
        inventory.add(treasureItem);
    }

    public Treasure removeFromInventory(){
        Treasure itemToRemove = null;
        if(inventory.size() > 0){itemToRemove = inventory.remove(0);}
        return itemToRemove;
    }

    public ArrayList<Treasure> getInventory() {
        return inventory;
    }

    public int getTotalTreasureValue(){
        int total = 0;
        for(Treasure item : inventory){
            total += item.getTreasureValue();
        }
        return total;
    }

    public String getType() {
        return type;
    }

    public String standardMove(Character characterToAttack){
        return "";
    }
}
