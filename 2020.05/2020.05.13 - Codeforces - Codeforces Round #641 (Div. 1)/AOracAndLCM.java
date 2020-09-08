package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.structure.sparsetable.IntSparseTable;

public class AOracAndLCM {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        IntSparseTable st = new IntSparseTable(a, IntMath::gcd);
        long ans = 1;
        for (int i = 0; i < n; i++) {
            long l = i == 0 ? 0 : st.query(0, i), r = i + 1 == n ? 0 : st.query(i + 1, n);
            long g = IntMath.gcd(l, r);
            ans = IntMath.lcm(ans, g);
        }
        out.ans(ans).ln();
    }
}
