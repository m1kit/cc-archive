package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

import java.util.ArrayList;
import java.util.List;

public class PascalWalk {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            out.cases(testCase).ln();
            long n = in.longs(), originalN = n;
            if (n < 40) {
                for (int i = 1; i <= n; i++) out.ans(i).ans(1).ln();
                continue;
            }

            List<P> ans = new ArrayList<>();
            ans.add(new P(0, 0));
            ans.add(new P(1, 0));
            n -= 2;

            long binary = 0;
            for (int i = 31; i >= 2; i--) {
                long b = (1L << i) - 1;
                if (b <= n - 30) {
                    n -= b;
                    binary |= (1L << i);
                }
            }

            boolean left = true;
            for (int i = 2; i < 32; i++) {
                if (((binary >> i) & 1) == 0) {
                    if (left) ans.add(new P(i, 0));
                    else ans.add(new P(i, i));
                    n--;
                } else {
                    if (left) {
                        for (int j = 0; j <= i; j++) ans.add(new P(i, j));
                        left = false;
                    } else {
                        for (int j = i; j >= 0; j--) ans.add(new P(i, j));
                        left = true;
                    }
                    n -= (1L << i);
                }
            }

            long validate = 0;
            Factorial mod = new ModMath(MOD).getFactorial(1000);
            for (P p : ans) validate += mod.ncr(p.r, p.c);
            for (int i = 0; validate < originalN; i++) {
                ans.add(new P(32 + i, left ? 0 : 32 + i));
                validate++;
            }

            for (P p : ans) out.ans(p.r + 1).ans(p.c + 1).ln();
            //System.out.println("Exp " + originalN + " Res " + validate + " Siz" + ans.size());
        }
    }

    private static class P {
        int r, c;

        P(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "(" + r + ", " + c + ")";
        }
    }
}
