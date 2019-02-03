package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.Arrays;

public class BMedianPyramidEasy {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), x = in.ints();
        if (x == 1 || x == 2 * n - 1) {
            out.println(NO);
            return;
        }
        out.println(YES);
        int[] ans = new int[2 * n - 1];
        if (x == 2 * n - 2 && n > 2) {
            ans[n - 2] = x - 2;
            ans[n - 1] = x + 1;
            ans[n] = x;
            ans[n + 1] = x - 1;
            int m = 1;
            for (int i = 0; i < 2 * n - 1; i++) {
                if (i == n - 2) {
                    i = n + 2;
                    if (i >= 2 * n - 1) {
                        break;
                    }
                }
                if (m == x - 2) {
                    m = x + 2;
                }
                ans[i] = m;
                m++;
            }
        } else {
            ans[n - 2] = x + 1;
            ans[n - 1] = x;
            ans[n] = x - 1;
            if (n > 2) {
                ans[n + 1] = x + 2;
            }
            int m = 1;
            for (int i = 0; i < 2 * n - 1; i++) {
                if (i == n - 2) {
                    i = n + 2;
                    if (i >= 2 * n - 1) {
                        break;
                    }
                }
                if (m == x - 1) {
                    m = x + 3;
                }
                ans[i] = m;
                m++;
            }
        }
        Arrays.stream(ans).forEach(out::println);
    }
}
