package com.zhaluobox.crazyjava.chapter15.chapter15_01_File类;

import java.io.File;
import java.util.List;

public class FileTest2 {


    public static void main(String[] args) {
        final File file = new File( "D:\\test\\abc" );
        System.out.println( file.getName() );
        System.out.println( file.getParent() );
        System.out.println( file.getAbsolutePath() );
    }


    private void retrieveAllImportFiles(File srcRootPath, final List<File> files) {
        // list()方法是返回某个目录下的所有文件和目录的文件名，返回的是String数组
        // listFiles()方法是返回某个目录下所有文件和目录的绝对路径，返回的是File数组
        File[] subFiles = srcRootPath.listFiles();
        // 如果子文件列表不为空
        if (subFiles != null) {
            for (File tempFile : subFiles) {
                // 测试由这个抽象路径名表示的文件是否是一个目录。
                if (tempFile.isDirectory()) {
                    // 如果是云闪付的子目录 只处理文件夹格式为yyyyMMdd 且时间为昨天的目录;
                    //                    if(tempFile.getName()) {
                    //
                    //                    }
                    retrieveAllImportFiles(tempFile, files);
                }
                if (tempFile.isFile()) {
                    files.add(tempFile);
                }
            }
        }
    }
}
