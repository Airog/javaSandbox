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

    /*
    * java.io.File - used mainly before java 7,
    * since java 7 we have java.nio.file.Path and java.nio.file.Paths
    * which allow us to make read and write files/dirs easier and wrile less code on it
    * */

    public void myLoc() throws IOException {
        File f = new File("");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        System.out.println(f.getName());
    }

    public void readWithPathes() throws IOException {
        var path = Paths.get(new PathHelper().getFromRes("bash_history.txt"));

        /* Three different ways to get content from file */
        var fileContent1 = Files.readString(path);
        System.out.println(fileContent1);

        var fileContent2 = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        System.out.println(fileContent2);
        var fileContent3 = Files.readAllLines(path);
        fileContent3.forEach(System.out::println);


    }

    public void readWithBuffReaderLineByLine() {
        // absolute path
//        Path path = Paths.get("/home/suser/IdeaProjects/sandboxJava/src/main/resources/bash_history.txt");
        // this is not working, don't know why...shit...
//        Path path = Paths.get("bash_history.txt");
        Path path = Paths.get(new PathHelper().getFromRes("bash_history.txt"));

        Charset chSet = StandardCharsets.UTF_8;

        BufferedReader br;
        LineNumberReader lineReader;
        String line;

        try {
            br = Files.newBufferedReader(path, chSet);
            lineReader = new LineNumberReader(br);

            while ((line = lineReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeWithPath() throws IOException {
        Path p = Paths.get("test_file_from_main.txt");
        Files.write(p, "Hello!".getBytes());
    }
}
