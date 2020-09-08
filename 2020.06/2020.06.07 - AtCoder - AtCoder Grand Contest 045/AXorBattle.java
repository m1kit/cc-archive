package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.*;

public class AXorBattle {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        loop:
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints();
            long[] a = in.longs(n);
            char[] s = in.chars();
            List<Long> base = new ArrayList<>();
            for (int i = n - 1; i >= 0; i--) {
                for (long x : base) a[i] = Math.min(a[i], a[i] ^ x);
                if (a[i] == 0) continue;
                if (s[i] == '0') {
                    base.add(a[i]);
                } else {
                    out.ans(1).ln();
                    continue loop;
                }
            }
            out.ans(0).ln();
        }
    }
}
