package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        in.voids();
        String s = in.string();
        String t = "b";
        for (int i = 0; i < 50; i++) {
            if (t.equals(s)) {
                out.println(i);
                return;
            }
            switch (i % 3) {
                case 0:
                    t = "a" + t + "c";
                    break;
                case 1:
                    t = "c" + t + "a";
                    break;
                case 2:
                    t = "b" + t + "b";
                    break;
            }
        }
        out.println(-1);
    }
}
