package streams;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FunWithFiles {

    @Test
    public void getLessThan10Val() {
        try {
            URL url = getClass().getClassLoader().getResource("testik_one.csv");
            // it could be also 'var rows = ...' but it's up to you
            assert url != null;
            Stream<String> rows = Files.lines(Paths.get(url.getPath()));
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
}
