package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashSet;
import java.util.Set;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Set<String> s = new HashSet<>();
        String last = in.string();
        s.add(last);
        for (int i = 1; i < n; i++) {
            String x = in.string();
            if (x.charAt(0) != last.charAt(last.length() - 1) || s.contains(x)) {
                out.ans(i % 2 == 1 ? "WIN" : "LOSE").ln();
                return;
            }
            s.add(x);
            last = x;
        }
        out.ans("DRAW").ln();
    }
}
