package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.ArrayList;
import java.util.List;

public class ACoPrimeArray {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        List<Integer> ans = new ArrayList<>();
        int[] a = in.ints(n);
        ans.add(a[0]);
        for (int i = 1; i < n; i++) {
            if (IntMath.gcd(a[i - 1], a[i]) > 1) {
                ans.add(1);
            }
            ans.add(a[i]);
        }
        out.ansln(ans.size() - n);
        for (int i : ans) {
            out.ans(i);
        }
        out.ln();
    }
}
