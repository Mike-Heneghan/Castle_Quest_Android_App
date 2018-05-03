package com.example.mike.fantasygame.DragonCastle.HeroList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
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
import java.util.ResourceBundle;

public class HeroOptionsAdapter extends ArrayAdapter<HeroOption>  implements Serializable {

    private ImageView heroImageView;

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

        int imageId = currentHeroOption.getImageId();
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

        this.heroImageView = characterSelectionListViewId.findViewById(R.id.heroImageViewId);
        heroImageView.setImageDrawable(resourceImage);

        TextView heroTypeNameTextView = characterSelectionListViewId.findViewById(R.id.heroTypeNameTextViewId);
        heroTypeNameTextView.setText(currentHeroOption.getTypeName().toString());

        Button selectForDetailedViewButton = characterSelectionListViewId.findViewById(R.id.selectForDetailedViewButtonId);

        selectForDetailedViewButton.setTag(currentHeroOption);
        return characterSelectionListViewId;
    }

}
