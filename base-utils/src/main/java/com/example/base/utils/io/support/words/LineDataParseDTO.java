package com.example.base.utils.io.support.words;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 行数据解析DTO
 */
@Data
@Accessors(chain = true)
public class LineDataParseDTO {

    private String originalLine;

    private String english;

    private String phonetic;

    private String chinese;

    private String serialNum;

    private String lesson;
}
