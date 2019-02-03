package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class CChristmasEve {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), k = in.ints();
        int[] h = in.ints(n);
        Arrays.sort(h);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            ans = Math.min(ans, h[i + k - 1] - h[i]);
        }
        out.println(ans);
    }
}
