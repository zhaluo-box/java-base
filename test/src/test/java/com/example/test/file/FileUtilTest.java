package com.example.test.file;

import org.junit.Test;

import java.io.File;
import java.util.Collections;

public class FileUtilTest {

    @Test
    public void parseFileTest() {
        var path = "C:\\testDir\\ZLXM_19000101000000.txt";
        var testFile = new File(path);
        //        var result = FileUtil.parseFile(testFile);
        var result = FileUtil.parse(path);
        Collections.reverse(result);
        result.stream().limit(10).forEach(c -> {
            System.out.println(c.keySet().size());
            System.out.println(c);
        });
    }

    @Test
    public void delete() {
        FileUtil.deleteFileDir("C:\\testDir\\out - 副本");
    }

}