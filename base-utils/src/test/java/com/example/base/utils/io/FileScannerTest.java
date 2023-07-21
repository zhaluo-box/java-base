package com.example.base.utils.io;

import cn.hutool.json.JSONUtil;
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
        //        System.out.println("fileDescription = " + fileDescription);
        System.out.println(fileDescription.getAbsPath());
        var jsonStr = JSONUtil.toJsonStr(fileDescription);

        System.out.println(jsonStr);

    }

    @Test
    void scanFile() {
    }
}
