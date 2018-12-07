package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int r = in.ints(), n = in.ints(), m = in.ints();
        double d = 2.0 * r / n;
        double ans = 0;
        for (int i = 1; i < n + m; i++) {
            double y1 = r - i * d;
            double y2 = r - (i - m) * d;
            ans += Math.max(cut(r, y1), cut(r, y2));
        }
        out.println(BigDecimal.valueOf(ans).toPlainString());
    }

    private static double cut(double r, double y) {
        if (y < -r || r < y) {
            return 0.0;
        }
        return 2 * Math.sqrt(r * r - y * y);
    }
}
