package DragonCastleTests;

import DragonCastle.Characters.Narrator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class NarratorTest {

    @Before
    public void before(){
        Narrator.getInstance().clearNarrator();
    }

    @Test
    public void canAddString(){
    Narrator.getInstance().addStoryLine("Knight 1 attacked!");
    assertEquals("Knight 1 attacked!",Narrator.getInstance().getStoryArrayListStrings().get(0));}

    @Test
    public void canTellTale(){
        Narrator.getInstance().addStoryLine("Knight 1 attacked!");
        Narrator.getInstance().addStoryLine("Knight 2 attacked!");
        ArrayList<String> answer = new ArrayList<>();
        answer.add("Knight 1 attacked!");
        answer.add("Knight 2 attacked!");
        assertEquals(answer ,Narrator.getInstance().tellTale());}

    @Test
    public void canResetTale() {
        Narrator.getInstance().addStoryLine("Knight 1 attacked!");
        Narrator.getInstance().addStoryLine("Knight 2 attacked!");
        ArrayList<String> answer = new ArrayList<>();
        answer.add("Knight 1 attacked!");
        answer.add("Knight 2 attacked!");
        assertEquals(answer, Narrator.getInstance().tellTale());
        Narrator.getInstance().addStoryLine("Knight 3 attacked");
        ArrayList<String> answer2 = new ArrayList<>();
        answer2.add("Knight 3 attacked");
        assertEquals(answer2, Narrator.getInstance().tellTale());
    }



}
