package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class A2048Game {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            int[] cnt = new int[70];
            for (int i = 0; i < n; i++) {
                int exp = 0;
                long a = in.longs();
                while (a % 2 == 0) {
                    a /= 2;
                    exp++;
                }
                cnt[exp]++;
            }
            for (int i = 0; i <= 10; i++) {
                cnt[i + 1] += cnt[i] / 2;
                cnt[i] %= 2;
            }
            out.ans(cnt[11] > 0).ln();
        }
    }
}
