package com.example.base.learn.io.utils;

import com.example.base.learn.io.FileDescription;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created  on 2022/9/16 14:14:37
 *
 * @author zl
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileUtil {

    private static final String TAB_CHARACTER = "    ";

    /**
     * 输入文件目录为Markdown
     */
    public static void printFileDirectoryToMD(String rootFilename, String basePath, String fileName) {
        var fullName = basePath + File.separator + fileName;
        printMarkdown(fullName, scanFileList(rootFilename));
    }

    public static FileDescription scanFileList(String rootFilename) {
        var rootFile = new File(rootFilename);
        if (!rootFile.isDirectory()) {
            throw new RuntimeException("扫描的根目录必须是一个文件夹");
        }
        var fileDesc = new FileDescription();
        fileDesc.setDir(true).setFilename(rootFile.getName());
        var descriptions = fileDesc.getDescriptions();
        var files = rootFile.listFiles();
        if (files != null) {
            scanFile(descriptions, files, 0);
        }
        return fileDesc;
    }

    private static void printMarkdown(String markdownName, FileDescription topFileDesc) {

        var file = new File(markdownName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (var bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            var content = buildContent(topFileDesc);
            var childFileDesc = topFileDesc.getDescriptions();
            bufferedWriter.write(content);
            contentHandler(bufferedWriter, childFileDesc);

        } catch (IOException e) {
            throw new RuntimeException("文件输出异常", e);
        }

    }

    private static void contentHandler(BufferedWriter bufferedWriter, List<FileDescription> descriptions) {
        descriptions.forEach(desc -> {
            try {
                bufferedWriter.write(buildContent(desc));
                // 处理子文件夹
                if (desc.isDir()) {
                    contentHandler(bufferedWriter, desc.getDescriptions());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static String buildContent(FileDescription description) {
        var tab = TAB_CHARACTER.repeat(description.getLevel());
        return String.format("\n%s- %s", tab, description.getFilename());
    }

    private static void scanFile(List<FileDescription> descriptions, File[] files, int level) {
        if (files == null) {
            return;
        }

        //        Stream.of(files).sorted(Comparator.comparing(File::getName)).forEach(file -> {
        //            var fileDescription = new FileDescription();
        //            var isDir = file.isDirectory();
        //            fileDescription.setFilename(file.getName()).setDir(isDir).setLevel(level);
        //            descriptions.add(fileDescription);
        //            if (isDir) {
        //                scanFile(fileDescription.getDescriptions(), file.listFiles(), level + 1);
        //            }
        //        });
        for (File file : files) {
            var fileDescription = new FileDescription();
            var isDir = file.isDirectory();
            fileDescription.setFilename(file.getName()).setDir(isDir).setLevel(level);
            descriptions.add(fileDescription);
            if (isDir) {
                scanFile(fileDescription.getDescriptions(), file.listFiles(), level + 1);
            }
        }
    }
}
