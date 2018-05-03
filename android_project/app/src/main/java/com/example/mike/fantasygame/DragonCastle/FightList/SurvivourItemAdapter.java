package com.example.mike.fantasygame.DragonCastle.FightList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Hero;
import com.example.mike.fantasygame.R;

import java.io.Serializable;
import java.util.ArrayList;

public class SurvivourItemAdapter extends ArrayAdapter<Hero> implements Serializable{

    public SurvivourItemAdapter(Context context, ArrayList<Hero> survivorItems){
        super(context, 0, survivorItems);
    }

    @Override
    public View getView(int position, View heroesLeftAliveListViewId, ViewGroup parent){

        if (heroesLeftAliveListViewId == null){
            heroesLeftAliveListViewId = LayoutInflater.from(getContext()).inflate(R.layout.hero_survivor, parent, false);
        }

        Hero currentHero = getItem(position);
//
        int imageId = currentHero.getImageId();
        Drawable resourceImage = null;

        if (imageId == 1){
            resourceImage = getContext().getResources().getDrawable(R.drawable.one);
        }
        else if(imageId == 2){
            resourceImage = getContext().getResources().getDrawable(R.drawable.two);
        }
        else if(imageId == 3){
            resourceImage = getContext().getResources().getDrawable(R.drawable.three);
        }
        else if(imageId == 4){
            resourceImage = getContext().getResources().getDrawable(R.drawable.four);
        }
        else if(imageId == 5){
            resourceImage = getContext().getResources().getDrawable(R.drawable.five);
        }


        ImageView heroImageView = heroesLeftAliveListViewId.findViewById(R.id.survivourHeroItemImageViewId3);
        heroImageView.setImageDrawable(resourceImage);

        TextView fightHeroName = heroesLeftAliveListViewId.findViewById(R.id.survivourHeroItemNameTextViewId3);
        fightHeroName.setText(currentHero.getName().toString());
        TextView fightHeroHp = heroesLeftAliveListViewId.findViewById(R.id.survivourHeroItemHpTextViewId3);
        String hp = "HP: " + currentHero.getHp();
        fightHeroHp.setText(hp);


        return heroesLeftAliveListViewId;
    }
}
