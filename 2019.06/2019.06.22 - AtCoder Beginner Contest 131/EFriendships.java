package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class EFriendships {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        int cnt = (n - 1) * (n - 2) / 2;
        if (k > cnt) {
            out.ans(-1).ln();
            return;
        }
        int m = (n - 1) + (cnt - k);
        out.ans(m).ln();
        for (int i = 1; i < n; i++) {
            out.ans(1).ans(i + 1).ln();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                if (k < cnt) {
                    cnt--;
                    out.ans(j + 1).ans(i + 1).ln();
                }
            }
        }
    }
}
