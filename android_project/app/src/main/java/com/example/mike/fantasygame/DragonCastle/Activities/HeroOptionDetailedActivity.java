package com.example.mike.fantasygame.DragonCastle.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mike.fantasygame.DragonCastle.HeroList.HeroOption;
import com.example.mike.fantasygame.R;

public class HeroOptionDetailedActivity extends AppCompatActivity {

    private ImageView detailedHeroOptionImageView;
    private TextView detailedHeroTypeTextView;
    private TextView detailedHeroHpTextView;
    private TextView heroMove1TextViewId;
    private TextView heroMove2TextViewId;
    private EditText heroNameEditTextView;
    private Button addCharacterToPartyButton;
    private Button backButtonId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_option_detailed);

        Intent intent = getIntent();
        HeroOption heroOption = ((HeroOption) intent.getSerializableExtra("heroOption"));

        this.detailedHeroOptionImageView = findViewById(R.id.detailedHeroOptionImageViewId);

        this.detailedHeroTypeTextView = findViewById(R.id.detailedHeroTypeTextViewId);
        detailedHeroTypeTextView.setText(heroOption.getTypeName().toString());

    }
}
