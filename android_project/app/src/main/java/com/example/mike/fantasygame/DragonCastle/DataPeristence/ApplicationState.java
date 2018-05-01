package com.example.mike.fantasygame.DragonCastle.DataPeristence;

import com.example.mike.fantasygame.DragonCastle.Game.Game;
import com.example.mike.fantasygame.DragonCastle.Game.SerializableGame;
import com.example.mike.fantasygame.DragonCastle.Room.Room;

import java.io.Serializable;

public class ApplicationState implements Serializable {

    private SerializableGame serializableGame;


    public ApplicationState(SerializableGame serializableGame){
        this.serializableGame = serializableGame;
    }

    public SerializableGame getGame(){
        return this.serializableGame;
    }

}
