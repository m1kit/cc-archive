package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;
import dev.mikit.atcoder.lib.math.mod.ModMath;

import java.math.BigInteger;
import java.util.Arrays;

public class CDivisionByTwoWithSomething {

    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        char[] x = in.string().toCharArray();

        long xmod = 0;
        for (int i = 0; i < n; i++) {
            xmod *= 2;
            if (x[i] == '1') xmod++;
            xmod %= MOD;
        }
        xmod++;
        xmod %= MOD;
        long ans = 2 * n * xmod % MOD;

        int[] convered = new int[n + 1];
        for (int bits = 1; bits < n; bits++) {
            if (n % bits != 0) continue;
            int num = n / bits;
            if (num % 2 == 0) continue;

            boolean ok = true;
            outer: for (int i = 1; i < num; i++) {
                for (int j = 0; j < bits; j++) {
                    char dBst = i % 2 == 0 ? x[j] : (char) ('a' - x[j]);
                    char dAct = x[i * bits + j];
                    if (dBst == dAct) continue;
                    if (dBst > dAct) ok = false;
                    break outer;
                }
            }

            long variety = 0;
            for (int i = 0; i < bits; i++) {
                variety <<= 1;
                if (x[i] == '1') variety |= 1;
                variety %= MOD;
            }


            if (ok) variety++;
            variety += MOD - convered[bits];
            variety %= MOD;

            //System.out.println("Variety for bits=" + bits + " was " + variety + " : " + ok);


            long costDiff = (2L * bits + MOD - 2L * n) % MOD;
            ans += variety * costDiff % MOD;
            ans %= MOD;

            for (int i = bits * 2; i <= n; i += bits) {
                convered[i] += variety;
                convered[i] %= MOD;
            }
        }
        out.ans(ans).ln();
    }
}
