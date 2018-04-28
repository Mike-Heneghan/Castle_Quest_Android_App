package Characters;

import java.util.ArrayList;

public class Narrator {
    private ArrayList<String> story;

    public Narrator(){
        this.story = new ArrayList<>();
    }

    public void addStoryLine(String info){
        story.add(info);
    }

    public ArrayList<String> tellTale(){
        ArrayList<String> userStory = tale();
        clearStory();
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
}
