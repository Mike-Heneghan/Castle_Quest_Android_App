package com.example.mike.fantasygame.DragonCastle.HeroList;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class HeroOptionsAdapter extends ArrayAdapter<HeroOption> {

    public HeroOptionsAdapter(Context context, ArrayList<HeroOption> heroOptions){
        super(context, 0, heroOptions);
    }
}
