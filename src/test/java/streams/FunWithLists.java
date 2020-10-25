package streams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunWithLists {

    @Test
    public void sumElms() {
        ArrayList<Integer> listInt = new ArrayList<>();
        IntStream.range(1, 10).forEach(listInt::add);
        listInt.forEach(System.out::println);
        // don't know difference between parallelStream() and common stream()...but try to guess :)
        int sum = listInt.parallelStream().collect(Collectors.summingInt(Integer::intValue));
        // That also works, result the same:
        // int sum = listInt.stream().mapToInt(Integer::intValue).sum();
        System.out.println("after collect did work: " + sum);
    }
}
