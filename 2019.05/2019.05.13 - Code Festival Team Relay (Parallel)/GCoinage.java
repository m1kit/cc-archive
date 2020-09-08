package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.euclid.LongEuclidSolver;

public class GCoinage {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int l = in.ints();
        String s = in.string(), t = in.string();
        StringBuilder x = new StringBuilder(), y = new StringBuilder();
        int a = find(s.length(), t.length(), l), b = find(t.length(), s.length(), l);
        for (int i = 0; i < a; i++)  x.append(t);
        while (x.length() < l)       x.append(s);
        for (int i = 0; i < b; i++)  y.append(s);
        while (y.length() < l)       y.append(t);
        String p = x.toString(), q = y.toString();
        if (p.compareTo(q) < 0) {
            out.ans(p).ln();
        } else {
            out.ans(q).ln();
        }
    }

    private static int find(int a, int b, int l) {
        for (int i = 0; i <= l; i++) {
            if ((l - a * i) % b == 0) return (l - a * i) / b;
        }
        throw new RuntimeException();
    }
}
