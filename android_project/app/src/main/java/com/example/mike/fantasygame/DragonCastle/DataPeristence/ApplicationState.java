package com.example.mike.fantasygame.DragonCastle.DataPeristence;

import com.example.mike.fantasygame.DragonCastle.Game.Game;
import com.example.mike.fantasygame.DragonCastle.Room.Room;

import java.io.Serializable;

public class ApplicationState implements Serializable {

    private Game game;

    public ApplicationState(Game game){
        this.game = game;
    }

    public Game getGame(){
        return game;
    }

}
