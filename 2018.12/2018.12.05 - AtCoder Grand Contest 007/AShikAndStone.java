package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class AShikAndStone {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int h = in.ints(), w = in.ints();
        String[] a = in.string(h);
        int c = 0;
        for (String row : a) {
            for (char column : row.toCharArray()) {
                if (column == '#') {
                    c++;
                }
            }
        }
        if (c == h + w - 1) {
            out.println("Possible");
        } else {
            out.println("Impossible");
        }
    }
}
