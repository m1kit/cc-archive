package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class ADigitSum2 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String n = in.string();
        int ans = 0;
        boolean filled = true;
        for (int i = 1; i < n.length(); i++) {
            if (n.charAt(i) != '9') {
                filled = false;
            }
            ans += 9;
        }
        ans += Integer.parseInt(n.substring(0, 1));
        if (!filled) {
            ans -= 1;
        }
        out.println(ans);
    }
}
