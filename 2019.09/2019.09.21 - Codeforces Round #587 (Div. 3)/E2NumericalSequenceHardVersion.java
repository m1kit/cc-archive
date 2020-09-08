package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class E2NumericalSequenceHardVersion {

    private static final int MAX = 10_000_000;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int q = in.ints();
        for (int query = 0; query < q; query++) {
            long k = in.longs() - 1;
            long min, max;

            min = 0;
            max = 1_000_000_000L;
            while (max - min > 1) {
                long mid = (min + max) / 2;
                if (A165145(mid) > k) max = mid;
                else min = mid;
            }
            k -= A165145(min);

            min = 0;
            max = 1_000_000_000L;
            while (max - min > 1) {
                long mid = (min + max) / 2;
                if (A058183(mid) > k) max = mid;
                else min = mid;
            }
            k -= A058183(min);

            out.ans(Long.toString(min + 1).charAt((int) k)).ln();
        }
    }

    private static long A165145(long x) {
        long num = 0;
        for (long i = 1; i <= 10_000_000_000L; i *= 10) {
            long cnt = Math.max(x - i + 1, 0);
            num += cnt * (cnt + 1L) / 2;
        }
        return num;
    }

    private static long A058183(long x) {
        long num = 0;
        for (long i = 1; i <= 10_000_000_000L; i *= 10) {
            long cnt = Math.max(x - i + 1, 0);
            num += cnt;
        }
        return num;
    }
}
