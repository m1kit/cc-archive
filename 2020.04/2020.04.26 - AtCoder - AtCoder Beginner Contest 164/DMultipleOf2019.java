package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class DMultipleOf2019 {

    private static final int MOD = 2019;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        ModMath mod = new ModMath(MOD);
        int[] a = in.string().chars().map(c -> c - '0').toArray();
        int n = a.length;
        ArrayUtil.reverse(a, 0, n);
        int base = 1;
        int[] s = new int[n + 1], cnt = new int[MOD];
        cnt[s[0] = 0]++;
        for (int i = 0; i < n; i++) {
            cnt[s[i + 1] = (s[i] + base * a[i]) % MOD]++;
            base = base * 10 % MOD;
        }
        //System.out.println(Arrays.toString(s));
        long ans = 0;
        for (int i = 0; i < MOD; i++)  ans += cnt[i] * (cnt[i] - 1L) / 2;
        out.ans(ans).ln();
    }
}
