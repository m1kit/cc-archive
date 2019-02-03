package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;

public class BLettersRearranging {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int t = in.ints();
        for (int i = 0; i < t; i++) {
            String s = in.string();
            if (s.chars().distinct().count() == 1) {
                out.println(-1);
            } else {
                s.chars().sorted().forEach(c -> out.print((char) c));
                out.println();
            }
        }
    }
}
