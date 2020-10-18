package algorithms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IdenticalCharactersCounterTest {

    @Test
    public void test() {
        var testST = new IdenticalCharactersCounter().counter("aaabbbccc");
        System.out.println("UUU: " + testST);
        Assert.assertEquals(testST, "a3b3c3");
    }
}
