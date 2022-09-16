package com.example.base.learn.io;

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

    private String filename;

    private boolean isDir;

    private int level;

    private List<FileDescription> descriptions = new ArrayList<>();
}
