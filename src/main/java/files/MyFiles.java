package files;

import helpers.PathHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFiles {

    public void myLoc() throws IOException {
        File f = new File("./bash_history.txt");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        System.out.println(f.getName());
    }

    public void readWithBuffReaderLineByLine() {
        // I don't know why this way isn't working
//        Path path = Paths.get("/home/suser/IdeaProjects/sandboxJava/src/main/java/resources/bash_history.txt");
        // this either...shit...
//        Path path = Paths.get("bash_history.txt");
        Path path = Paths.get(new PathHelper().getUrlToFile("bash_history.txt").getPath());
        Charset chSet = StandardCharsets.UTF_8;

        BufferedReader br;
        LineNumberReader lineReader;
        String line;

        try {
            br = Files.newBufferedReader(path, chSet);
            lineReader = new LineNumberReader(br);

            while((line = lineReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
