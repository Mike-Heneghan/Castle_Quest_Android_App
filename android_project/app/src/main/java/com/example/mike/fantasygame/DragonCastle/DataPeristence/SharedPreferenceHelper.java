package com.example.mike.fantasygame.DragonCastle.DataPeristence;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mike.fantasygame.DragonCastle.Game.SerializableGame;
import com.example.mike.fantasygame.R;
import com.google.gson.Gson;

import java.io.Serializable;

public class SharedPreferenceHelper implements Serializable {

    public static void saveApplicationState(Context context, ApplicationState state){

        SharedPreferences.Editor editor = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(state);
        editor.putString("APPLICATION_STATE", json);
        editor.apply();

    }

    public static ApplicationState loadApplicationState(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    Gson gson = new Gson();
    ApplicationState applicationState = gson.fromJson(sharedPreferences.getString("APPLICATION_STATE", "{}"), ApplicationState.class);
    return applicationState;
    }



}
