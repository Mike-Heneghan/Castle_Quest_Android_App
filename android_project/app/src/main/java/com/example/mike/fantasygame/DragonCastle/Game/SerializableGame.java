package com.example.mike.fantasygame.DragonCastle.Game;

import java.io.Serializable;

public  class SerializableGame extends Game implements Serializable{
    public SerializableGame(String name, int roomsToGenerate) {
        super(name, roomsToGenerate);
    }


}
