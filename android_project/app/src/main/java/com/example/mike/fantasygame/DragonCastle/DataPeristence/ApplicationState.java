package com.example.mike.fantasygame.DragonCastle.DataPeristence;

import com.example.mike.fantasygame.DragonCastle.Game.Game;
import com.example.mike.fantasygame.DragonCastle.Game.Game;
import com.example.mike.fantasygame.DragonCastle.Room.Room;

import java.io.Serializable;

public class ApplicationState implements Serializable {

    private Game serializableGame;


    public ApplicationState(Game serializableGame){
        this.serializableGame = serializableGame;
    }

    public Game getGame(){
        return this.serializableGame;
    }

}
