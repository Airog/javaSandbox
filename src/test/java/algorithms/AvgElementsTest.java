package algorithms;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AvgElementsTest {

    @Test
    public void testIntV1() {
        List<Integer> list = Arrays.asList(1, 7, 5, 2, 4, 8);
        var res = new AvgElements().findAvgIntV1(list);
        System.out.println("Here the average int1: " + res);
        Assert.assertEquals(res, 4);
    }

    @Test
    public void testIntV2() {
        List<Integer> list = Arrays.asList(1, 7, 5, 2, 4, 8);
        var res = new AvgElements().findAvgIntV2(list);
        System.out.println("Here the average int2: " + res);
        Assert.assertEquals(res, 4);
    }

    @Test
    public void testStr() {
        List<String> list = Arrays.asList("1", "2", "3");
        var res = new AvgElements().findAvgStr(list);
        System.out.println("Here the average str: " + res);
        Assert.assertEquals(res, 2);
    }
}
