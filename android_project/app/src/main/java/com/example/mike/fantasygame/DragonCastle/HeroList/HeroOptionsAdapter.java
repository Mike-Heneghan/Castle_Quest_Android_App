package com.example.mike.fantasygame.DragonCastle.HeroList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mike.fantasygame.R;

import java.io.Serializable;
import java.util.ArrayList;

public class HeroOptionsAdapter extends ArrayAdapter<HeroOption> implements Serializable {

    public HeroOptionsAdapter(Context context, ArrayList<HeroOption> heroOptions){
        super(context, 0, heroOptions);
    }

    @Override
    public View getView(int position, View characterSelectionListViewId, ViewGroup parent){

        if (characterSelectionListViewId == null){
            characterSelectionListViewId = LayoutInflater.from(getContext()).inflate(R.layout.hero_option_item, parent, false);
        }

        HeroOption currentHeroOption = getItem(position);
// Need to add icon drawable resources.
        ImageView heroImageView = characterSelectionListViewId.findViewById(R.id.heroImageViewId);

        TextView heroTypeNameTextView = characterSelectionListViewId.findViewById(R.id.heroTypeNameTextViewId);
        heroTypeNameTextView.setText(currentHeroOption.getTypeName().toString());

        Button selectForDetailedViewButton = characterSelectionListViewId.findViewById(R.id.selectForDetailedViewButtonId);

        selectForDetailedViewButton.setTag(currentHeroOption);
        return characterSelectionListViewId;
    }

}
