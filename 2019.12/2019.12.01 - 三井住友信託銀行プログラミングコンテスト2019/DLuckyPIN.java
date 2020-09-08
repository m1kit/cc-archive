package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DLuckyPIN {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        char[] s = in.string().toCharArray();
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    int l = 0;
                    for (int m = 0; m < n; m++) {
                        if (l == 0 && s[m] == i + '0') l++;
                        else
                        if (l == 1 && s[m] == j + '0') l++;
                        else
                        if (l == 2 && s[m] == k + '0') l++;
                    }
                    if (l == 3) ans++;
                }
            }
        }
        out.ans(ans).ln();
    }
}
