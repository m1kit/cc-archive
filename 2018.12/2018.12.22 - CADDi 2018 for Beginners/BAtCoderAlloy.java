package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class BAtCoderAlloy {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long h = in.longs(), w = in.longs();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long a = in.longs(), b = in.longs();
            if (a >= h && b >= w) {
                ans++;
            }
        }
        out.println(ans);
    }
}
