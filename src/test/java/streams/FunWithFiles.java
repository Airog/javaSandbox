package streams;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FunWithFiles {

    @Test
    public void getLessThan10Val() {
        try {
            // it could be also 'var rows = ...' but it's up to you
            Stream<String> rows = Files.lines(Paths.get("test.csv"));
            rows
                    .map(x -> x.split(","))
                    .filter(x -> x.length == 3)
                    // probably you could split this expression but...again - up to you
                    .filter(x -> !x[1].equals(null) && !x[1].equals(""))
                    .filter(x -> Integer.parseInt(x[1]) < 10)
                    .forEach(x -> System.out.println(x[0] + " | " + x[1] + " | " + x[2]));
            rows.close();
        } catch (IOException e) {
            System.err.print(e);
        } catch (java.lang.NumberFormatException e) {
            System.err.println("NumberFormatException again\n\n" + e);
        }
    }
}
