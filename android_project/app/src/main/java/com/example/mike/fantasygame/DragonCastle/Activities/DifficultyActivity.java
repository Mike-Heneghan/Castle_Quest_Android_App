package com.example.mike.fantasygame.DragonCastle.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    public void onEasyDifficultyButtonClicked(View button){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String userName = extras.getString("userName", "Name");
        Game game = new Game(userName, 3);
        ApplicationState applicationState = new ApplicationState(game);
        SharedPreferenceHelper.saveApplicationState(this, applicationState);
        Intent intent2 = new Intent(this, CharacterSelectionActivity.class);
        intent.putExtra("guess", intent);
        startActivity(intent2);
    }

    public void onMediumDifficultyButtonClicked(View button){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String userName = extras.getString("userName", "Name");
        Game game = new Game(userName, 5);
        ApplicationState applicationState = new ApplicationState(game);
        SharedPreferenceHelper.saveApplicationState(this, applicationState);

        startActivity(intent);
    }

    public void onHardDifficultyButtonClicked(View button){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String userName = extras.getString("userName", "Name");
        Game game = new Game(userName, 10);
        ApplicationState applicationState = new ApplicationState(game);
        SharedPreferenceHelper.saveApplicationState(this, applicationState);

        startActivity(intent);
    }
}
