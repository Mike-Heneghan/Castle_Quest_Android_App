package com.example.mike.fantasygame.DragonCastle.Characters;

import java.io.Serializable;
import java.util.ArrayList;

public class Narrator  implements Serializable {
    private static Narrator instance = null;

    private ArrayList<String> story;

    protected Narrator(){
        this.story = new ArrayList<>();
    }

    public static Narrator getInstance(){
        if (instance == null){
            instance = new Narrator();
        }
        return instance;
    }

    public void addStoryLine(String info){
        story.add(info);
    }

    public ArrayList<String> tellTale(){
        ArrayList<String> userStory = tale();
        clearStory();
        Narrator.getInstance().clearNarrator();
        return userStory;
    }

    public ArrayList<String> tale() {
        ArrayList<String> tale = new ArrayList<>();
        int storyLength = story.size();
        for (int i = 0; i < storyLength; i++) {
           tale.add(story.get(i));
        }
        return tale;
    }

    public ArrayList<String> getStoryArrayListStrings(){
        return story;
    }

    public void clearStory(){
        story.clear();
    }

    public void clearNarrator(){
        instance = new Narrator();
    }
}
