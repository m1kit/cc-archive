package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.math.BigInteger;

public class BSplitANumber {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String s = in.string();
        int l = n / 2, r = (n + 1) / 2;
        while (s.charAt(l) == '0') l--;
        while (r < n && s.charAt(r) == '0') r++;
        BigInteger ans = null;
        if (l != 0) {
            BigInteger sna = new BigInteger(s.substring(0, l)).add(new BigInteger(s.substring(l)));
            ans = sna;
        }
        if (r != n) {
            BigInteger sna = new BigInteger(s.substring(0, r)).add(new BigInteger(s.substring(r)));
            if (ans == null || ans.compareTo(sna) > 0) {
                ans = sna;
            }
        }
        out.ans(ans.toString()).ln();
    }
}
