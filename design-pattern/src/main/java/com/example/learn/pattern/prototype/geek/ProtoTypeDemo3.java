package com.example.learn.pattern.prototype.geek;

import java.util.HashMap;
import java.util.List;

/**
 * 原型设计模式
 *  浅克隆,存在造成数据 一部分新数据 一部分旧数据
 *  因为浅克隆 ==> 指向的是原数据的地址
 */
public class ProtoTypeDemo3 {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        // 原型模式就这么简单，拷贝已有对象的数据，更新少量差值
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone();
        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords( lastUpdateTime );
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey( searchWord.getKeyword() )) {
                SearchWord oldSearchWord = newKeywords.get( searchWord.getKeyword() );

                oldSearchWord.setCount( searchWord.getCount() );
                oldSearchWord.setLastUpdateTime( searchWord.getLastUpdateTime() );
            } else {  // 如果数据 不存在 则直接新增
                newKeywords.put( searchWord.getKeyword(), searchWord );
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间>lastUpdateTime的数据
        return null;
    }
}
