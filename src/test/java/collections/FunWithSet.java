package collections;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.stream.Collectors;

public class FunWithSet {

    @Test
    public void fillAndPrintSet() {
        HashSet<String> set = new HashSet<>();
        set.add("o");
        set.add("b");
        set.add("a");
        set.add("o");
        set.add("c");
        set.forEach(System.out::println);

        System.out.println("to list:");
        var list = set.stream().collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
