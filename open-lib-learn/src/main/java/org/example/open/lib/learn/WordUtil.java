package org.example.open.lib.learn;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created  on 2023/7/28 13:13:49
 *
 * @author zl
 */
public class WordUtil {

    public static void main(String[] args) {
        //        var wordWaterMarker = new WordWaterMarker("水印测试 聚能峰");
        //
        //        var path = "D:\\tmp-dir\\SVN使用操作手册V.0.1.docx";
        //        //        var path2 = "D:\\tmp-dir\\SVN使用操作手册V.0.2.docx";
        //        //                var path = "D:\\tmp-dir\\123456.docx";
        //        //        var path = "D:\\tmp-dir\\SD_201_客户主数据创建接口_技术说明_V1.0.docx";
        //        var path2 = "D:\\tmp-dir\\7553.docx";
        //
        //        try {
        //            var fileInputStream = new FileInputStream(path);
        //            var outputStream = new FileOutputStream(path2, true);
        //            wordWaterMarker.makeSlopeWaterMark(fileInputStream, outputStream);
        //        } catch (FileNotFoundException e) {
        //            System.err.println("e.getMessage() = " + e.getMessage());
        //        }

        try {
            // 读取现有的 docx 文档
            var path = "D:\\tmp-dir\\SD_201_客户主数据创建接口_技术说明_V1.0.docx";
            var path2 = "D:\\tmp-dir\\x-222.docx";
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument document = new XWPFDocument(fis);

            // 添加水印到每一个段落后面
            for (int i = 0; i < document.getParagraphs().size(); i++) {
                XWPFParagraph watermarkParagraph = document.getParagraphs().get(i);
                if (watermarkParagraph == null) {
                    watermarkParagraph = document.createParagraph();
                }

                String watermarkText = "12321313123123212312312";
                XWPFRun watermarkRun = watermarkParagraph.createRun();
                watermarkRun.setText(watermarkText);
                watermarkRun.setBold(true);
                watermarkRun.setFontSize(20);
                watermarkRun.setColor("CC0000");
            }

            // 保存修改后的文档
            FileOutputStream fos = new FileOutputStream(path2);
            document.write(fos);
            fos.close();

            System.out.println("水印已成功添加到文档每一页。");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
