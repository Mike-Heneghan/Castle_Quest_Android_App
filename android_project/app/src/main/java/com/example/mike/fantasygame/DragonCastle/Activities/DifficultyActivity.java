package com.example.mike.fantasygame.DragonCastle.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mike.fantasygame.DragonCastle.DataPeristence.ApplicationState;
import com.example.mike.fantasygame.DragonCastle.DataPeristence.SharedPreferenceHelper;
import com.example.mike.fantasygame.DragonCastle.Game.Game;

import com.example.mike.fantasygame.R;

public class DifficultyActivity extends AppCompatActivity {

    private TextView selectDifficultyTextView;
    private Button easyDifficultyButton;
    private Button mediumDifficultyButton;
    private Button hardDifficultyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);


        selectDifficultyTextView = findViewById(R.id.selectDifficultyTextViewId);
        easyDifficultyButton = findViewById(R.id.easyDifficultyButtonId);
        mediumDifficultyButton = findViewById(R.id.mediumDifficultyButtonId);
        hardDifficultyButton = findViewById(R.id.hardDifficultyButtonId);


    }

    public void makeToast(){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String userName = extras.getString("userName", "Name");
        Context context = getApplicationContext();
        CharSequence text = userName + "'s new game Created!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void onEasyDifficultyButtonClicked(View button) {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String userName = extras.getString("userName", "Name");
        Game.getFirstInstance(userName, 3);
        makeToast();
        Intent intent2 = new Intent(this, CharacterSelectionActivity.class);
        startActivity(intent2);
    }

    public void onMediumDifficultyButtonClicked(View button){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String userName = extras.getString("userName", "Name");
        Game.getFirstInstance(userName, 5);
        makeToast();
        Intent intent2 = new Intent(this, CharacterSelectionActivity.class);
        startActivity(intent2);
    }

    public void onHardDifficultyButtonClicked(View button){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String userName = extras.getString("userName", "Name");
       Game.getFirstInstance(userName, 10);
        makeToast();
        Intent intent2 = new Intent(this, CharacterSelectionActivity.class);
        startActivity(intent2);
    }
}
