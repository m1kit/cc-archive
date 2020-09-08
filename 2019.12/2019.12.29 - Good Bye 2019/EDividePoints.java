package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.ArrayList;
import java.util.List;

public class EDividePoints {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        if (n == 2) {
            out.ans(1).ln().ans(1).ln();
            return;
        }
        int[] x = new int[n], y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ints() + 2000000;
            y[i] = in.ints() + 2000000;
        }

        int gx = 0, gy =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                gx = IntMath.gcd(gx, Math.abs(x[i] - x[j]));
                gy = IntMath.gcd(gy, Math.abs(y[i] - y[j]));
            }
        }
        gx = gy = IntMath.gcd(gx, gy);
        for (int i = 0; i < n; i++) {
            if (gx != 0) x[i] /= gx;
            if (gy != 0) y[i] /= gy;
        }

        //System.out.println("gx=" + gx + " gy=" + gy);


        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((x[i] + y[i]) % 2 == 0) ans.add(i + 1);
        }

        if (ans.isEmpty() || ans.size() == n) {
            ans.clear();
            for (int i = 0; i < n; i++) {
                if (x[i] % 2 == 0) ans.add(i + 1);
            }
        }

        if (ans.isEmpty() || ans.size() == n) {
            ans.clear();
            for (int i = 0; i < n; i++) {
                if (y[i] % 2 == 0) ans.add(i + 1);
            }
        }

        if (ans.isEmpty() || ans.size() == n) {
            throw new RuntimeException();
        }

        out.ans(ans.size()).ln();
        for (int a : ans) out.ans(a);
        out.ln();
    }
}
