package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BBumbleBee {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        boolean[] f = new boolean[100_001];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = in.ints();
            if (f[a]) {
                ans++;
            }
            f[a] = true;
        }
        out.println(ans);
    }
}
