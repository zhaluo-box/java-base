package com.example.test.string;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Locale;

/**
 * 借助 pinyin4j jar 包完成该项工作
 * Created  on 2021/9/22 14:14:36
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringUtil {

    /**
     * 将汉字转为拼英
     */
    public static String chineseToPinYin(String chinese) {
        StringBuilder pascalSpell = new StringBuilder();// 返回的拼音
        try {
            char[] cl_chars = chinese.trim().toCharArray();
            // 大写样式
            HanyuPinyinOutputFormat upperFormat = new HanyuPinyinOutputFormat();
            upperFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);// 大写
            upperFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调

            // 小写样式
            HanyuPinyinOutputFormat lowerFormat = new HanyuPinyinOutputFormat();
            lowerFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写
            lowerFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调

            for (char cl_char : cl_chars) {
                String str = String.valueOf(cl_char);
                if (str.matches("[\u4e00-\u9fa5]+")) {// 如果字符是中文,则将中文转为汉语拼音,并取第一个字母大写，其他字母小写
                    pascalSpell.append(PinyinHelper.toHanyuPinyinStringArray(cl_char, upperFormat)[0].charAt(0));
                    pascalSpell.append(PinyinHelper.toHanyuPinyinStringArray(cl_char, lowerFormat)[0].substring(1));
                } else if (str.matches("[0-9]+")) {// 如果字符是数字,取数字
                    pascalSpell.append(cl_char);
                } else if (str.matches("[a-zA-Z]+")) {// 如果字符是字母,取字母
                    pascalSpell.append(cl_char);
                } else {// 否则不转换
                    pascalSpell.append(cl_char);//如果是标点符号的话，带着
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("字符不能转成汉语拼音");
        }
        return pascalSpell.toString();
    }

    public static String toPinyin(String chinese) throws BadHanyuPinyinOutputFormatCombination {
        var pinYin = new StringBuilder();
        var newChar = chinese.toCharArray();
        var defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char c : newChar) {
            String str = String.valueOf(c);
            if (str.matches("[\u4e00-\u9fa5]+")) {// 如果字符是中文,则将中文转为汉语拼音,并取第一个字母大写，其他字母小写
                pinYin.append(PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat)[0].charAt(0));
            } else if (str.matches("[0-9]+")) {// 如果字符是数字,取数字
                pinYin.append(c);
            } else if (str.matches("[a-zA-Z]+")) {// 如果字符是字母,取字母
                pinYin.append(c);
            } else {// 否则不转换
                pinYin.append(c);//如果是标点符号的话，带着
            }
        }
        return pinYin.toString();
    }

    /**
     * 将汉字转为拼英首字符 首字符小写
     * 对于一些多音字 有可能会出现异常！ 比如长  可以读 chang 也可以读 zhang
     */
    public static String chineseToPinYinFirstChar(String chinese) throws BadHanyuPinyinOutputFormatCombination {
        var pinYin = new StringBuilder();
        var newChar = chinese.toCharArray();
        var defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char c : newChar) {
            String str = String.valueOf(c);
            if (str.matches("[\u4e00-\u9fa5]+")) {// 如果字符是中文,则将中文转为汉语拼音,并取第一个字母大写，其他字母小写
                pinYin.append(PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat)[0].charAt(0));
            } else if (str.matches("[0-9]+")) {// 如果字符是数字,取数字
                pinYin.append(c);
            } else if (str.matches("[a-zA-Z]+")) {// 如果字符是字母,取字母
                pinYin.append(c);
            } else {// 否则不转换
                pinYin.append(c);//如果是标点符号的话，带着
            }
        }
        return pinYin.toString();
    }

    /**
     * 将汉字转为拼英首字符并大写
     */
    public static String chineseToPinYinFirstUp(String chinese) throws BadHanyuPinyinOutputFormatCombination {
        return chineseToPinYinFirstChar(chinese).toUpperCase(Locale.ROOT);
    }

}
