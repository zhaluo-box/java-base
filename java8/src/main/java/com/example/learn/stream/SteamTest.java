package com.example.learn.stream;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamTest {

    @SneakyThrows
    public static void main(String[] args) {
        //由值创建流
        var collect = Stream.of(1, 2, 3).collect(Collectors.toList());
        //由数组创建流
        int[] numbers = { 2, 3, 5, 7, 11, 13 };
        int sum = Arrays.stream(numbers).sum();
        //由文件创建流
        var lines = Files.lines(Path.of(""));
        var collect1 = lines.map(line -> line.split(",")).collect(Collectors.toList());
        //函数生成流
        var count = Stream.iterate(0, x -> x + 1).limit(10).count();
        var x = Stream.builder().add("x").add(1).build();
        x.forEach(System.out::println);
        Stream.generate(Date::new).dropWhile(date -> date.after(new Date())).count();
    }
}
