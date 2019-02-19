package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.mod.Factorial;
import jp.llv.atcoder.lib.math.mod.ModMath;
import jp.llv.atcoder.lib.structure.IntSegmentTree;

import java.util.Arrays;

public class K {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        long[] c = new long[n + 1];
        ModMath mod = new ModMath();
        Factorial fact = mod.getFactorial(n + 1);
        Arrays.fill(c, 1);
        c[0] = 0;
        IntSegmentTree st = new IntSegmentTree(c, (x, y) -> x + y, 0, (x, q) -> q);
        int[] a = in.ints(n);
        long ans = 1;
        for (int i = 0; i < n; i++) {
            st.update(a[i], 0);
            long m = st.query(0, a[i]);
            m *= fact.fact(n - i - 1);
            m %= MOD;
            ans += m;
            ans %= MOD;
        }
        out.ansln(ans);
    }
}
