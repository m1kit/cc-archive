package jp.llv.atcoder;

import java.util.Arrays;

public class IdenticalBags {
    public long makeBags(long[] candy, long bagSize) {
        Arrays.sort(candy);
        long min = 0, max = 1_000_000_000_000_000_001L;
        while (max - min > 1) {
            long mid = (min + max) / 2;
            long p = 0;
            for (int i = 0; i < candy.length; i++) {
                p += candy[i] / mid;
            }
            if (p >= bagSize) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return min;
    }
}
