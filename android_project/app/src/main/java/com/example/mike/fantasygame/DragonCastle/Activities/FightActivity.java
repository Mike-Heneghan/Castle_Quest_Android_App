package com.example.mike.fantasygame.DragonCastle.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters.Knight;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Hero;
import com.example.mike.fantasygame.DragonCastle.DataPeristence.ApplicationState;
import com.example.mike.fantasygame.DragonCastle.DataPeristence.SharedPreferenceHelper;
import com.example.mike.fantasygame.DragonCastle.FightList.FightItemAdapter;
import com.example.mike.fantasygame.R;

import java.util.ArrayList;

public class FightActivity extends AppCompatActivity {

    private ImageView monsterImageView;
    private TextView monsterNameTextView;
    private TextView monsterHpTextView;
    private ListView partyOfHeroesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        ApplicationState applicationState = SharedPreferenceHelper.loadApplicationState(this);

        ArrayList<Hero> list = applicationState.getGame().getNewRooms().get(0).getHeroes();

        FightItemAdapter fightItemAdapter = new FightItemAdapter(this,list);

        this.partyOfHeroesListView = findViewById(R.id.partyOfHeroesListViewId);
        partyOfHeroesListView.setAdapter(fightItemAdapter);

        this.monsterImageView = findViewById(R.id.monsterImageViewId);

        this.monsterNameTextView = findViewById(R.id.monsterNameTextViewId);
        monsterNameTextView.setText(applicationState.getGame().getNewRooms().get(0).getMonster().getName());

        this.monsterHpTextView = findViewById(R.id.monsterHpTextViewId);
        String hp = "HP: " + applicationState.getGame().getNewRooms().get(0).getMonster().getHp();
        monsterHpTextView.setText(hp);

    }

    public void onMove1ButtonClicked(View button){
        Hero hero = ((Hero) button.getTag());
        String heroName = hero.getName();
        ApplicationState applicationState = SharedPreferenceHelper.loadApplicationState(this);
        Knight heroToAttack = ((Knight) applicationState.getGame().getNewRooms().get(0).getHeroes().get(0));
        applicationState.getGame().getNewRooms().get(0).heroStandardMove(heroToAttack);
        applicationState.getGame().getNewRooms().get(0).monsterAttacks();
        SharedPreferenceHelper.saveApplicationState(this, applicationState);
        refreshHeroes();
    }

    public void refreshHeroes(){
        ApplicationState applicationState = SharedPreferenceHelper.loadApplicationState(this);
        ArrayList<Hero> list = applicationState.getGame().getNewRooms().get(0).getHeroes();
        FightItemAdapter fightItemAdapter = new FightItemAdapter(this,list);
        partyOfHeroesListView.setAdapter(fightItemAdapter);
    }


}
