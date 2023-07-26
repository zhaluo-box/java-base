package com.example.base.utils.io;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 * Created  on 2022/9/16 14:14:15
 *
 * @author zl
 */
@Data
@Accessors(chain = true)
public class FileDescription {

    /**
     * 绝对路径
     */
    private String absPath;

    /**
     * 文件名称
     */
    private String filename;

    /**
     * 是否是文件夹
     */
    private boolean isDir;

    /**
     * 层级
     */
    private int level;

    /**
     * 文件后缀
     */
    private String suffix = "**";

    /**
     * 子文件夹
     */
    private List<FileDescription> descriptions = new ArrayList<>();
}
