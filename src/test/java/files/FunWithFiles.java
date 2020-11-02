package files;

import helpers.PathHelper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunWithFiles {

    private PathHelper path = new PathHelper();

    @Test
    public void getLessThan10Val() {
        try {

            // it could be also 'var rows = ...' but it's up to you
            Stream<String> rows = Files.lines(Paths.get(path.getFromRes("testik_one.csv")));
            rows
                    .map(x -> x.split(","))
                    .filter(x -> x.length == 3)
                    // probably you could split this expression but...again - up to you
                    .filter(x -> !x[1].equals(null) && !x[1].equals(""))
                    .filter(x -> Integer.parseInt(x[1]) < 10)
                    .forEach(x -> System.out.println(x[0] + " | " + x[1] + " | " + x[2]));
            rows.close();
        } catch (IOException e) {
            System.err.println("Looks like we missed a file:\n" + e);
        } catch (java.lang.NumberFormatException e) {
            System.err.println("NumberFormatException again\n\n" + e);
        }
    }

    /*
     * you can use '@Test(expectedExceptions = IOException.class)' if you sure on 100% that
     * you will get the exception 'cause if you will not get it then
     * you will get exception about you haven't got expected exception...funny
     * */
    @Test()
    public void fileToMap() throws IOException {
        Stream<String> rows = Files.lines(
                Paths.get(path.getUrlToFile("forMapCorrect.txt").getPath()));
        var resultMap = rows.map(x -> x.split(","))
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> x[1]
                ));
        rows.close();

        // yoou can do like this:
        resultMap.forEach((x, y) -> System.out.println("Key: " + x + ", Value: " + y));

        //or like this (same result):
        resultMap
                .entrySet()
                .stream()
                .forEach(x -> System.out.println("Key: " + x.getKey() + ", Value: " + x.getValue()));
    }

    @Test()
    public void fileToMapIncorrectFile() throws IOException {
        Stream<String> rows = Files.lines(Paths.get(new PathHelper().getFromRes("forMapIncorrect.txt")));
        var resultMap = rows.map(x -> x.split(","))
                // find only letters
                .filter(x -> x[1].matches("^[a-zA-Z]+$"))
                .collect(Collectors.toMap(
                        x -> Integer.parseInt(x[0]),
                        x -> x[1]
                ));
        rows.close();

        resultMap.forEach((x, y) -> System.out.println("Key: " + x + ", Value: " + y));
    }
}
