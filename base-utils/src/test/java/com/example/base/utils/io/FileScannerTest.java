package com.example.base.utils.io;

import org.junit.jupiter.api.Test;

/**
 * Created  on 2023/7/20 16:16:54
 *
 * @author zl
 */
class FileScannerTest {

    @Test
    void scanFileList() {
        var fileDescription = FileScanner.scanFileList("D:\\tmp-dir\\docs\\");
        System.out.println("fileDescription = " + fileDescription);
    }

    @Test
    void scanFile() {
    }
}
