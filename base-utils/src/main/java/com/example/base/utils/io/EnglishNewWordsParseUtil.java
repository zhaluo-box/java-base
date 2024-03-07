package com.example.base.utils.io;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Created  on 2024-3-6 16:16:36
 *
 * @author zl
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnglishNewWordsParseUtil {

    public static void parse(String path, String desc) throws IOException {

        var file = new File(path);
        var newFile = new File(desc);
        var reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new FileWriter(newFile, StandardCharsets.UTF_8));

        String line;
        int serialNum = 0;

        var words = new ArrayList<String>();
        var phoneticList = new ArrayList<String>();
        var chineseList = new ArrayList<String>();

        while ((line = reader.readLine()) != null) {

            //            writer.write(newLine + LINE_BREAK);

            var strings = line.split("\\[");

            var pre = strings[0];
            var pre1 = pre.split(" ");
            var suf = strings[1];

            var strings2 = suf.split("]");

            var english = pre1[1];
            var phonetic = "\\[" + strings2[0].trim() + "]";
            var chinese = strings2[1].trim();

            //            var english = strings[1];
            //            var phonetic = strings[2];
            //            var chinese = strings[3];
            words.add(english);
            phoneticList.add(phonetic);
            chineseList.add(chinese);
        }

        words.add("---------");
        words.addAll(chineseList);
        words.add("---------");
        words.addAll(phoneticList);

        words.forEach(x -> {
            try {
                writer.write(x);
                writer.newLine();
            } catch (IOException e) {
                throw new RuntimeException("单词写入异常", e);
            }
        });

        writer.close();
        reader.close();
    }

}
