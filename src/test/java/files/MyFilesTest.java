package files;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

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
    public void testWriteWithPath() throws IOException {
        new MyFiles().writeWithPath();
    }
}
