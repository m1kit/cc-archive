package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), k = in.ints();
        long[] a = in.longs(n), b = in.longs(m);
        IntroSort.sort(a);
        IntroSort.sort(b);

        long min = -1, max = 999_999_999;
        while (max - min > 1) {
            long mid = (min + max + 1) / 2;

            int y = 0;
            int p = 0;
            outer: for (int x = 0; x < n && y < m; x++) {
                while (b[y] < a[x] - mid) {
                    y++;
                    if (y == m) {
                        break outer;
                    }
                }
                if (a[x] + mid < b[y]) {
                    continue;
                }
                p++;
                y++;
            }

            if (p >= k) {
                max = mid;
            } else {
                min = mid;
            }
        }
        out.ansln(max);
    }
}
