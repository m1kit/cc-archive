package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class BSnakeToy {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), k = in.ints();
        int[] l = in.ints(n);
        Arrays.sort(l);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += l[n - i - 1];
        }
        out.println(ans);
    }
}
