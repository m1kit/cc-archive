package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long n = in.ints();
        String s = in.string();
        int m = s.length();

        if (s.matches("^A*$")) {
            out.ansln((n * m) * (n * m + 1) / 2);
            return;
        }

        int head = 0, tail = 0;
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == 'A') {
                head++;
            } else break;
        }
        for (int i = m - 1; i >= 0; i--) {
            if (s.charAt(i) == 'A') {
                tail++;
            } else break;
        }



        long acc = 0;
        long ans = 0;
        for (int i = 0; i < head; i++) {
            ans += i + 1;
        }
        for (int i = 0; i < tail; i++) {
            ans += i + 1;
        }
        ans += (head + tail) * (head + tail + 1L) / 2 * (n - 1);


        for (int i = head; i < m - tail; i++) {
            if (s.charAt(i) == 'A') {
                acc++;
                ans += acc * n;
            } else {
                acc = 0;
            }
        }
        out.ansln(ans);
    }
}
