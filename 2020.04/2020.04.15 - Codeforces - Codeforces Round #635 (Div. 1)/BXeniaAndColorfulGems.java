package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class BXeniaAndColorfulGems {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] len = in.ints(3);
            long[][] x = new long[3][];
            for (int i = 0; i < 3; i++) {
                x[i] = in.longs(len[i]);
                IntroSort.sort(x[i]);
            }
            long ans = calc(x[0][0], x[1][0], x[2][0]);
            int[] cur = new int[3];
            while (true) {
                int index = -1;
                long tmp = Long.MAX_VALUE;
                for (int i = 0; i < 3; i++) {
                    int j = (i + 1) % 3, k = (i + 2) % 3;
                    if (cur[i] < len[i] - 1) {
                        long d = calc(x[i][cur[i] + 1], x[j][cur[j]], x[k][cur[k]]);
                        if (d < tmp) {
                            index = i;
                            tmp = d;
                        }
                    }
                }
                if (index == -1) break;
                cur[index]++;
                ans = Math.min(ans, tmp);
            }
            out.ans(ans).ln();
        }
    }

    private static long calc(long x, long y, long z) {
        long d0 = x - y, d1 = y - z, d2 = z - x;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }
}
