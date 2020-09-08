package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.seqence.RollingHash;

public class BNIKKEIString {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String s = in.string();
        int n = s.length(), ans = 0;
        RollingHash hash = new RollingHash(s);
        for (int nLen = 1; nLen < n; nLen++) {
            for (int j = nLen + 1; 2 * j - nLen < n; j++) {
                int iLen = j - nLen;
                if (!hash.match(nLen, j, n - iLen, n)) continue;
                for (int i = j + 1; 2 * i - nLen < n; i++) {
                    int kLen = i - j;
                    if (!hash.match(j, i, i, 2 * i - j)) continue;
                    ans++;
                }
            }
        }
        out.ans(ans).ln();
    }
}
