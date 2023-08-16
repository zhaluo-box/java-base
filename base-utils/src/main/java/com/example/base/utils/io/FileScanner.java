package com.example.base.utils.io;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.List;

/**
 * 文件扫描
 * Created  on 2023/7/19 16:16:41
 *
 * @author zl
 */
public interface FileScanner {

    /**
     * @param rootFilename 一个根文件夹
     * @return 返回文件夹下的文件描述
     */
    static FileDescription scanFileList(String rootFilename) {
        var rootFile = new File(rootFilename);
        if (!rootFile.isDirectory()) {
            throw new RuntimeException("扫描的根目录必须是一个文件夹");
        }
        var fileDesc = new FileDescription();
        fileDesc.setDir(true).setFilename(rootFile.getName()).setAbsPath(FileUtil.getAbsolutePath(rootFile));
        var descriptions = fileDesc.getDescriptions();
        var files = rootFile.listFiles();
        if (files != null) {
            scanFile(descriptions, files, 1);
        }
        return fileDesc;
    }

    static void scanFile(List<FileDescription> descriptions, File[] files, int level) {
        if (files == null) {
            return;
        }
        for (File file : files) {
            var isDir = file.isDirectory();
            FileDescription fileDescription = buildFileDescription(level, file, isDir);
            descriptions.add(fileDescription);
            if (isDir) {
                scanFile(fileDescription.getDescriptions(), file.listFiles(), level + 1);
            }
        }
    }

    public static FileDescription buildFileDescription(int level, File file, boolean isDir) {
        var fileDescription = new FileDescription();
        fileDescription.setFilename(file.getName())
                       .setDir(isDir)
                       .setLevel(level)
                       .setSuffix(FileUtil.getSuffix(file))
                       .setAbsPath(FileUtil.getAbsolutePath(file));
        return fileDescription;
    }

}
