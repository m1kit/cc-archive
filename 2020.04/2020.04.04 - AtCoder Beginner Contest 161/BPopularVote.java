package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.stream.IntStream;

public class BPopularVote {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        int n = in.ints(), m = in.ints();
        int[] a = in.ints(n);
        int sum = IntStream.of(a).sum();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] * m * 4 >= sum)cnt++;
        }
        out.ans(cnt >= m).ln();
    }
}
