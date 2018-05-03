package com.example.mike.fantasygame.DragonCastle.FightList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.graphics.drawable.Drawable;

import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Hero;
import com.example.mike.fantasygame.DragonCastle.Game.Game;
import com.example.mike.fantasygame.R;

import java.io.Serializable;
import java.util.ArrayList;

public class FightItemAdapter extends ArrayAdapter<Hero> implements Serializable{

    public FightItemAdapter(Context context, ArrayList<Hero> fightItems){
        super(context, 0, fightItems);
    }

    @Override
    public View getView(int position, View partyOfHeroesListViewId, ViewGroup parent){

        if (partyOfHeroesListViewId == null){
            partyOfHeroesListViewId = LayoutInflater.from(getContext()).inflate(R.layout.fight_hero_item, parent, false);
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


        ImageView heroImageView = partyOfHeroesListViewId.findViewById(R.id.fightHeroItemImageViewId);
        heroImageView.setImageDrawable(resourceImage);

        TextView fightHeroName = partyOfHeroesListViewId.findViewById(R.id.fightHeroItemNameTextViewId);
        fightHeroName.setText(currentHero.getName().toString());
        TextView fightHeroHp = partyOfHeroesListViewId.findViewById(R.id.fightHeroItemHpTextViewId);
        String hp = "HP: " + currentHero.getHp();
        fightHeroHp.setText(hp);

        Button move1 = partyOfHeroesListViewId.findViewById(R.id.move1ButtonId);

        Button move2 = partyOfHeroesListViewId.findViewById(R.id.move2ButtonId);

        move1.setTag(currentHero);
        move2.setTag(currentHero);

        return partyOfHeroesListViewId;
    }
}
