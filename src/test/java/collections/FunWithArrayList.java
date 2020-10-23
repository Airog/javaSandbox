package collections;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class FunWithArrayList {

    ArrayList<String> listSt;
    ArrayList<Integer> listInt;


    @BeforeTest
    public void bf() {
        listInt = new ArrayList<>();
        IntStream.range(1, 10).forEach(x -> listInt.add(x));

        listSt = new ArrayList<>();
        IntStream.range(1, 10).forEach(x -> listSt.add(Integer.toString(x)));
    }

    @Test
    public void basicMethods() {
        System.out.println(listSt);

        listSt.remove(2);
        System.out.println(listSt);

        System.out.println(listSt.contains("8"));
        System.out.println(listSt.contains("5"));

        listSt.set(0, "9");
        System.out.println(listSt);

        System.out.println(listSt.indexOf("3"));
        System.out.println(listSt.indexOf("2"));

        listSt.remove(0);
        System.out.println(listSt);
        listSt.remove("4");
        System.out.println(listSt);
    }

    @Test
    public void withLambdas() {
        listSt.forEach(System.out::println);

        System.out.println("print sorted values (remember it filters strings):");
        listSt.set(0, "11");
        listSt.set(5, "55");
        listSt
                .stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("all less than 10 print:");
        listSt.stream()
                .filter(x -> Integer.parseInt(x) < 10)
                .forEach(System.out::println);
    }
}
