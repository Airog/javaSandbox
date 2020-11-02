package helpers;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PathHelper {

    public URL getUrlToFile(String fname) {
        return getClass().getClassLoader().getResource(fname);
    }

    public Stream<String> getFileStream(String fname) throws IOException {
        return Files.lines(Paths.get(getUrlToFile(fname).getPath()));
    }

    public String getFromRes(String path) {
        return getUrlToFile(path).getPath();
    }
}
