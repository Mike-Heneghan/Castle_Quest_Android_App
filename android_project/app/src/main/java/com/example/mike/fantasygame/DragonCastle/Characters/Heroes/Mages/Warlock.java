package com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Mages;

import com.example.mike.fantasygame.DragonCastle.Characters.Character;
import com.example.mike.fantasygame.DragonCastle.Characters.Creatures.Creature;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Treasure;

import java.io.Serializable;
import java.util.ArrayList;

public class Warlock extends Mage implements Serializable {

    public Warlock(String name){
        super(name);
        this.imageId = 4;
    }

    public String signatureMove(Character characterToAttack){
        if (shouldDoMove(getCreature().getMv2ChanceValue())) {
            characterToAttack.takeDamage(getCreature().getMv2DamageValue());
            return this.getName() + " attacked " + characterToAttack.getName() + " successfully.";
        }
        return this.getName() + " missed " +characterToAttack.getName() + "!";
    }

}
