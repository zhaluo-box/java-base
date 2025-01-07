package com.example.base.utils.io.support.words;

import lombok.NoArgsConstructor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;

/**
 * Created  on 2024-7-12 15:15:48
 *
 * @author zl
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class WordParseUtil {

    final static WordParse parse = new WordParse();

    final static Function<LineDataParseDTO, String> english = LineDataParseDTO::getEnglish;

    public static LineDataParseDTO parse(String line) {
        return parse.parse(line);
    }

    public static void printEnglish(String filePath, String descPath) throws IOException {
        Map<String, List<LineDataParseDTO>> lessonMap = parseFile(filePath);
        var count = lessonMap.values().stream().mapToLong(Collection::size).sum();
        System.out.println("count = " + count);

        lessonMap.remove("default");
        lessonMap.remove("unhandledLine");

        var count2 = lessonMap.values().stream().mapToLong(Collection::size).sum();
        System.out.println("count2 = " + count2);
        var lessonDir = new File(descPath + File.separator + "allWord" + ".txt");
        try (var writer = new BufferedWriter(new FileWriter(lessonDir, StandardCharsets.UTF_8))) {
            lessonMap.values().stream().flatMap(Collection::stream).forEach(lineDataParseDTO -> {
                try {
                    writer.write(english.apply(lineDataParseDTO));
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, List<LineDataParseDTO>> parseFile(String filePath) throws IOException {

        var file = new File(filePath);
        var reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
        String line;
        String lastLesson = "default";
        String unhandledLine = "unhandledLine";
        Map<String, List<LineDataParseDTO>> lessonMap = new LinkedHashMap<>();
        lessonMap.put(unhandledLine, new ArrayList<>());
        while ((line = reader.readLine()) != null) {

            if (parse.empty(line)) {
                continue;
            }

            // 获取课程
            if (isLessonTitle(line)) {
                lastLesson = line.trim();
                continue;
            }

            // 处理行
            var lineData = parse(line);

            if (lineData != null) {
                var lineDataParseDTOList = lessonMap.getOrDefault(lastLesson, new ArrayList<LineDataParseDTO>());
                lineDataParseDTOList.add(lineData);
                lessonMap.put(lastLesson, lineDataParseDTOList);
            } else {
                var list = lessonMap.get(unhandledLine);
                list.add(new LineDataParseDTO().setOriginalLine(line));
            }
        }

        return lessonMap;

    }

    private static void writeEnglish(String descDirPath, String lesson, List<LineDataParseDTO> lineDataParseDTOList,
                                     Function<LineDataParseDTO, String> function) {
        var lessonDir = new File(descDirPath + File.separator + lesson + ".txt");
        try (var writer = new BufferedWriter(new FileWriter(lessonDir, StandardCharsets.UTF_8))) {
            lineDataParseDTOList.forEach(lineDataParseDTO -> {
                try {
                    //                    String formatter = "%s\t------%s\t----%s\t----%s\t----%s";
                    //                    var handledLine = String.format(formatter, lineDataParseDTO.getOriginalLine(), lineDataParseDTO.getChinese(), lineDataParseDTO.getEnglish(),
                    //                                                    lineDataParseDTO.getPhonetic(), lineDataParseDTO.getLesson());

                    var handledLine = function.apply(lineDataParseDTO);
                    writer.write(handledLine);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean isLessonTitle(String line) {
        return line.contains("Lesson") || line.contains("lesson");
    }

    static class WordParse implements LineParse {

        @Override
        public LineDataParseDTO parse(String line) {
            var lineDataParseDTO = new LineDataParseDTO();
            if (empty(line)) {
                return lineDataParseDTO;
            }
            if (line.contains("[") && line.contains("]")) {
                return lineDataParseDTO.setOriginalLine(line)
                                       .setEnglish(english(line))
                                       .setChinese(chinese(line))
                                       .setSerialNum(serialNum(line))
                                       .setPhonetic(phonetic(line));
            }
            return null;
        }
    }
}
