package org.example.open.lib.test;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * Created  on 2023/11/14 14:14:27
 *
 * @author zl
 */
public class Temp {


    @Test
    @DisplayName("导出Excel ，含有图片")
    void testExcelHasImage() throws IOException {
        FileOutputStream fileOut = null;

        //先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray

        String imgUrl = "https://img2.woyaogexing.com/2019/04/17/e7370782b0484237926113770074cd81!400x400.jpeg";
        URL url = new URL(imgUrl);
        //获取文件后缀名
        String suffix = imgUrl.substring(imgUrl.lastIndexOf(".") + 1);
        BufferedImage bufferImg = ImageIO.read(url);

        //以本地的方式图片、注释上面四行有效代码
        //        BufferedImage bufferImg = null;
        //        bufferImg = ImageIO.read(new File("D:/test.jpg"));

        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();


        //这里要注意formatName要缓存后缀名
        ImageIO.write(bufferImg, suffix, byteArrayOut);

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet1 = wb.createSheet("test picture");
        sheet1.setDefaultColumnWidth((short) 20);
        sheet1.setDefaultRowHeight((short) 2000);
        //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
        HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
        for (int i = 0; i < 10; i++) {
            //anchor主要用于设置图片的属性
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, //x缩放
                    0, // y缩放
                    1023, //最大1023
                    255, //最大255
                    (short) 4,  //于下下个参数进行定位 0开始
                    i, //在第几行
                    (short) 4, //宽度占几格 0开始
                    i //第几列
            );
//          anchor.setAnchorType(3);
            //插入图片
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));

        }
        fileOut = new FileOutputStream("D:/测试Excel.xls");
        // 写入excel文件
        wb.write(fileOut);
        System.out.println("----Excel文件已生成------");
    }


    @Test
    void testExcelHasImage2() {
        String imgUrl = "https://img2.woyaogexing.com/2019/04/17/e7370782b0484237926113770074cd81!400x400.jpeg";
        var filename = "D:/测试Excel-" + 16 + ".xlsx";

        try (var workbook = new XSSFWorkbook(); var fileOut = new FileOutputStream(filename);) {
            var sheet = workbook.createSheet("test");
            var ual = new URL(imgUrl);
            var bytes = IOUtils.toByteArray(ual.openStream());
            var picture = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);


            var drawingPatriarch = sheet.createDrawingPatriarch();
            var creationHelper = workbook.getCreationHelper();

//            sheet.setDefaultColumnWidth(20);
//            sheet.setDefaultRowHeight((short) 2000);
            Set<Short> set = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                var row = sheet.createRow(i);
                var cell = row.createCell(1);
                var clientAnchor = creationHelper.createClientAnchor();
                clientAnchor.setCol1(1);
                clientAnchor.setCol2(2);
                clientAnchor.setRow1(i);
                clientAnchor.setRow2(i + 1);

                clientAnchor.setDx1(0);
                clientAnchor.setDx2(1023);
                clientAnchor.setDy1(0);
                clientAnchor.setDy2(255);
                clientAnchor.setAnchorType(ClientAnchor.AnchorType.MOVE_DONT_RESIZE);
                var pic = drawingPatriarch.createPicture(clientAnchor, picture);
                pic.resize();

                var imageDimension = pic.getImageDimension();
//                var height = pic.getImageDimension().getHeight();
//                var width = pic.getImageDimension().getWidth();
//                row.setHeight(doubleToShort(imageDimension.getHeight()));


                int imgHeightPx = doubleToShort(imageDimension.getHeight()); // 图片高度（像素）
                float pixelsPerInch = 96.0f; // 屏幕分辨率（通常为96dpi）
                float pointsPerPixel = 72.0f / pixelsPerInch; // 点（磅）与像素的转换比例
                int heightInPoints = (int) (imgHeightPx * pointsPerPixel); // 转换为磅
                int heightInTwips = (int) (heightInPoints * 20.0f); // 转换为twips

// 设置行高
                row.setHeight((short) heightInTwips);
                set.add(doubleToShort(imageDimension.getWidth()));
                System.out.println("imageDimension.getHeight() = " + imageDimension.getHeight());
                System.out.println("imageDimension.getWidth() = " + imageDimension.getWidth());
            }

            var max = set.stream().max(Short::compare);
//            sheet.setDefaultColumnWidth(toW(max.get()));
            sheet.setColumnWidth(1, toW(max.get()));


            // 写入excel文件
            workbook.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 相对较好的一版
     */
    @Test
    void testExcelHasImage3() {
        String imgUrl = "https://img2.woyaogexing.com/2019/04/17/e7370782b0484237926113770074cd81!400x400.jpeg";
        var filename = "D:/测试Excel-" + 17 + ".xlsx";

        try (var workbook = new XSSFWorkbook(); var fileOut = new FileOutputStream(filename);) {
            var sheet = workbook.createSheet("test");
            var ual = new URL(imgUrl);
            var bytes = IOUtils.toByteArray(ual.openStream());
            var picture = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);

            var drawingPatriarch = sheet.createDrawingPatriarch();
            var creationHelper = workbook.getCreationHelper();

            sheet.setDefaultColumnWidth(20);
            sheet.setDefaultRowHeight((short) 2000);
            Set<Short> set = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                var clientAnchor = creationHelper.createClientAnchor();
                clientAnchor.setCol1(1);
                clientAnchor.setCol2(2);
                clientAnchor.setRow1(i);
                clientAnchor.setRow2(i + 1);

                clientAnchor.setAnchorType(ClientAnchor.AnchorType.MOVE_DONT_RESIZE);
                var pic = drawingPatriarch.createPicture(clientAnchor, picture);
            }

            // 写入excel文件
            workbook.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private int toW(int imgHeightPx) {
        float pixelsPerInch = 96.0f; // 屏幕分辨率（通常为96dpi）
        float pointsPerPixel = 72.0f / pixelsPerInch; // 点（磅）与像素的转换比例
        int heightInPoints = (int) (imgHeightPx * pointsPerPixel); // 转换为磅
        int heightInTwips = (int) (heightInPoints * 20.0f); // 转换为twips
        return heightInTwips;
    }

    public short doubleToShort(double input) {
        // 首先检查输入值是否在short的范围内（-32768到32767）
        if (input < Short.MIN_VALUE || input > Short.MAX_VALUE) {
            throw new IllegalArgumentException("Input out of range for short: " + input);
        }
        // 使用强制类型转换将double转换为short
        return (short) Math.floor(input);
    }

    @Test
    void testAssertImage() throws IOException {
        String imgUrl = "https://img2.woyaogexing.com/2019/04/17/e7370782b0484237926113770074cd81!400x400.jpeg";
        URL url = new URL(imgUrl);
        //获取文件后缀名
        String suffix = imgUrl.substring(imgUrl.lastIndexOf(".") + 1);
        BufferedImage bufferImg = ImageIO.read(url);

        System.out.println("bufferImg.getHeight() = " + bufferImg.getHeight());
        System.out.println("bufferImg.getWidth() = " + bufferImg.getWidth());


    }

}
