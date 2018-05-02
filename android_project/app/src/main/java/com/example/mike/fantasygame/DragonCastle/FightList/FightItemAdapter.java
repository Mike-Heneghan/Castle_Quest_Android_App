package com.example.mike.fantasygame.DragonCastle.FightList;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Hero;
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

        ImageView heroImageView = partyOfHeroesListViewId.findViewById(R.id.fightHeroItemImageViewId);

        TextView fightHeroName = partyOfHeroesListViewId.findViewById(R.id.fightHeroItemNameTextViewId);
        fightHeroName.setText(currentHero.getName().toString());
        TextView fightHeroHp = partyOfHeroesListViewId.findViewById(R.id.fightHeroItemHpTextViewId);
        String hp = "HP: " + currentHero.getHp();
        fightHeroHp.setText(hp);

        Button move1 = partyOfHeroesListViewId.findViewById(R.id.move1ButtonId);

        Button move2 = partyOfHeroesListViewId.findViewById(R.id.move2ButtonId);

        return partyOfHeroesListViewId;
    }
}
