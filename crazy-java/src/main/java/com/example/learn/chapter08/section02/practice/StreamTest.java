package com.example.learn.chapter08.section02.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.OptionalDouble;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class StreamTest {

    Collection<Book> books = new ArrayList<>();

    public void before() {
        books.add(new Book("安徒生童话", 32.5d));
        books.add(new Book("海底世界两万里", 32.3d));
        books.add(new Book("钢铁是怎么样炼成的", 28.9d));
        books.add(new Book("一千零一夜", 56.9d));
        books.add(new Book("中华上下五千年", 99.9d));
    }

    public void test() {
        Stream.Builder<Book> s = Stream.builder();
        s.accept(new Book("安徒生童话", 32.5d));
        s.accept(new Book("海底世界两万里", 32.3d));
        s.accept(new Book("钢铁是怎么样炼成的", 28.9d));
        s.accept(new Book("一千零一夜", 56.9d));
        s.accept(new Book("中华上下五千年", 99.9d));

        s.build().forEach(System.out::println);

    }

    public void test1() {

        /*
        long count = books.stream().filter(book -> {
            if ("安徒生童话".equals(book.getName())) {
                return true;
            }
            return false;
        }).count();
        */

        /*
            分析一下:
                books: ? extends collection
                filter(): 中间方法 : 对流进行过滤
                count(): 末端方法 : 结束当前流
            注意一下这里没有提出公共部分
                Stream<Book> stream = books.stream();
            情景1 和 情景2 都是各自的流
         */
        /* 简化一下 */
        Stream<Book> stream = books.stream();
        long l = stream.filter(book -> "安徒生童话".equals(book.getName())).count(); // 末端方法count已经关流;
        System.out.println(l);

        /* 异常 java.lang.IllegalStateException: stream has already been operated upon or closed */
        /*
        long count2 = stream.filter(book2 -> 50.0d < (book2.getPrice())).count();
        System.out.println(count2);
        */

        //情景1:
        long count = books.stream().filter(book -> "安徒生童话".equals(book.getName())).count();
        System.out.println(count);
        System.out.println("--------------------------");
        //情景2:
        long count1 = books.stream().filter(book2 -> 50.0d < (book2.getPrice())).count();
        System.out.println(count1);

    }

    public void test2() {
        OptionalDouble any = books.stream().mapToDouble(book -> book.getPrice()).findAny();
        System.out.println(any.toString());
        OptionalDouble first = books.stream().mapToDouble(book -> book.getPrice()).findFirst();
        System.out.println(first);

        // 遍历
        books.stream().filter(book -> null != book).forEach(System.out::println);

        // 先排序后遍历
        books.stream().mapToDouble(b -> b.getPrice()).sorted().forEach(System.out::println);
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Book {
    String name;

    double price;
}
