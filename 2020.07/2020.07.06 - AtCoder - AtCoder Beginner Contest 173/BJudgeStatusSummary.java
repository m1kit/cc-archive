package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Map;

public class BJudgeStatusSummary {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] c = new int[4];
        for (int i = 0; i < n; i++) {
            String s = in.string();
            if ("AC".equals(s)) c[0]++;
            if ("WA".equals(s)) c[1]++;
            if ("TLE".equals(s)) c[2]++;
            if ("RE".equals(s)) c[3]++;
        }
        out.ans("AC x").ans(c[0]).ln();
        out.ans("WA x").ans(c[1]).ln();
        out.ans("TLE x").ans(c[2]).ln();
        out.ans("RE x").ans(c[3]).ln();
    }
}
