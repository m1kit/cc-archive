package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class BTreeBurning {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        long l = in.longs();
        int n = in.ints();
        long[] x = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = in.longs();
        }
        long ans = 0;
        // 最初に左
        long t = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                t += x[i / 2 + 1] - x[i / 2];
                t += 2 * (x[i] - x[i / 2 + 1]);
            } else {
                t += 2 * (x[i] - x[i / 2]);
            }
            long a = i * l - t;
            if (a > ans) {
                //System.out.println("LEFT i="+i+" a="+a);
                ans = a;
            }
        }

        for (int i = 1; i <= n; i++) {
            x[i] = l - x[i];
        }
        Arrays.sort(x);

        t = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                t += x[i / 2 + 1] - x[i / 2];
                t += 2 * (x[i] - x[i / 2 + 1]);
            } else {
                t += 2 * (x[i] - x[i / 2]);
            }
            long a = i * l - t;
            if (a > ans) {
                //System.out.println("RIGHT i="+i+" a="+a);
                ans = a;
            }
        }


        out.println(ans);
    }
}
