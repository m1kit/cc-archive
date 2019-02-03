package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BBeautifulStrings {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String w = in.string();
        int[] c = new int[26];
        w.chars().forEach(x -> c[x - 'a']++);
        for (int x : c) {
            if (x % 2 == 1) {
                out.println(NO);
                return;
            }
        }
        out.println(YES);
    }
}
