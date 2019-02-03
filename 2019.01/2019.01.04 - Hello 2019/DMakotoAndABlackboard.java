package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;
import jp.llv.atcoder.lib.math.mod.Factorial;
import jp.llv.atcoder.lib.math.mod.ModMath;
import jp.llv.atcoder.lib.structure.vector.Vec2l;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

public class DMakotoAndABlackboard {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final ModMath mod = new ModMath(MOD);
    private static Factorial fact = mod.getFactorial(51);
    private static final long[] invt = new long[52];

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        long n = in.longs(); // < 2^50
        int k = in.ints();
        for (int i = 1; i < invt.length; i++) {
            invt[i] = mod.inv(i);
        }
        //*
        long ans = 1;
        Map<Long, Integer> pf = IntMath.primeFactorize(n);
        for (Map.Entry<Long, Integer> e : pf.entrySet()) {
            ans *= calc(e.getKey(), e.getValue(), k);
            ans %= MOD;
        }
        out.println(ans);
        //*/
    }

    public static long calc(long d, int m, int k) {
        //System.out.println("d=" + d + " m=" + m + " k=" + k);
        long[] dp = new long[m + 1];
        long down = invt[m + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < k; i++) {
            //System.out.println(Arrays.toString(dp));
            long t = 0;
            for (int j = m; j >= 0; j--) {
                t += (dp[j] * fact.fact(m + 1) % MOD) * invt[j + 1];
                t %= MOD;
                dp[j] = t;
            }
            down *= fact.factinv(m + 1);
            down %= MOD;
        }
        //System.out.println(Arrays.toString(dp));
        long ans = 0;
        long pow = 1;
        d %= MOD;
        for (int i = 0; i <= m; i++) {
            ans += dp[i] * pow;
            ans %= MOD;
            pow *= d;
            pow %= MOD;
        }
        //System.out.println("bumbo=" + ans);
        ans *= down;
        ans %= MOD;
        //System.out.println("bumsi=" + ans);
        return ans;
    }

}
