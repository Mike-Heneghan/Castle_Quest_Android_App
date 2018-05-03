package com.example.mike.fantasygame.DragonCastle.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters.Knight;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Hero;
import com.example.mike.fantasygame.DragonCastle.DataPeristence.ApplicationState;
import com.example.mike.fantasygame.DragonCastle.DataPeristence.SharedPreferenceHelper;
import com.example.mike.fantasygame.DragonCastle.Game.Game;
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

        int imageId = heroOption.getImageId();
        Drawable resourceImage = null;

        if (imageId == 1){
            resourceImage = getResources().getDrawable(R.drawable.one);
        }
        else if(imageId == 2){
            resourceImage = getResources().getDrawable(R.drawable.two);
        }
        else if(imageId == 3){
            resourceImage = getResources().getDrawable(R.drawable.three);
        }
        else if(imageId == 4){
            resourceImage = getResources().getDrawable(R.drawable.four);
        }
        else if(imageId == 5){
            resourceImage = getResources().getDrawable(R.drawable.five);
        }

        this.detailedHeroOptionImageView = findViewById(R.id.detailedHeroOptionImageViewId);
        detailedHeroOptionImageView.setImageDrawable(resourceImage);

        this.detailedHeroTypeTextView = findViewById(R.id.detailedHeroTypeTextViewId);
        detailedHeroTypeTextView.setText(heroOption.getTypeName());

        this.detailedHeroTypeDescritption = findViewById(R.id.detailedHeroTypeDescriptionId);
        detailedHeroTypeDescritption.setText(heroOption.getTypeDescription());

        this.detailedHeroHpTextView = findViewById(R.id.detailedHeroHpTextViewId);
        detailedHeroHpTextView.setText(heroOption.getHealthPoints());

        this.heroMove1TextViewId = findViewById(R.id.heroMove1TextViewId);
        heroMove1TextViewId.setText(heroOption.getMove1Description());

        this.heroMove2TextViewId = findViewById(R.id.heroMove2TextViewId);
        heroMove2TextViewId.setText(heroOption.getMove2Description());
        this.heroNameEditTextView = findViewById(R.id.heroNameEditTextViewId);

        this.addCharacterToPartyButton = findViewById(R.id.addCharacterToPartyButtonId);

    }

    public void onAddHeroButtonClicked(View button) {
        String heroName = heroNameEditTextView.getText().toString();
        Intent intent = getIntent();
        HeroOption heroOption = ((HeroOption) intent.getSerializableExtra("heroOption"));
        Context context = getApplicationContext();
        CharSequence text = heroOption.getTypeName() + " added!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);


        if(heroOption.getTypeName().toString().equals("Knight")) {
            Game.getInstance().addKnight(heroName);
            toast.show();
            finish();
        }

        else if (heroOption.getTypeName().equals("Dwarf")) {
            Game.getInstance().addDwarf(heroName);
            toast.show();
            finish();
        }
        else if (heroOption.getTypeName().equals("Barbarian")) {
            Game.getInstance().addBarbarian(heroName);
            toast.show();
            finish();
        }
        else if (heroOption.getTypeName().equals("Warlock")) {
            Game.getInstance().addWarlock(heroName);
            toast.show();
            finish();
        }
        else if (heroOption.getTypeName().equals("Cleric")) {
            Game.getInstance().addCleric(heroName);
            toast.show();
            finish();
        }
        else {finish();}

        }
        public void onBackButtonClicked(View button){
            finish();
        }


}
