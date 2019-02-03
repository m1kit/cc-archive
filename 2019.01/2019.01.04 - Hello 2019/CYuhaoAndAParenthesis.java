package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;

public class CYuhaoAndAParenthesis {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long ans = 0;
        int[] a = new int[500_001];
        for (int i = 0; i < n; i++) {
            String s = in.string();
            int plus = 0, minus = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    plus++;
                } else {
                    if (plus > 0) {
                        plus--;
                    } else {
                        minus++;
                    }
                }
            }
            if (plus != 0 && minus != 0) {
                continue;
            }
            if (plus > 0) {
                if (a[plus] < 0) {
                    ans++;
                }
                a[plus]++;
            } else if (minus > 0) {
                if (a[minus] > 0) {
                    ans++;
                }
                a[minus]--;
            } else {
                a[0]++;
            }
        }
        out.println(ans + (a[0] / 2));
    }
}
