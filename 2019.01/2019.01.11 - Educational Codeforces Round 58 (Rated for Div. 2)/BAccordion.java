package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;

import java.util.Arrays;

public class BAccordion {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String s = in.string();
        int k = 0;
        int[] v = new int[s.length()];
        int t = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (t) {
                case 0:
                    if (s.charAt(i) == '[') {
                        t++;
                    }
                    v[i] = -1;
                    break;
                case 1:
                    if (s.charAt(i) == ':') {
                        t++;
                    }
                    v[i] = -1;
                    break;
                case 2:
                    if (s.charAt(i) == '|') {
                        k++;
                    }
                    v[i] = k;
                    break;
            }
        }
        if (t < 2) {
            out.ans(-1).ln();
            return;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (t) {
                case 2:
                    if (s.charAt(i) == ']') {
                        t--;
                    }
                    break;
                case 1:
                    if (s.charAt(i) == ':') {
                        out.ans(v[i] >= 0 ? v[i] + 4 : -1).ln();
                        return;
                    }
                    break;
            }
        }
    }
}
