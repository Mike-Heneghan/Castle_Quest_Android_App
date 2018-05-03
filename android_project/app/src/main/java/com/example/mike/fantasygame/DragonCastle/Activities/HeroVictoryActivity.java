package com.example.mike.fantasygame.DragonCastle.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Hero;
import com.example.mike.fantasygame.DragonCastle.FightList.FightItemAdapter;
import com.example.mike.fantasygame.DragonCastle.FightList.SurvivourItemAdapter;
import com.example.mike.fantasygame.DragonCastle.Game.Game;
import com.example.mike.fantasygame.R;

import java.util.ArrayList;

public class HeroVictoryActivity extends AppCompatActivity {

    private ListView survivourListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_victory);

        ArrayList<Hero> list = Game.getInstance().getNewRooms().get(0).returnAliveHeroes();

        SurvivourItemAdapter survivourItemAdapter= new SurvivourItemAdapter(this,list);

        this.survivourListView = findViewById(R.id.heroesLeftAliveListViewId);
        survivourListView.setAdapter(survivourItemAdapter);
    }

    public void onNextRoomButtonClicked(View button){
        Game.getInstance().moveToNextRoom();
        finish();
    }
}
