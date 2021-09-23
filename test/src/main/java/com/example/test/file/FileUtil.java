package com.example.test.file;

import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileUtil {

    private static final String LINE_SEPARATOR = "\t";

    public static void deleteFileDir(String path) {
        var file = new File(path);
        if (recursionDelete(file)) {
            System.out.println(path + "文件已经删除!");
        }
    }

    private static boolean recursionDelete(File file) {
        if (file.isDirectory()) {
            String[] children = file.list();
            //递归删除目录中的子目录下
            var files = file.listFiles();
            for (File f : files) {
                boolean success = recursionDelete(f);
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        boolean result = file.delete();
        if (result) System.out.println(file.getAbsolutePath() + " 已删除");
        return result;
    }

    @SneakyThrows
    public static String unZip(String filePath, String descPath) {
        File srcFile = new File(filePath);
        descPath = descPath + File.separator + getMidPath(filePath);
        // 创建压缩文件对象
        @Cleanup ZipFile zipFile = new ZipFile(srcFile);
        // 开始解压
        Enumeration<?> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            // 如果是文件夹，就创建个文件夹
            if (entry.isDirectory()) {
                srcFile.mkdirs();
            } else {
                // 如果是文件，就先创建一个文件，然后用io流把内容copy过去
                File targetFile = new File(descPath + File.separator + entry.getName());
                // 保证这个文件的父文件夹必须要存在
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                targetFile.createNewFile();
                @Cleanup InputStream is = zipFile.getInputStream(entry);
                @Cleanup FileOutputStream fos = new FileOutputStream(targetFile);
                int len;
                byte[] buf = new byte[1024];
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
            }
        }
        srcFile.delete();
        return descPath;
    }

    private static String getMidPath(String filePath) {
        return filePath.substring(filePath.lastIndexOf(File.separator), filePath.lastIndexOf("."));
    }

    /**
     * 解析文件, 每列以”制表符“ 分割。
     */
    @SneakyThrows
    public static List<Map<String, Object>> parseFile(File file) {
        var result = new ArrayList<Map<String, Object>>();
        // 动态生成字段名
        var titles = generateFields(102);
        @Cleanup BufferedReader br = new BufferedReader(new FileReader(file, Charset.forName("GBK")));
        var rownum = 0;
        while (br.read() != -1) {
            rownum++;
            var rowMap = new HashMap<String, Object>(102);
            var line = br.readLine();
            var rowData = line.split(LINE_SEPARATOR);
            if (rowData.length > titles.length) System.out.println("维护的数据库字段属性个数与下载文件目录中的不一致! 行号" + rownum);
            for (int i = 0; i < rowData.length; i++) {
                var title = titles[i];
                Object value = rowData[i];
                // 目前只有日期数据需要转换, 其他都是字符串
                rowMap.put(title.trim(), value);
            }
            result.add(rowMap);
        }
        return result;
    }

    @SneakyThrows
    public static List<Map<String, Object>> parse(String path) {
        //        var type = variables.get(Constant.CATALOGUE_NUM);
        //        var fieldSize = LIST_COLUMN_SIZE_MAP.get(type);
        // 动态生成字段名
        var fieldSize = 102;
        var titles = generateFields(102);
        // 字符集, 默认字符集GBK, 界面有配置优先界面配置的字符集
        //        var configCharset = variables.get(CHARSET);
        //        var charsetName = StringUtils.hasLength(configCharset) ? configCharset : DEFAULT_CHARSET_FOR_GBK;
        @Cleanup var lines = Files.lines(Path.of(path), Charset.forName("GBK"));
        return lines.map(line -> {
            var rowMap = new HashMap<String, Object>(fieldSize);
            var rowData = line.split(LINE_SEPARATOR);
            if (rowData.length > fieldSize) {
                System.out.println("单行解析出来的字段个数多余数据库配置的字段个数, 行号:" + "rowNum" + " 数据库字段个数:  " + fieldSize + " 单行解析个数 : " + rowData.length);
            }
            for (int i = 0; i < rowData.length; i++) {
                rowMap.put(titles[i].trim(), rowData[i]);
            }
            return rowMap;
        }).collect(Collectors.toList());
    }

    /**
     * @param fieldSize 字段个数
     */
    private static String[] generateFields(int fieldSize) {
        var fields = new String[fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            var value = strFormat(i + 1, String.valueOf(fieldSize).length());
            fields[i] = "S" + value;
        }
        return fields;
    }

    /**
     * 字符串格式化.
     *
     * @param i   当前索引
     * @param len 长度
     */
    private static String strFormat(int i, int len) {
        var tmp = String.valueOf(i);
        var standardLength = Math.max(len, 2);
        // 数字转字符串
        // 如果字符串长度不足, 则前面补零
        var offset = standardLength - tmp.length();
        if (offset <= 0) {
            return i + "";
        }
        return "0".repeat(offset) + i;
    }

}
