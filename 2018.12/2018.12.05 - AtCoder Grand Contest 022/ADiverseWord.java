package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.counting.Permutation;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ADiverseWord {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String m = in.string();
        if (m.equals("zyxwvutsrqponmlkjihgfedcba")) {
            out.println(-1);
        } else if (m.length() < 26) {
            boolean[] app = new boolean[26];
            for (char c : m.toCharArray()) {
                app[c - 'a'] = true;
            }
            for (int i = 0; i < 26; i++) {
                if (!app[i]) {
                    out.println(m + (char) (i + 'a'));
                    return;
                }
            }
        } else {
            String s = String.valueOf(ArrayUtil.toCharArray(Permutation.nextPermutation(m.chars().toArray())));
            while (s.substring(0, s.length() - 1).compareTo(m) > 0) {
                s = s.substring(0, s.length() - 1);
            }
            out.println(s);
        }
    }
}
