package com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters;

import com.example.mike.fantasygame.DragonCastle.Characters.Character;

import java.io.Serializable;

public class Barbarian extends Fighter implements Serializable {
    private int rageChance;

    public Barbarian(String name){
        super(name);
        this.imageId = 3;
        weapon = Weapon.CLUB;
        defence = Defence.ARMGUARDS;
        rageChance = 6;
    }

    public String signatureMove(Character characterToAttack) {
        if (hp < 20) {
            characterToAttack.setHp(0);
            this.setHp(0);
            return this.getName() + " attacked " + characterToAttack.getName() + " successfully.";
        } else if (shouldDoMove(rageChance)) {
            characterToAttack.setHp(0);
            this.setHp(0);
            return this.getName() + " attacked " + characterToAttack.getName() + " successfully.";
        }
        return this.getName() + " missed " + characterToAttack.getName() + "!";
    }
}
