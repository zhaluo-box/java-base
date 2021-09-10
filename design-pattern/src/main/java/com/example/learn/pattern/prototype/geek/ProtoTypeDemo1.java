package com.example.learn.pattern.prototype.geek;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 原型设计模式demo1
 */
public class ProtoTypeDemo1 {

    /**
     * 定义一个concurrentHashMap存放数据.
     */
    private ConcurrentHashMap<String, SearchWord> currentKeywords = new ConcurrentHashMap<>();
    private long lastUpdateTime = -1;

    /**
     * 数据刷新.
     */
    public void refresh() {
        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到currentKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords( lastUpdateTime );
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (currentKeywords.containsKey( searchWord.getKeyword() )) {
                currentKeywords.replace( searchWord.getKeyword(), searchWord );
            } else {
                currentKeywords.put( searchWord.getKeyword(), searchWord );
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间>lastUpdateTime的数据
        return null;
    }
}
