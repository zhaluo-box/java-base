package com.zhaluobox.crazyjava.chapter15.section01file;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        //以当前路径创建一个file对象
        File file = new File("a.txt");
        //直接获取文件名，输出一个.
        System.out.println("1.文件名 : " + file.getName());
        //输出相对路径的父路径，可能出错，null,使用相对路径的File获取父路径可能引起错误
        System.out.println("2.获取当前文件的父路径: " + file.getParent());
        //获取绝对路径
        System.out.println("3. 文件的绝对路径: " + file.getAbsoluteFile());
        //获取上一级路径
        System.out.println("4. 通过文件的绝对路径来获取父路径: " + file.getAbsoluteFile().getParent());
        //在当前路径下创建一个临时文件
        File tmpFile = File.createTempFile("aaa", ".txt", file.getAbsoluteFile().getParentFile());
        System.out.println("5. 临时文件的名称: " + tmpFile.getName());
        System.out.println(tmpFile.getAbsoluteFile());
        System.out.println("6. 临时文件的父路径: " + tmpFile.getAbsoluteFile().getParent());
        //指定jvm退出时删除该文件
        tmpFile.deleteOnExit();
        // 线程睡眠 5秒钟就可以看到临时文件了
//        Thread.sleep(5000);
        //以系统时间为文件名创建文件
        final long l = System.currentTimeMillis();
        System.out.println(l);
        File newFile = new File(l + "");
        System.out.println("newFile文件是否存在： " + newFile.exists());
        //以newFile对象创建一个文件
        newFile.createNewFile();
        //以newFile对象创建一个目录，因为newFile已经存在，返回false 无法创建
        System.out.println("文件存在的时候能否创建一个名称相同的文件夹: "+newFile.mkdir());
        //列出当前路径下所有文件和路径
        String[] fileList = file.getAbsoluteFile().getParentFile().list();
        System.out.println("========当前路径下所有文件和路径========");
        for (String fileName : fileList)
            System.out.println(fileName);
        //listRoot()静态方法，列出所有磁盘根路径
        File[] roots = File.listRoots();
        System.out.println("==========系统所有跟路径如下");
        for (File root : roots)
            System.out.println(root);
    }
}
