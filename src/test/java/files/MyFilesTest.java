package files;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFilesTest {

    @Test
    public void resource() {
        System.out.println(getClass().getClassLoader().getResource("."));
    }

    @Test
    public void fileLocatioInTest() throws IOException {
        File f = new File(".");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        System.out.println(f.getName());
    }


    /*
     * Here you will see only path from SRC
     * because local path here for MyFile.class will be the SRC folder
     * You will not see resources from TEST folder (module)*/
    @Test
    public void fileLocatioInSrc() throws IOException {
        new MyFiles().myLoc();
    }

    @Test
    public void readWithBuffReaderLineByLine() throws IOException {
        new MyFiles().readWithBuffReaderLineByLine();
    }

    @Test
    public void testWriteWithPathFromMain() throws IOException {
        new MyFiles().writeWithPath();
    }

    @Test(description = "this need to just understand is Path has the same path from TEST module as MAIN has")
    public void testWriteWithPathFromTest() throws IOException {
        Path p = Paths.get("test_file_from_test.txt");
        Files.write(p, "Hello from test!".getBytes());
    }

    @Test
    public void testReadWithPathes() throws IOException {
        new MyFiles().readWithPathes();
    }
}
