package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.io.PrintWriter;
import java.util.Arrays;

public class BN {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] rs = in.ints(n);
        Arrays.sort(rs);
        ArrayUtil.reverse(rs, 0, n - 1);
        double size = 0;
        for (int i = 0; i < n; i++) {
            int r = rs[i];
            double s = Math.PI * r * r;
            if (i % 2 == 0) {
                size += s;
            } else {
                size -= s;
            }
        }
        out.println(size);
    }
}
