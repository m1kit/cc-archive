package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DCardEater {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int one = 0, two = 0;
        int[] cnt = new int[100_001];
        for (int i = 0; i < n; i++) {
            cnt[in.ints()]++;
        }
        for (int i = 1; i <= 100_000; i++) {
            if (cnt[i] == 0) {
                continue;
            } else if (cnt[i] % 2 == 0) {
                two++;
            } else {
                one++;
            }
        }

        one += two / 2 * 2;
        out.ansln(one);
    }
}
