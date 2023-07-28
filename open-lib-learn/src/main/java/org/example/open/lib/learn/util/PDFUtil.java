package org.example.open.lib.learn.util;

import org.apache.fontbox.ttf.OTFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;
import org.springframework.util.ResourceUtils;

import java.awt.*;
import java.io.File;
import java.util.UUID;

/**
 * Created  on 2023/7/28 09:9:25
 *
 * @author zl
 */
public class PDFUtil {

    public static void main(String[] args) {
        try {
            watermark(new File("D:\\tmp-dir\\AGPL v3 开源协议.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param file
     * @throws Exception {@link <a href="https://juejin.cn/post/6844903880841527304">文章出处</a>}
     */
    private static void watermark(File file) throws Exception {
        //创建新pdf文件
        File tmpPDF = new File("D:\\tmp-dir\\" + UUID.randomUUID() + "-" + file.getName());
        //打开pdf文件
        PDDocument doc = PDDocument.load(file);
        doc.setAllSecurityToBeRemoved(true);
        //遍历pdf所有页
        for (PDPage page : doc.getPages()) {
            PDPageContentStream cs = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true, true);
            String watermark = "03 水印测试";
            var inputStream = ResourceUtils.getURL("classpath:otf/SourceHanSerifSC-Bold.otf").openStream();

            var otfParser = new OTFParser();
            var otf = otfParser.parse(inputStream);

            //引入字体文件 解决中文汉字乱码问题
            PDFont font = PDType0Font.load(doc, otf, false);

            float fontSize = 25;
            //            PDResources resources = page.getResources();
            PDExtendedGraphicsState r0 = new PDExtendedGraphicsState();
            // 水印透明度
            r0.setNonStrokingAlphaConstant(0.2f);
            r0.setAlphaSourceFlag(true);
            cs.setGraphicsStateParameters(r0);
            //水印颜色
            //            cs.setNonStrokingColor(200, 0, 0);

            cs.setNonStrokingColor(Color.blue);
            cs.beginText();
            cs.setFont(font, fontSize);
            //根据水印文字大小长度计算横向坐标需要渲染几次水印
            float h = watermark.length() * fontSize;

            int x = 100; // 水印的横向间距
            int theta = -150;
            for (int i = 0; i <= 10; i++) {
                // 获取旋转实例
                cs.setTextMatrix(Matrix.getRotateInstance(theta, i * x, 0));
                cs.showText(watermark);
                for (int j = 0; j < 20; j++) {
                    cs.setTextMatrix(Matrix.getRotateInstance(theta, i * x, j * h));
                    cs.showText(watermark);
                }
            }
            cs.endText();
            cs.restoreGraphicsState();
            cs.close();
        }
        doc.save(tmpPDF);
    }

}
