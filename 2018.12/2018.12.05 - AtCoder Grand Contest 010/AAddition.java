package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class AAddition {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int odd = 0;
        for (int i = 0; i < n; i++) {
            if (in.ints() % 2 == 1) {
                odd++;
            }
        }
        out.println(odd % 2 == 1 ? "NO" : "YES");
    }
}
