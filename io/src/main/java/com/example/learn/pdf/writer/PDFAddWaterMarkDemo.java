package com.example.learn.pdf.writer;

import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;

/**
 * PDF 添加水印测试
 * Created  on 2022/5/23 14:14:10
 *
 * @author zl
 */
public class PDFAddWaterMarkDemo {

    public static void main(String[] args) {
        String sourcePath = "D:\\note\\待整理\\[自控力].(How.Self-control.Works).凯利·麦格尼格尔.扫描版.[PDF].pdf";
        var targetPath = "D:\\tmp-dir\\" + System.currentTimeMillis() + "水影测试XXX.pdf";
        var sourcePath2 = "D:\\tmp-dir\\" + "水印测试.pdf";
        addWaterMark(sourcePath2, targetPath);
    }

    /**
     * @description 给PDF文档添加水印
     * @author TianwYam
     * @date 2021年4月28日上午10:00:05
     */
    public static void addWaterMark(String pdfFilePath, String outputFilePath) {

        try {
            //            File file = new File(pdfFilePath);
            //            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            //            File file = new File(pdfFilePath);
            //            if (file.exists()) {
            //                System.out.println("文件存在" + file.getName());
            //            }

            //            PdfReader reader = new PdfReader(new FileInputStream(file));
            // 原PDF文件
            PdfReader reader = new PdfReader(pdfFilePath);
            // 输出的PDF文件内容
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputFilePath));

            // 字体 来源于 itext-asian JAR包
            BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", true);

            PdfGState gs = new PdfGState();
            // 设置透明度
            gs.setFillOpacity(0.1f);
            gs.setStrokeOpacity(0.1f);

            int totalPage = reader.getNumberOfPages() + 1;
            for (int i = 1; i < totalPage; i++) {
                // 内容上层
                // PdfContentByte content = stamper.getOverContent(i);
                // 内容下层
                PdfContentByte content = stamper.getUnderContent(i);

                content.beginText();
                // 字体添加透明度
                content.setGState(gs);
                // 添加字体大小等
                content.setFontAndSize(baseFont, 16);

                // 添加范围
                //                content.setTextMatrix(100, 100);
                // 具体位置 内容 旋转多少度 共360度
                content.showTextAligned(Element.ALIGN_LEFT, "KZH-2020522-1", 10, 10, 0);
                //                content.showTextAligned(Element.ALIGN_CENTER, "机密文件", 10, 10, 0);
                //                content.showTextAligned(Element.ALIGN_BOTTOM, "机密文件", 10, 10, 0);

                content.endText();
            }

            // 关闭
            stamper.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
