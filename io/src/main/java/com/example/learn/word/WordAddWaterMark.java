package com.example.learn.word;

import com.spire.doc.Document;
import com.spire.doc.TextWatermark;
import com.spire.doc.documents.WatermarkLayout;

/**
 * word 文件添加水印
 * 暂时没有发现API 哪里支持定义水印的位置
 * Created  on 2022/5/24 09:9:29
 *
 * @author zl
 * @link https://blog.csdn.net/mnrssj/article/details/118995297
 */
public class WordAddWaterMark {

    public static void main(String[] args) {
        addWatermark1();
    }

    /**
     * 添加水印1
     */
    private static void addWatermark1() {
        // Load the Word document
        Document doc = new Document("D:\\tmp-dir\\水印测试.docx");

        TextWatermark textWatermark = new TextWatermark();
        textWatermark.setText("SKH-20220523-1");
        textWatermark.setFontSize(16);
        textWatermark.setFontName("Arial");
        textWatermark.setLayout(WatermarkLayout.Diagonal);
        textWatermark.setSemitransparent(true);

        doc.setWatermark(textWatermark);

        var targetPath = "D:\\tmp-dir\\" + System.currentTimeMillis() + "水影测试XXX.docx";
        doc.saveToFile(targetPath);

    }
}
