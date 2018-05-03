package com.example.mike.fantasygame.DragonCastle.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Hero;
import com.example.mike.fantasygame.DragonCastle.Characters.Narrator;
import com.example.mike.fantasygame.DragonCastle.FightList.FightItemAdapter;
import com.example.mike.fantasygame.DragonCastle.Game.Game;
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

        ArrayList<Hero> list = Game.getInstance().getNewRooms().get(0).getHeroes();

        FightItemAdapter fightItemAdapter = new FightItemAdapter(this,list);

        int imageId = Game.getInstance().getNewRooms().get(0).getMonster().getImageId();
        Drawable resourceImage = null;

        if (imageId == 6){
            resourceImage = getResources().getDrawable(R.drawable.six);
        }
        else if(imageId == 7){
            resourceImage = getResources().getDrawable(R.drawable.seven);
        }
        else if(imageId == 8){
            resourceImage = getResources().getDrawable(R.drawable.eight);
        }
        else if(imageId == 9){
            resourceImage = getResources().getDrawable(R.drawable.nine);
        }


        this.partyOfHeroesListView = findViewById(R.id.partyOfHeroesListViewId);
        partyOfHeroesListView.setAdapter(fightItemAdapter);

        this.monsterImageView = findViewById(R.id.monsterImageViewId);
        monsterImageView.setImageDrawable(resourceImage);

        this.monsterNameTextView = findViewById(R.id.monsterNameTextViewId);
        monsterNameTextView.setText(Game.getInstance().getNewRooms().get(0).getMonster().getName());

        this.monsterHpTextView = findViewById(R.id.monsterHpTextViewId);
        String hp = "HP: " + Game.getInstance().getNewRooms().get(0).getMonster().getHp();
        monsterHpTextView.setText(hp);

        refreshHeroes();
        refreshMonster();

    }

    public void onMove1ButtonClicked(View button){
        checkGameStatus();
        Hero hero = ((Hero) button.getTag());
        String heroName = hero.getName();
        Hero heroToAttack = Game.getInstance().getNewRooms().get(0).getHeroByName(heroName);
        Game.getInstance().getNewRooms().get(0).heroStandardMove(heroToAttack);
        Game.getInstance().getNewRooms().get(0).monsterAttacks();
        makeToast();
        refreshHeroes();
        refreshMonster();
    }

    public void onMove2ButtonClicked(View button){
        checkGameStatus();
        Hero hero = ((Hero) button.getTag());
        String heroName = hero.getName();
        Hero heroToAttack = Game.getInstance().getNewRooms().get(0).getHeroByName(heroName);
        Game.getInstance().getNewRooms().get(0).heroSignatureMove(heroToAttack);
        Game.getInstance().getNewRooms().get(0).monsterAttacks();
        makeToast();
        refreshHeroes();
        refreshMonster();
    }

    public void refreshHeroes(){
        ArrayList<Hero> list = Game.getInstance().getNewRooms().get(0).getHeroes();
        FightItemAdapter fightItemAdapter = new FightItemAdapter(this,list);
        partyOfHeroesListView.setAdapter(fightItemAdapter);
    }

    public void refreshMonster(){

        int imageId = Game.getInstance().getNewRooms().get(0).getMonster().getImageId();
        Drawable resourceImage = null;
        if (imageId == 6){
            resourceImage = getResources().getDrawable(R.drawable.six);
        }
        else if(imageId == 7){
            resourceImage = getResources().getDrawable(R.drawable.seven);
        }
        else if(imageId == 8){
            resourceImage = getResources().getDrawable(R.drawable.eight);
        }
        else if(imageId == 9){
            resourceImage = getResources().getDrawable(R.drawable.nine);
        }

        monsterImageView.setImageDrawable(resourceImage);
        monsterNameTextView.setText(Game.getInstance().getNewRooms().get(0).getMonster().getName());
        String hpValue = "";
        if (Game.getInstance().getNewRooms().get(0).isMonsterDead()){
            hpValue = "0";
        }
        else hpValue = "" +Game.getInstance().getNewRooms().get(0).getMonster().getHp();
        String hpToShow = "HP: " + hpValue;
        monsterHpTextView.setText(hpToShow);
    }

    public void makeToast(){
        Context context = getApplicationContext();
        CharSequence text = Narrator.getInstance().tellTale().toString();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void checkGameStatus(){
        if (Game.getInstance().getNewRooms().get(0).areAllHeroesDefeated() == true){
            Intent intent2 = new Intent(this, GameOverActivity.class);
            startActivity(intent2);}

        else if (Game.getInstance().getNewRooms().get(0).isMonsterDead() == true){
            Game.getInstance().getNewRooms().get(0).heroesCollectTreasure();
            Intent intent3 = new Intent(this, HeroVictoryActivity.class);
            startActivity(intent3);}
    }
}
