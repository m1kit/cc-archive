package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BTemplateMatching {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints();
        String[] a = in.string(n), b = in.string(m);
        for (int i = 0; i <= n - m; i++) {
            outer: for (int j = 0; j <= n - m; j++) {
                for (int y = 0; y < m; y++) {
                    for (int x = 0; x < m; x++) {
                        if (b[y].charAt(x) != a[i + y].charAt(j + x)) {
                            continue outer;
                        }
                    }
                }
                out.println(YES);
                return;
            }
        }
        out.println(NO);
    }
}
