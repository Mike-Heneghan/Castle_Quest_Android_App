package com.example.mike.fantasygame.DragonCastle.HeroList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class HeroOptionsAdapter extends ArrayAdapter<HeroOption> {

    public HeroOptionsAdapter(Context context, ArrayList<HeroOption> heroOptions){
        super(context, 0, heroOptions);
    }

//    @Override
//    public View getView(int position, View characterSelectionListViewId, ViewGroup parent){}

}
