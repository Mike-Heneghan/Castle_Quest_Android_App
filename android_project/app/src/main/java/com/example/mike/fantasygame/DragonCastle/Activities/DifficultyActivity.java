package com.example.mike.fantasygame.DragonCastle.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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
}
