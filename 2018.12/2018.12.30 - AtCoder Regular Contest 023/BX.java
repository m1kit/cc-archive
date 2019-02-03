package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BX {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int r = in.ints(), c = in.ints(), d = in.ints();
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int a = in.ints();
                if ((i + j) % 2 == d % 2 && (i + j) <= d) {
                    ans = Math.max(ans, a);
                }
            }
        }
        out.println(ans);
    }
}
