package org.example.open.lib.test.util;

import org.example.open.lib.learn.util.WordUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created  on 2023/8/14 13:13:42
 *
 * @author zl
 */
class WordUtilTest {

    @Test
    @DisplayName("word 文件添加水印")
    void addWaterMark() throws IOException, FontFormatException {
        String docPath = "D:\\tmp-dir\\SD_201_客户主数据创建接口_技术说明_V1.0.docx";
        String outPath = "D:\\tmp-dir\\SD_201_客户主数据创建接口_技术说明_V2.0.docx";

        var fileInputStream = new FileInputStream(docPath);
        var fileOutputStream = new FileOutputStream(outPath);

        WordUtil.addWaterMark(fileInputStream, fileOutputStream, "那时，天下人的口音，言语都是一样的");
    }
}
