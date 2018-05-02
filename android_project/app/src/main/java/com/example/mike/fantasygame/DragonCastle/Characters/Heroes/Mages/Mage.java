package com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Mages;

import com.example.mike.fantasygame.DragonCastle.Characters.Creatures.Creature;
import com.example.mike.fantasygame.DragonCastle.Characters.Creatures.CreatureType;
import com.example.mike.fantasygame.DragonCastle.Characters.Character;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Hero;

import java.io.Serializable;

public class Mage extends Hero implements Serializable {

    private Spell spell;
    private Creature creature;

    public Mage(String name){
        super(name, "Attacker");
        this.spell = Spell.getRandomSpell();
        this.creature = new Creature(CreatureType.getRandomCreature());
        //Massive problem still with this random element for newing up objects. Need to fix.

    }

    public Creature getCreature(){
        return this.creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    //move 1. This is the move to use the spell that the Mage has assigned to them.
    public String standardMove(Character characterToAttack){
        if(shouldDoMove(this.spell.getChanceValue())){
            characterToAttack.takeDamage(this.spell.getDamageValue());
            return (this.getName() + " attacked " + characterToAttack.getName() + " successfully.");
        }
        return this.getName() + " missed!";
    }


}
