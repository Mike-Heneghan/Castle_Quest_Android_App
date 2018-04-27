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

    public String tellTale(){
        String userStory = this.tale();
        clearStory();
        return userStory;
    }

    public String tale() {
        String tale = "";
        int storyLength = story.size();
        for (int i = 0; i < storyLength; i++) {
            String line = story.get(i);
            if (i == 0){
            tale = (tale + line);}
            else {
                tale = tale + " " +line;}
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
