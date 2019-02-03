package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BAdditionAndMultiplication {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), k = in.ints();
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans * 2, ans + k);
        }
        out.println(ans);
    }
}
