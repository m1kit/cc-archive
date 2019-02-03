package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BUnhappyHackingABCEdit {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        StringBuilder d = new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '0':
                    d.append("0");
                    break;
                case '1':
                    d.append("1");
                    break;
                case 'B':
                    if (d.length() > 0) {
                        d.setLength(d.length() - 1);
                        d.trimToSize();
                    }
                    break;
            }
        }
        out.println(d);
    }
}
