package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Map;
import java.util.TreeMap;

public class J {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        int[] last = new int[n];
        for (int i = 0; i < m; i++) {
            int a = in.ints();
            int min = -1, max = n;
            while (max - min > 1) {
                int mid = (min + max) / 2;
                if (last[mid] >= a) min = mid;
                else max = mid;
            }
            if (max == n) {
                out.ans(-1).ln();
            } else {
                last[max] = a;
                out.ans(max + 1).ln();
            }
        }
    }
}
