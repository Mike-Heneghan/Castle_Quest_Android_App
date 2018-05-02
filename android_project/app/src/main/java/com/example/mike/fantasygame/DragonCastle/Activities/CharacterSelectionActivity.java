package com.example.mike.fantasygame.DragonCastle.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mike.fantasygame.DragonCastle.DataPeristence.ApplicationState;
import com.example.mike.fantasygame.DragonCastle.DataPeristence.SharedPreferenceHelper;
import com.example.mike.fantasygame.DragonCastle.HeroList.HeroOption;
import com.example.mike.fantasygame.DragonCastle.HeroList.HeroOptionsAdapter;
import com.example.mike.fantasygame.DragonCastle.HeroList.HeroOptionsData;
import com.example.mike.fantasygame.R;

import java.util.ArrayList;

public class CharacterSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);

        HeroOptionsData heroOptionsData = new HeroOptionsData();
        ArrayList<HeroOption> list = heroOptionsData.getList();

        HeroOptionsAdapter heroOptionsAdapter = new HeroOptionsAdapter(this, list);


        ListView listView = findViewById(R.id.characterSelectionListViewId);
        listView.setAdapter(heroOptionsAdapter);
    }

    public void onHeroSelectButtonClicked (View button){
        HeroOption heroOption = ((HeroOption) button.getTag());
        Intent intent = new Intent(this, HeroOptionDetailedActivity.class);
        intent.putExtra("heroOption", heroOption);
        startActivity(intent);
    }

    public void onCreatePartyButtonPressed(View button){
        ApplicationState applicationState = SharedPreferenceHelper.loadApplicationState(this);
        applicationState.getGame().moveToNextRoom();
        SharedPreferenceHelper.saveApplicationState(this, applicationState);
        makeToast();
        Intent intent2 = new Intent(this, FightActivity.class);
        startActivity(intent2);
    }

    public void makeToast(){
        Context context = getApplicationContext();
        CharSequence text = "Fight!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
