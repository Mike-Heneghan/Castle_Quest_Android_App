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
    private TextView detailedHeroTypeDescritption;
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

        this.detailedHeroTypeDescritption = findViewById(R.id.detailedHeroTypeDescriptionId);
        detailedHeroTypeDescritption.setText(heroOption.getTypeDescription().toString());

        this.detailedHeroHpTextView = findViewById(R.id.detailedHeroHpTextViewId);
        detailedHeroHpTextView.setText(heroOption.getHealthPoints().toString());

        this.heroMove1TextViewId = findViewById(R.id.heroMove1TextViewId);
        heroMove1TextViewId.setText(heroOption.getMove1Description().toString());

        this.heroMove2TextViewId = findViewById(R.id.heroMove2TextViewId);
        heroMove2TextViewId.setText(heroOption.getMove2Description().toString());


    }
}
