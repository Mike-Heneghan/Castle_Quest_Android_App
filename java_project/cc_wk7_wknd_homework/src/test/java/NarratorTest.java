import Characters.Narrator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class NarratorTest {
    private Narrator narrator1;

    @Before
    public void before(){
        narrator1 = new Narrator();
    }

    @Test
    public void canAddString(){
    narrator1.addStoryLine("Knight 1 attacked!");
    assertEquals("Knight 1 attacked!",narrator1.getStoryArrayListStrings().get(0));}

    @Test
    public void canTellTale(){
        narrator1.addStoryLine("Knight 1 attacked!");
        narrator1.addStoryLine("Knight 2 attacked!");
        ArrayList<String> answer = new ArrayList<>();
        answer.add("Knight 1 attacked!");
        answer.add("Knight 2 attacked!");
        assertEquals(answer ,narrator1.tellTale());}

    @Test
    public void canResetTale() {
        narrator1.addStoryLine("Knight 1 attacked!");
        narrator1.addStoryLine("Knight 2 attacked!");
        ArrayList<String> answer = new ArrayList<>();
        answer.add("Knight 1 attacked!");
        answer.add("Knight 2 attacked!");
        assertEquals(answer, narrator1.tellTale());
        narrator1.addStoryLine("Knight 3 attacked");
        ArrayList<String> answer2 = new ArrayList<>();
        answer2.add("Knight 3 attacked");
        assertEquals(answer2, narrator1.tellTale());
    }



}
