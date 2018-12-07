package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class ETree {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        if (s.charAt(0) == '0' || !new StringBuilder("0" + s).reverse().toString().equals("0" + s)) {
            out.println(-1);
            return;
        }
        int anc = s.length();
        for (int i = s.length() - 1; i > 0; i--) {
            out.print(i);
            out.print(' ');
            out.println(anc);
            if (s.charAt(i - 1) == '1') {
                anc = i;
            }
        }
    }
}
