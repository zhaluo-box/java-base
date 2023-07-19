package com.example.base.utils.io;

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
public final class FileUtil implements FileScanner {

    private static final String TAB_CHARACTER = "    ";

    /**
     * 输入文件目录为Markdown
     */
    public static void printFileDirectoryToMD(String rootFilename, String basePath, String fileName) {
        var fullName = basePath + File.separator + fileName;
        printMarkdown(fullName, FileScanner.scanFileList(rootFilename));
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

}
