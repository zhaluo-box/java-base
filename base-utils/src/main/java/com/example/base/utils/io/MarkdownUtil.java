package com.example.base.utils.io;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.net.URLEncodeUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created  on 2023/7/19 16:16:32
 *
 * @author zl
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MarkdownUtil extends CharacterRecognition {

    final static String IMAGE_SIGN = "](";

    final static String LINE_BREAK = "\n";

    static final String TAB_CHARACTER = "    ";

    /**
     * 处理多个文件 对 图片等path 进行转义
     *
     * @param baseDirAbsPath   源文件夹绝对路径
     * @param targetDirAbsPath 备份的目标文件夹（最好是空文件夹）
     */
    public static void handle(String baseDirAbsPath, String targetDirAbsPath) {
        var fileDesc = FileScanner.scanFileList(baseDirAbsPath);
        doHandle(baseDirAbsPath, targetDirAbsPath, fileDesc);
    }

    /**
     * 生成大纲 markdown 文件
     */
    public static void generateOutlineMD(String baseDirAbsPath) {

        var fileDesc = FileScanner.scanFileList(baseDirAbsPath);

    }

    /**
     * 对单个文件进行处理，
     * 复制文件， 读取行数据， 识别（责任链），如果符合规则（图片）， 则进行处理， 提取（） 内部的文字， 进行trim()，进行URL.encode转义
     */
    public static void handleSingle(String filename, String newFilename) throws IOException {

        var reader = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new FileWriter(newFilename, StandardCharsets.UTF_8));

        String line;
        while ((line = reader.readLine()) != null) {

            // 如果包含图片与链接特殊符号，则进行提取
            var fromStatus = hasCharacter(line, IMAGE_SIGN);
            var endStatus = hasCharacter(line, ")");

            if (!(fromStatus && endStatus)) {
                writer.write(line + LINE_BREAK);
                continue;
            }

            // 增强识别度
            var linkStr = extractData(line, "(", ")");

            if (StrUtil.isBlank(linkStr) || StrUtil.startWithAnyIgnoreCase(linkStr, "http:", "https:")) {
                // 空行也需要写空字符
                writer.write(line + LINE_BREAK);
                continue;
            }

            var encodeLink = URLEncodeUtil.encode(linkStr, StandardCharsets.UTF_8);

            // 增强识别度
            var newLine = line.replace("(" + linkStr + ")", "(" + encodeLink + ")");

            writer.write(newLine + LINE_BREAK);

        }

        writer.close();
        reader.close();

    }

    /**
     * 输入文件目录为Markdown
     */
    public static void printFileDirectoryToMD(String rootFilename, String basePath, String fileName) {
        var fullName = basePath + File.separator + fileName;
        printMarkdown(fullName, FileScanner.scanFileList(rootFilename));
    }

    private static void printMarkdown(String markdownName, FileDescription topFileDesc) {

        // 创建markdown 文件
        var file = new File(markdownName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 文件处理与写入
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

    private static void doHandle(String baseDirAbsPath, String targetDirAbsPath, FileDescription fileDesc) {
        // 获取文件绝对路径，生成替换路径
        var newPath = replacePath(fileDesc.getAbsPath(), baseDirAbsPath, targetDirAbsPath);

        // 如果是文件夹，创建一个文件夹, 获取文件列表逐个处理
        if (fileDesc.isDir()) {
            // 如果文件夹不存在，则生成
            if (!FileUtil.exist(newPath)) {
                FileUtil.mkdir(newPath);
            }

            var descriptionList = fileDesc.getDescriptions();

            if (CollectionUtil.isEmpty(descriptionList)) {
                return;
            }

            descriptionList.forEach(desc -> {
                doHandle(baseDirAbsPath, targetDirAbsPath, desc);
            });

            return;
        }
        // 如果是一个md 文件，调用处理写入

        if (fileDesc.getSuffix().equalsIgnoreCase("md")) {
            try {
                handleSingle(fileDesc.getAbsPath(), newPath);
            } catch (IOException e) {
                System.err.println("e = " + e.getMessage());
            }
            return;
        }

        // 如果不是一个md 文件，直接copy
        FileUtil.copy(fileDesc.getAbsPath(), newPath, true);
    }

    /**
     * 替换前段路径
     *
     * @param sourceFileAbsPath 源文件文件的绝对路径
     * @param baseDirAbsPath    源文件夹基础路径
     * @param targetDirAbsPath  目标基础文件夹绝对路径
     * @return 替换后的文件绝对路径
     */
    private static String replacePath(String sourceFileAbsPath, String baseDirAbsPath, String targetDirAbsPath) {
        return sourceFileAbsPath.replace(baseDirAbsPath, targetDirAbsPath);
    }

}
