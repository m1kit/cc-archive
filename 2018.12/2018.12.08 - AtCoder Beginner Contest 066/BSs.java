package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BSs {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        for (int i = 1; i < s.length(); i++) {
            String r = s.substring(0, s.length() - i - 1);
            if (r.length() % 2 == 0) {
                String a = r.substring(0, r.length() / 2);
                String b = r.substring(r.length() / 2);
                if (a.equals(b)) {
                    out.println(r.length());
                    return;
                }
            }
        }
    }
}
