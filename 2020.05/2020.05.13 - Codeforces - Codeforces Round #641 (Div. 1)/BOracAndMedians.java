package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.stream.IntStream;

public class BOracAndMedians {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_DOWN);
        int testCases = in.ints();
        test:
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints(), k = in.ints();
            int[] a = in.ints(n);
            if (IntStream.of(a).noneMatch(x -> x == k)) {
                out.noln();
                continue;
            }
            if (IntStream.of(a).allMatch(x -> x >= k)) {
                out.yesln();
                continue;
            }
            for (int i = 0; i < n; i++) {
                if ((i < n - 1 && a[i] >= k && a[i + 1] >= k) || (i < n - 2 && a[i] >= k && a[i + 2] >= k)) {
                    out.yesln();
                    continue test;
                }
            }
            out.noln();
        }
    }
}
