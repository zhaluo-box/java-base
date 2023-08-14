package org.example.open.lib.learn.util;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.TextWatermark;
import com.spire.doc.documents.WatermarkLayout;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * 基于Spire.Doc.Free 进行添加水印
 * Created  on 2023/8/14 10:10:52
 *
 * @author zl
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WordUtil {

    /**
     * 添加水印
     */
    public static void addWaterMark(URL url, OutputStream outputStream, String waterMark) throws IOException, FontFormatException {
        var inputStream = url.openStream();
        doAddWatermark(outputStream, waterMark, inputStream);
    }

    public static void addWaterMark(InputStream inputStream, OutputStream outputStream, String waterMark) throws IOException, FontFormatException {
        doAddWatermark(outputStream, waterMark, inputStream);
    }

    private static void doAddWatermark(OutputStream outputStream, String waterMark, InputStream inputStream) throws FileNotFoundException {
        try (inputStream; outputStream) {
            // Load the Word document
            Document doc = new Document(inputStream);
            TextWatermark textWatermark = new TextWatermark();
            textWatermark.setText(waterMark);
            textWatermark.setFontSize(16);
            textWatermark.setLayout(WatermarkLayout.Diagonal);
            textWatermark.setSemitransparent(true);
            doc.setWatermark(textWatermark);

            doc.saveToStream(outputStream, FileFormat.Docx);
        } catch (Exception e) {
            throw new RuntimeException("word 添加水印失败", e);
        }
    }

}

