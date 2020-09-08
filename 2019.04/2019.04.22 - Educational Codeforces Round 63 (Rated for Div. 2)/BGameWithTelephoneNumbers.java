package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BGameWithTelephoneNumbers {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints();
        char[] s = in.string().toCharArray();
        int x = 0, y = 0;
        int k = (n - 11) / 2;
        for (int i = 0; i < k; i++) {
            while (x < n && (s[x] == 0 || s[x] == '8')) {
                x++;
            }
            if (x < n) {
                s[x] = 0;
            }


            while (y < n && (s[y] == 0 || s[y] != '8')) {
                y++;
            }
            if (y < n && s[y] == '8') {
                s[y] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s[i] != 0) {
                out.ans(s[i] == '8').ln();
                return;
            }
        }
    }
}
