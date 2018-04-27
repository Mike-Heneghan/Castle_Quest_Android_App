import Characters.Narrator;
import org.junit.Before;
import org.junit.Test;

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
        assertEquals("Knight 1 attacked! Knight 2 attacked!",narrator1.tellTale());}

    @Test
    public void canResetTale() {
        narrator1.addStoryLine("Knight 1 attacked!");
        narrator1.addStoryLine("Knight 2 attacked!");
        assertEquals("Knight 1 attacked! Knight 2 attacked!", narrator1.tellTale());
        narrator1.addStoryLine("Knight 3 attacked");
        assertEquals("Knight 3 attacked", narrator1.tellTale());
    }



}
