package com.example.test.String;

import com.example.test.string.StringUtil;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

/**
 * Created  on 2021/9/22 14:14:46
 */
public class StringUtilTest {

    @Test
    public void chineseToPinYin() throws BadHanyuPinyinOutputFormatCombination {
        System.out.println(StringUtil.chineseToPinYin("你好"));
        System.out.println(StringUtil.toPinyin("北京你好"));
    }

    @Test
    public void chineseToPinYinFirstChar() throws BadHanyuPinyinOutputFormatCombination {
        System.out.println(StringUtil.chineseToPinYinFirstChar("秦时明月汉时关！"));
    }

    @Test
    public void chineseToPinYinFirstUp() throws BadHanyuPinyinOutputFormatCombination {
        System.out.println(StringUtil.chineseToPinYinFirstUp("万里长征人不还。"));
    }

    @Test
    public void generate() {
        System.out.println(StringUtil.generateFields(13));
    }

    @Test
    public void testStrCode() {
        System.out.println("汉字");
    }
}