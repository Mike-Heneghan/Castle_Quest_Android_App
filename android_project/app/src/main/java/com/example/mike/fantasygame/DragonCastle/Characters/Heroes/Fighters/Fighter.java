package com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters;

import com.example.mike.fantasygame.DragonCastle.Characters.Character;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Hero;

import java.io.Serializable;

public class Fighter extends Hero implements Serializable {

    protected Weapon weapon;
    protected Defence defence;

    public Fighter(String name){
        super(name, "Attacker");
        this.weapon = null;
        this.defence = null;

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Defence getDefence() {
        return defence;
    }

    public void setDefence(Defence defence) {
        this.defence = defence;
    }

    public void takeDamage(int damage){
        this.hp -= (damage * defence.getDefenceValue());
    }

    public int wield(Weapon weapon){
        return weapon.damageValue;
    }

    //move1
    public String standardMove(Character characterToAttack){
        if(shouldDoMove(this.weapon.chanceValue))
        {characterToAttack.takeDamage(this.wield(weapon));
        return (this.getName() + " attacked " + characterToAttack.getName() + " successfully.");
        }
        return this.getName() + " missed " + characterToAttack.getName() + "!";
    }
}
