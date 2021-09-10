package com.example.learn.pattern.strategy.demo4.youhua;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Sorter {
    private static final long GB = 1000 * 1000 * 1000;

    /**
     * 实际中可以用配置表代替
     */
    private static final List<AlgRange> algs = new ArrayList<>();

    static {
        algs.add( new AlgRange( 0, 6 * GB, SortAlgFactory.getSortAlg( "QuickSort" ) ) );
        algs.add( new AlgRange( 6 * GB, 10 * GB, SortAlgFactory.getSortAlg( "ExternalSort" ) ) );
        algs.add( new AlgRange( 10 * GB, 100 * GB, SortAlgFactory.getSortAlg( "ConcurrentExternalSort" ) ) );
        algs.add( new AlgRange( 100 * GB, Long.MAX_VALUE, SortAlgFactory.getSortAlg( "MapReduceSort" ) ) );
    }

    public void sortFile(String filePath) {

        // 省略校验逻辑
        File file = new File( filePath );
        long fileSize = file.length();
        ISortAlg sortAlg = null;

        // 利用for循环与 if 比对实现 if ..else .. 的代码简化, 但是本质上性能没什么太大的变化, 纯感觉

        for (AlgRange algRange : algs) {
            if (algRange.inRange( fileSize )) {
                sortAlg = algRange.getAlg();
                break;
            }
        }

        sortAlg.sort( filePath );
    }

    private static class AlgRange {
        private long start;
        private long end;
        private ISortAlg alg;

        public AlgRange(long start, long end, ISortAlg alg) {
            this.start = start;
            this.end = end;
            this.alg = alg;
        }

        public ISortAlg getAlg() {
            return alg;
        }

        public boolean inRange(long size) {
            return size >= start && size < end;
        }
    }

    public static void main(String[] args) {
        final Sorter sorter = new Sorter();
        sorter.sortFile( "" );
    }
}
