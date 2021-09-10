package com.example.learn.pattern.prototype.geek;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchWord {

    private long lastUpdateTime;
    private String keyword;
    private int count;

    public SearchWord(String keyword, int count, long lastUpdateTime) {
    }
}
