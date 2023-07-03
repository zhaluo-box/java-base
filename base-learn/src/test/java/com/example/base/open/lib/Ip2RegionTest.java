package com.example.base.open.lib;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.lionsoul.ip2region.xdb.Searcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 开源IP离线类库测试
 * Created  on 2023/6/14 16:16:37
 *
 * @author zl
 */
public class Ip2RegionTest {

    @Test
    @DisplayName("IP测试")
    public void test() throws IOException {
        String dbPath = "D:\\workspace\\personal\\java-base\\base-learn\\src\\main\\resources\\ip2region.xdb";

        // 1、从 dbPath 加载整个 xdb 到内存。
        byte[] cBuff;
        try {
            cBuff = Searcher.loadContentFromFile(dbPath);
        } catch (Exception e) {
            System.out.printf("failed to load content from `%s`: %s\n", dbPath, e);
            return;
        }

        // 2、使用上述的 cBuff 创建一个完全基于内存的查询对象。
        Searcher searcher;
        try {
            searcher = Searcher.newWithBuffer(cBuff);
        } catch (Exception e) {
            System.out.printf("failed to create content cached searcher: %s\n", e);
            return;
        }

        //        String ip = "66.249.65.110";
        String ip = "171.217.113.151";//"38.207.136.249";//"13.230.13.89";
        // 3、查询
        try {
            long sTime = System.nanoTime();
            String region = searcher.search(ip);

            System.out.println("region = " + region);
            long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
            System.out.printf("{region: %s, ioCount: %d, took: %d μs}\n", region, searcher.getIOCount(), cost);
        } catch (Exception e) {
            System.out.printf("failed to search(%s): %s\n", ip, e);
        }
        searcher.close();
    }
}
