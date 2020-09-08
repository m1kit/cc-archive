package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class B {

    private static final int[] DAYS = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        boolean[] a = new boolean[1000];
        for (int i = 0; i < 366; i++) a[i] = i % 7 == 0 || i % 7 == 6;
        int n = in.ints();
        for (int i = 0; i < n; i++) {
            String[] s = in.string().split("/");
            int m = Integer.parseInt(s[0]), d = Integer.parseInt(s[1]);
            int x = DAYS[m - 1] + d - 1;
            while (a[x]) x++;
            a[x] = true;
        }
        int ans = 0, len = 0;
        for (int i = 0; i < 366; i++) {
            if (a[i]) ans = Math.max(ans, ++len);
            else len = 0;
        }
        out.ans(ans).ln();
    }
}
