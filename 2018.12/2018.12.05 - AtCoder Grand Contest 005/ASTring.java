package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class ASTring {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String x = in.string();
        int ans = x.length();
        int stack = 0;
        for (char c : x.toCharArray()) {
            if (c == 'S') {
                stack++;
            } else if (stack > 0) {
                stack--;
                ans -= 2;
            }
        }
        out.println(ans);
    }
}
