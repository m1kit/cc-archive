package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BGameGame {

    private static final String WIN = "WIN";
    private static final String LOSE = "LOSE";
    private static final String DRAW = "DRAW";

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        loop:
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints();
            int[] a = in.ints(n);
            for (int b = 1 << 31; b != 0; b >>>= 1) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if ((a[j] & b) == b) cnt++;
                }
                //System.out.println(b + " " + cnt);
                if (cnt % 2 == 0) continue;
                if (cnt % 4 == 1) {
                    out.ans(WIN).ln();
                } else if (n % 2 == 1) {
                    out.ans(LOSE).ln();
                } else {
                    out.ans(WIN).ln();
                }
                continue loop;
            }
            out.ans(DRAW).ln();
        }
    }
}
