package org.example.open.lib.learn.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件类型判定工具类
 * 只是简单的通过文件后缀去判断是什么类型
 * 目前只支持  图片,word文档,excel文档,pdf文档
 * TODO 后期考虑继承 hu-tools FileTypeUtil
 * Created  on 2022/4/19 13:13:44
 *
 * @author wmz
 */
public final class FileTypeUtil {

    /**
     * 图片文件后缀
     */
    public static final String[] IMAGE_SUFFIX = new String[] { "jpg", "jpeg", "png" };

    /**
     * word 文档文件后缀
     */
    public static final String[] WORD_SUFFIX = new String[] { "doc" };

    /**
     * pdf 文档文件后缀
     */
    public static final String[] PDF_SUFFIX = new String[] { "pdf" };

    /**
     * excel 文档后缀
     */
    public static final String[] EXCEL_SUFFIX = new String[] { "xls", "xlsx", "csv" };

    /**
     * 文件类型
     */
    private static final Map<String, FileType> FILE_TYPE_POOL = new HashMap<>();

    private FileTypeUtil() {

    }

    static {
        // init image
        for (String imageSuffix : IMAGE_SUFFIX) {
            FILE_TYPE_POOL.put(imageSuffix, FileType.IMAGE);
        }
        // init word
        for (String wordSuffix : WORD_SUFFIX) {
            FILE_TYPE_POOL.put(wordSuffix, FileType.WORD);
        }
        // init pdf
        for (String pdfSuffix : PDF_SUFFIX) {
            FILE_TYPE_POOL.put(pdfSuffix, FileType.PDF);
        }
        // init excel
        for (String excelSuffix : EXCEL_SUFFIX) {
            FILE_TYPE_POOL.put(excelSuffix, FileType.EXCEL);
        }
    }

    /**
     * 文件类型
     * Created  on 2022/4/15 09:9:18
     *
     * @author wmz
     */
    public enum FileType {

        IMAGE, WORD, EXCEL, PDF, OTHER

    }
}
