package com.example.test.file;

import org.junit.Test;

import java.io.File;
import java.util.Collections;

public class FileUtilTest {

    @Test
    public void parseFileTest() {

        var testFile = new File("C:\\testDir\\ZLXM_19000101000000.txt");
        var result = FileUtil.parseFile(testFile);
        Collections.reverse(result);
        result.stream().limit(10).forEach(c -> {
            System.out.println(c.toString());
        });
    }

}