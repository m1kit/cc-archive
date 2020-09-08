package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class DNumberOfPermutations {

    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        ModMath mod = new ModMath(MOD);
        Factorial fact = mod.getFactorial(n + 1);
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) pairs[i] = new Pair(in.ints(), in.ints());
        long bada = 1, badb = 1, badc = 1;
        {
            IntroSort.sort(pairs, Comparator.comparing(p -> p.a));
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (pairs[i - 1].a == pairs[i].a) cnt++;
                else {
                    bada *= fact.fact(cnt);
                    bada %= MOD;
                    cnt = 1;
                }
            }
            bada = bada * fact.fact(cnt) % MOD;
        }
        {
            IntroSort.sort(pairs, Comparator.comparing(p -> p.b));
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (pairs[i - 1].b == pairs[i].b) cnt++;
                else {
                    badb *= fact.fact(cnt);
                    badb %= MOD;
                    cnt = 1;
                }
            }
            badb = badb * fact.fact(cnt) % MOD;
        }
        {
            IntroSort.sort(pairs, Comparator.comparing(p -> p.a * 1_000_000L + p.b));
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (pairs[i - 1].b > pairs[i].b) badc = 0;
                else if (pairs[i - 1].equals(pairs[i])) cnt++;
                else {
                    badc *= fact.fact(cnt);
                    badc %= MOD;
                    cnt = 1;
                }
            }
            badc = badc * fact.fact(cnt) % MOD;
        }
        long ans = fact.fact(n);
        ans += MOD - bada;
        ans += MOD - badb;
        ans += badc;
        ans %= MOD;
        //System.out.printf("a=%d b=%d c=%d\n", bada, badb, badc);
        out.ans(ans).ln();
    }

    class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (a != pair.a) return false;
            return b == pair.b;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }
    }
}
