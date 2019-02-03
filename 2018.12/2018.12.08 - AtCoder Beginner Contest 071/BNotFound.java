package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;

public class BNotFound {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        boolean[] a = new boolean[26];
        s.chars().forEach(c -> a[c - 'a'] = true);
        for (char c = 'a'; c <= 'z'; c++) {
            if (!a[c - 'a']) {
                out.println(c);
                return;
            }
        }
        out.println("None");
    }
}
