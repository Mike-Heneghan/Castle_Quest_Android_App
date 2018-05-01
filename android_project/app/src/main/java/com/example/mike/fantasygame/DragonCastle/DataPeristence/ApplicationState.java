package com.example.mike.fantasygame.DragonCastle.DataPeristence;

import com.example.mike.fantasygame.DragonCastle.Game.Game;
import com.example.mike.fantasygame.DragonCastle.Room.Room;

import java.io.Serializable;

public class ApplicationState implements Serializable {

//    private Game game;
    private String bananas;

    public ApplicationState(String bananas){
        this.bananas = bananas;
    }

    public String getGame(){
        return bananas;
    }

}
