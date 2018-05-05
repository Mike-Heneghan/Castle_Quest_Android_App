package com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Healers;

import com.example.mike.fantasygame.DragonCastle.Characters.Character;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Hero;

import java.io.Serializable;

public abstract class Healer extends Hero implements Serializable {

    private HealingTool healingTool;

    public Healer(String name) {
        super(name, "Healer");
        this.healingTool = HealingTool.getRandomHealingTool();
    }

    public HealingTool getHealingTool() {
        return healingTool;
    }

    public void setHealingTool(HealingTool healingTool) {
        this.healingTool = healingTool;
    }


    //move1. This move uses whatever healingTool the healer is in ownership of.
    public String standardMove(Character characterToHeal) {
        if (shouldDoMove(this.healingTool.chanceValue)) {
            characterToHeal.beHealed(this.healingTool.healingValue);
            return (this.getName() + " healed " + characterToHeal.getName() + " successfully.");
        } else return this.getName() + " missed " + characterToHeal.getName() + "!";
    }

    //move2. This move resurrects the player with 100 hp, but the likelihood of it happening is low as the chance value is 2.
    public String signatureMove(Character characterToHeal) {
        if (characterToHeal.getHp() < 0 ){
            if (shouldDoMove(HealingTool.RESURRECTION.chanceValue)) {
                characterToHeal.beHealed(HealingTool.RESURRECTION.healingValue);
                return this.getName() + " healed " + characterToHeal.getName() + " successfully.";
            }
            else return this.getName() + " missed " + characterToHeal.getName() + "!";
        }
        else return characterToHeal.getName() + " is still Alive!";}


    public void randomHealingTool() {
        int result = getRandomNumber(4);
        if (result == 0) {
            this.healingTool = HealingTool.HERBS;
        } else if (result == 1) {
            this.healingTool = HealingTool.BITTEROOT;
        }else if (result == 2) {
            this.healingTool = HealingTool.AGOODSNOOZE;
        }else if (result == 3) {
            this.healingTool = HealingTool.HERBS;
        }
    }



}

