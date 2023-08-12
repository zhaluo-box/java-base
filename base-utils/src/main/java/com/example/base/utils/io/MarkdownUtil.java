package com.example.base.utils.io;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.net.URLEncodeUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
     * 转换typora markdown 格式为 obsidian 格式
     *
     * @param sourcePath    源markdown 文件路径
     * @param targetPath    目标路径
     * @param accessoryPath 目标路径的Obsidian 附件文件文件夹名称
     */
    public static void TyporaToObsidian(String sourcePath, String targetPath, String accessoryPath) {

        // 扫描文件
        var fileDesc = FileScanner.scanFileList(sourcePath);

        // 进行文件转换
        convert(sourcePath, targetPath, accessoryPath, fileDesc);

    }

    /**
     * 为了保证MD 能脱离ob 使用会在每个文件夹下面建立一个 附件文件夹
     *
     * @param sourcePath    源markdown 文件路径
     * @param targetPath    目标路径
     * @param accessoryPath 目标路径的Obsidian 附件文件文件夹名称
     * @param fileDesc      文件描述
     */
    private static void convert(String sourcePath, String targetPath, String accessoryPath, FileDescription fileDesc) {

        // 获取文件绝对路径，生成替换路径
        var newPath = replacePath(fileDesc.getAbsPath(), sourcePath, targetPath);

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

            var accessPath = newPath + File.separator + accessoryPath;

            // 如果文件夹下包含MD 文件，则进行生成，否则当前文件夹不建立附件目录

            var hasMd = descriptionList.stream().filter(d -> !d.isDir()).anyMatch(d -> d.getSuffix().equalsIgnoreCase("md"));

            // 如果文件夹不存在，则生成
            if (!FileUtil.exist(accessPath) && hasMd) {
                FileUtil.mkdir(accessPath);
            }

            descriptionList.forEach(desc -> {
                convert(sourcePath, targetPath, accessoryPath, desc);
            });

            return;
        }

        // 如果是一个md 文件，调用处理写入
        if (fileDesc.getSuffix().equalsIgnoreCase("md")) {
            try {
                doConvert(newPath, accessoryPath, fileDesc);
            } catch (IOException e) {
                System.err.println("e.getMessage() = " + e.getMessage());
            }
        }

        // 如果不是一个md 文件，不做任何处理

    }

    private static void doConvert(String newFileAbsPath, String accessoryPath, FileDescription desc) throws IOException {

        System.out.println("=====filename : " + desc.getAbsPath() + "========start !");

        String fileAbsPath = desc.getAbsPath();
        var file = new File(fileAbsPath);
        var parentFile = file.getParentFile();
        var parentFileAbsolutePath = parentFile.getAbsolutePath();
        var newFilename = hasSpecCharAndReplace(desc.getFilename(), "?", "？");

        var removeSuffixFilename = newFilename.replace(desc.getSuffix(), "");

        var newFile = new File(newFileAbsPath);
        var nParentFile = newFile.getParentFile();
        var nPparentFileAbsolutePath = nParentFile.getAbsolutePath();

        var reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new FileWriter(newFile, StandardCharsets.UTF_8));

        String line;
        int serialNum = 0;
        while ((line = reader.readLine()) != null) {

            // 对于markdown 标准图片资源识别
            // TODO 2023/8/12 还需要增加typora 缩放后的 <img src=""> 的识别，转换
            // 如果包含图片与链接特殊符号，则进行提取
            var fromStatus = hasCharacter(line, IMAGE_SIGN);
            var endStatus = hasCharacter(line, ")");
            var imageSign = hasCharacter(line, "![");

            if (!(fromStatus && endStatus && imageSign)) {
                writer.write(line + LINE_BREAK);
                continue;
            }

            // 增强识别度
            var linkStr = extractData(line, "](", ")");

            // 保存原始图片链接，因为下面会解码
            var originLinkStr = linkStr;

            linkStr = decodeLink(linkStr);

            if (StrUtil.isBlank(linkStr) || StrUtil.startWithAnyIgnoreCase(linkStr, "http:", "https:", "note:")) {
                // 空行也需要写空字符
                writer.write(line + LINE_BREAK);
                continue;
            }

            // link 转换为绝对路径 找到附件，并将附件移动到指定目录
            // 如果不是绝对路径，
            String normalLinkStr = linkStr;
            if (!FileUtil.isAbsolutePath(linkStr)) {
                System.out.println("linkStr = " + linkStr);
                normalLinkStr = FileUtil.normalize(parentFileAbsolutePath + File.separator + linkStr.trim());
                System.out.println("normalLinkStr = " + normalLinkStr);
            }

            var suffix = FileUtil.getSuffix(normalLinkStr);

            ++serialNum;

            // 转换为 ./accessory/filename+ serialNum + fileSuffix
            var newLink = accessoryPath + "/" + removeSuffixFilename + serialNum + "." + suffix;

            System.err.println("newLink = " + newLink);

            FileUtil.copy(URLDecoder.decode(normalLinkStr, StandardCharsets.UTF_8), nPparentFileAbsolutePath + File.separator + newLink, true);

            var encodeLink = encodeLink(newLink);

            // 增强识别度
            var newLine = line.replace("(" + originLinkStr + ")", "(" + encodeLink + ")");

            writer.write(newLine + LINE_BREAK);

        }

        writer.close();
        reader.close();

        System.out.println("=====filename : " + desc.getAbsPath() + "========end !" + LINE_BREAK + LINE_BREAK);
    }

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
     * 生成大纲 markdown 文件, 默认生成tab 与link  encode
     */
    public static void generateOutlineMD(String baseDirAbsPath, String mdFilePath) {
        generateOutlineMD(baseDirAbsPath, mdFilePath, true, true);
    }

    /**
     * 生成大纲 markdown 文件
     */
    public static void generateOutlineMD(String baseDirAbsPath, String mdFilePath, boolean encode, boolean tab) {

        var fileDesc = FileScanner.scanFileList(baseDirAbsPath);

        // 第一级肯定是根目录
        var descriptions = fileDesc.getDescriptions();

        if (CollectionUtil.isEmpty(descriptions)) {
            return;
        }

        List<TitleDefinition> cache = new ArrayList<>(256);

        parseFileOutline(baseDirAbsPath, descriptions, cache);

        try (var writer = new BufferedWriter(new FileWriter(mdFilePath, StandardCharsets.UTF_8))) {
            // 开头避免出现没有一级的情况
            writer.write("- outline" + LINE_BREAK);
            // 处理内容
            cache.forEach(title -> {
                String content = buildTitleContent(title, encode, tab);
                try {
                    writer.write(content);
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            });

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    private static String buildTitleContent(TitleDefinition title) {
        return buildTitleContent(title, true, true);
    }

    private static String buildTitleContent(TitleDefinition title, boolean encode, boolean tab) {
        String link = encode ? URLEncodeUtil.encode(title.getLink()) : title.getLink();
        var content = String.format("[%s](%s)", title.name, link);
        var tabStr = tab ? TAB_CHARACTER.repeat(title.getLevel() - 1) : "";
        content = tabStr + "- " + content + LINE_BREAK;
        return content;
    }

    /**
     * 解析文件大纲
     *
     * @param baseDirAbsPath 根路径
     * @param descriptions   文件描述列表
     * @param cache          缓存 ==》 大纲放入缓存
     */
    public static void parseFileOutline(String baseDirAbsPath, List<FileDescription> descriptions, List<TitleDefinition> cache) {
        if (CollectionUtil.isEmpty(descriptions)) {
            return;
        }
        descriptions.forEach(desc -> {
            if ("md".equalsIgnoreCase(desc.getSuffix())) {
                var level = desc.getLevel();
                var prefixPath = getPrefixPath(baseDirAbsPath, desc.getAbsPath(), level);
                var finalPath = prefixPath + desc.getFilename();

                var titleDefinition = new TitleDefinition().setLink(finalPath).setName(desc.getFilename()).setLevel(level);
                cache.add(titleDefinition);
            }

            if (desc.isDir()) {
                parseFileOutline(baseDirAbsPath, desc.getDescriptions(), cache);
            }

            // 其他类型文件不处理
        });
    }

    public static String getPrefixPath(String rootPath, String absPath, int level) {
        var path = absPath.replace(rootPath, "");
        var split = path.split("\\\\");

        var builder = new StringBuilder("." + File.separator);

        if (level == 1) {
            return builder.toString();
        }

        for (int i = 0; i < level - 1; i++) {
            builder.append(split[i]).append(File.separator);
        }

        return builder.toString();
    }

    /**
     * 对单个文件进行处理，
     * 复制文件， 读取行数据， 识别（责任链），如果符合规则（图片）， 则进行处理， 提取（） 内部的文字， 进行trim()，进行URL.encode转义
     */
    public static void handleSingle(String fileAbsPath, String newFileAbsPath) throws IOException {

        var reader = new BufferedReader(new FileReader(fileAbsPath, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new FileWriter(newFileAbsPath, StandardCharsets.UTF_8));

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

    @Data
    @Accessors(chain = true)
    public static class TitleDefinition {

        private String name;

        private String link;

        private int level;
    }

}
