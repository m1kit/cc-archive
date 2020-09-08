package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class Draupnir {

    private static final int MOD = (int) 1e9 + 7;

    private static final int[] MAGIC_NUMBER = {38, 185};
    private static final int[][] OFFSET = {{38, 19, 12, 9, 7, 6}, {185, 92, 61, 46, 37, 30}};
    private static final int MASK = (1 << 7) - 1;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);

        /*for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= 6; j++) {
                out.ans(MAGIC_NUMBER[i] / j);
            }
            out.ln().flush();
        }*/

        int testCases = in.ints(), w = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            out.ans(185).ln().flush();
            long f1 = in.longs();
            if (f1 == -1) return;
            long[] ans = new long[6];
            ans[3] = (f1 >> 46) & MASK;
            ans[4] = (f1 >> 37) & MASK;
            ans[5] = (f1 >> 30) & MASK;
            out.ans(38).ln().flush();
            long f2 = in.longs();
            if (f2 == -1) return;
            f2 -= ans[3] << 9;
            f2 -= ans[4] << 7;
            f2 -= ans[5] << 6;
            ans[0] = (f2 >> 38) & MASK;
            ans[1] = (f2 >> 19) & MASK;
            ans[2] = (f2 >> 12) & MASK;
            out.ans(ans).ln().flush();
            int verdict = in.ints();
            if (verdict == -1) return;
        }
    }
}
