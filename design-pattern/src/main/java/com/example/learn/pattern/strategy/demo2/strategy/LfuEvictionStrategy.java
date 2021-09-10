package com.example.learn.pattern.strategy.demo2.strategy;

/**
 * 最不经常使用 过期策略.
 * LFU（Least Frequently Used）算法根据数据的历史访问频率来淘汰数据，其核心思想是“如果数据过去被访问多次，那么将来被访问的频率也更高”。
 * LFU的每个数据块都有一个引用计数，所有数据块按照引用计数排序，具有相同引用计数的数据块则按照时间排序。
 * 具体实现如下：
 * <p>
 * 1. 新加入数据插入到队列尾部（因为引用计数为1）；
 * 2. 队列中的数据被访问后，引用计数增加，队列重新排序；
 * 3. 当需要淘汰数据时，将已经排序的列表最后的数据块删除。
 */

public class LfuEvictionStrategy implements EvictionStrategy {

    @Override
    public void replacement(java.util.Map<?, ?> cacheData) {
        System.out.println( "*LFU:  最不经常使用 过期策略.\n" +
                " * LFU（Least Frequently Used）算法根据数据的历史访问频率来淘汰数据，其核心思想是“如果数据过去被访问多次，那么将来被访问的频率也更高”。\n" +
                " * LFU的每个数据块都有一个引用计数，所有数据块按照引用计数排序，具有相同引用计数的数据块则按照时间排序。\n" +
                " * 具体实现如下：\n" +
                " * <p>\n" +
                " * 1. 新加入数据插入到队列尾部（因为引用计数为1）；\n" +
                " * 2. 队列中的数据被访问后，引用计数增加，队列重新排序；\n" +
                " * 3. 当需要淘汰数据时，将已经排序的列表最后的数据块删除。 " );
    }


}
