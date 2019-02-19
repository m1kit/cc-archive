package jp.llv.atcoder;

import jp.llv.atcoder.lib.geo.Vec2i;
import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.IntMath;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Stack;

public class DMatchMatching {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    private static int[] cost;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints(), m = in.ints();
        int[] tmp = in.ints(m);
        cost = new int[]{10001, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        for (int i = 1; i < 10; i++) {
            if (ArrayUtil.indexOf(tmp, i) == -1) {
                cost[i] = 10001;
            }
        }

        int min = 10001;
        int minid = -1;
        for (int i = 1; i < 10; i++) {
            if (cost[i] <= min) {
                min = cost[i];
                minid = i;
            }
        }


        int[] dp = new int[45];

        int[] p = {1, 1, 1, 1, 1, 0};

        outer: while (p[5] < 10) {
            p[0]++;
            for (int i = 0; i < 5 && p[i] > p[i + 1]; i++) {
                p[i] = 1;
                p[i + 1]++;
            }
            if (p[5] == 10) {
                break;
            }
            //System.out.println(Arrays.toString(p));

            int t = 0;
            int v = 0;
            for (int i = 5; i >= 0; i--) {
                v *= 10;
                v += p[i];
                t += cost[p[i]];
                //System.out.println(i + ": " + v + " for cost=" + t);
                if (t > 44) {
                    continue outer;
                } else {
                    dp[t] = Math.max(dp[t], v);
                }
            }
        }

        BigInteger max = BigInteger.ZERO;
        for (int i = 0; i <= 6; i++) {
            int c = n / cost[minid] - i;
            if (c < 0) {
                break;
            }

            int rem = n - c * cost[minid];
            int v = dp[rem];
            if (v == 0) {
                continue;
            }

            int low = 0;
            while (v > 0 && v % 10 < minid) {
                low *= 10;
                low += v % 10;
                v /= 10;
            }

            StringBuilder dec = new StringBuilder();
            if (v != 0) {
                dec.append(v);
            }
            for (int j = 0; j < c; j++) {
                dec.append((char) (minid + '0'));
            }
            if (low != 0) {
                dec.append(low);
            }

            //System.out.println(dec);

            BigInteger vec = new BigInteger(dec.toString().trim());
            if (max.compareTo(vec) < 0) {
                max = vec;
            }
        }

        out.ansln(max.toString());
    }


}
