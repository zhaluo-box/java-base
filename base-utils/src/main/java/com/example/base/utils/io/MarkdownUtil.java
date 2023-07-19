package com.example.base.utils.io;

import cn.hutool.core.util.StrUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Created  on 2023/7/19 16:16:32
 *
 * @author zl
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MarkdownUtil extends CharacterRecognition {

    final static String IMAGE_SIGN = "](";

    /**
     * 对单个文件进行处理，
     * 复制文件， 读取行数据， 识别（责任链），如果符合规则（图片）， 则进行处理， 提取（） 内部的文字， 进行trim()，进行URL.encode转义
     */

    public static void handleSingle(String filename) throws IOException {

        var file = new File(filename);

        var reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new FileWriter(new File(""), StandardCharsets.UTF_8));

        String line;
        while ((line = reader.readLine()) != null) {

            // 如果包含图片与链接特殊符号，则进行提取
            var b = hasCharacter(line, IMAGE_SIGN);

            var linkStr = extractData(line, "(", ")");

            if (StrUtil.isBlank(linkStr) || StrUtil.startWithAnyIgnoreCase(linkStr, "http:", "https:")) {
                // 空行也需要写空字符
                writer.write(line);
                continue;
            }

            var encodeLink = URLEncoder.encode(linkStr, StandardCharsets.UTF_8);

            var newLine = line.replace(linkStr, encodeLink);
            writer.write(newLine);

        }

        writer.close();
        reader.close();

    }
}
