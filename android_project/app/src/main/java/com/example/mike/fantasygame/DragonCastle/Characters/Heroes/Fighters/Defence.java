package com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters;


import java.io.Serializable;

public enum Defence implements Serializable {

    SHIELD(0.5),
    ARMOUR(0.75),
    ARMGUARDS(0.9);

    public final double defenceValue;


    Defence(double defenceValue) {
        this.defenceValue = defenceValue;
    }

    public double getDefenceValue() {
        return defenceValue;
    }

}

