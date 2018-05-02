package com.example.mike.fantasygame.DragonCastle.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mike.fantasygame.DragonCastle.DataPeristence.ApplicationState;
import com.example.mike.fantasygame.DragonCastle.DataPeristence.SharedPreferenceHelper;
import com.example.mike.fantasygame.R;

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

        this.monsterImageView = findViewById(R.id.monsterImageViewId);

        this.monsterNameTextView = findViewById(R.id.monsterNameTextViewId);
        monsterNameTextView.setText(applicationState.getGame().getNewRooms().get(0).getMonster().getName());

        this.monsterHpTextView = findViewById(R.id.monsterHpTextViewId);
        String hp = "HP: " + applicationState.getGame().getNewRooms().get(0).getMonster().getHp();
        monsterHpTextView.setText(hp);

        this.partyOfHeroesListView = findViewById(R.id.partyOfHeroesListViewId);


    }
}
