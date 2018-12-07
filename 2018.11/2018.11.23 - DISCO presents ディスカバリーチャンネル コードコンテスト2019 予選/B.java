package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isIn(n, i, j) && isIn(n, i + 1, j) && isIn(n, i, j + 1) && isIn(n, i + 1, j + 1)) {
                    ans++;
                }
            }
        }
        out.println(ans);
    }

    private boolean isIn(double n, double x, double y) {
        double d = n / 2.0;
        return y >= d - x && y >= x - d && y <= x + d && y <= 3 * d - x;
    }
}
