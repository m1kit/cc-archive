package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class DSashaAndOneMoreName {

    private static final String YES = "Yes";
    private static final String NO = "Impossible";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        String s = in.string();
        int n = s.length();
        if (n % 2 == 0) {
            for (int i = 1; i < n; i++) {
                String low = s.substring(i, n), high = s.substring(0, i);
                String t = low + high;
                //System.out.println("Testing2(" + i + "): " + low + "-" + high);
                if (!s.equals(t)) {
                    String r = new StringBuilder(t.substring(0, n / 2)).reverse().toString();
                    if (r.equals(t.substring(n / 2, n))) {
                        out.ans(1).ln();
                        return;
                    }
                }
            }
        }

        for (int i = 1; i <= n / 2; i++) {
            String t = s.substring(n - i, n) + s.substring(i, n - i) + s.substring(0, i);
            //System.out.println("Testing("+i+"): " + t);
            if (!s.equals(t)) {
                out.ans(2).ln();
                return;
            }
        }
        out.ans(NO).ln();
    }
}
