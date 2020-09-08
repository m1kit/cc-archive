package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class EOrand {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n, max, m = 0;
        int[] a;
        {
            int n0 = in.ints();
            max = in.ints();
            int s = in.ints(), t = in.ints();
            int[] a0 = in.ints(n0);
            a = new int[n0];
            n = 0;
            for (int i = 0; i < 20; i++) {
                if (((s >> i) & 1) == 1 || ((t >> i) & 1) == 0) continue;
                m++;
            }
            for (int i = 0; i < n0; i++) {
                if ((a0[i] & s) != s || (a0[i] | t) != t) continue;
                int tmp = 0, bit = 1;
                for (int j = 0; j < 18; j++) {
                    if (((s >> j) & 1) == 1 || ((t >> j) & 1) == 0) continue;
                    if (((a0[i] >> j) & 1) == 1) tmp |= bit;
                    bit <<= 1;
                }
                a[n++] = tmp;
            }
        }

        long[][] comb = new long[51][51];
        long[] coeff = new long[51];
        for (int i = 0; i <= 50; i++) comb[i][0] = 1;
        for (int i = 1; i <= 50; i++) comb[i][i] = 1;
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j < i; j++) {
                comb[i][j] = comb[i - 1][j] + comb[i - 1][j - 1];
            }
        }
        for (int i = 0; i <= 50; i++) {
            for (int j = 1; j < max && j <= i; j++) {
                coeff[i] += comb[i][j];
            }
        }

        long ans = 0;
        for (int i = 1; i <= max; i++) ans += comb[n][i];
        if (m == 0) {
            out.ans(ans).ln();
            return;
        } else if (n == 0) {
            out.ans(0).ln();
            return;
        }

        //System.out.println(Arrays.toString(coeff));
        int all = 1 << m;
        for (int i = 0; i < n; i++) {
            long d = 1;
            for (int j = 1; j < all; j++) {
                int count = 0;
                for (int k = i + 1; k < n; k++) {
                    if ((j & (a[i] ^ a[k])) == 0) count++;
                }
                if ((Integer.bitCount(j) & 1) == 1) d += coeff[count];
                else d -= coeff[count];
                //System.out.println(i + "," + Integer.toBinaryString(j) + "," + count);
            }
            //System.out.println(i + " - " + d);
            ans -= Math.abs(d);
        }
        out.ans(ans).ln();
    }
}
