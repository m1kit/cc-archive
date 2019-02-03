package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BTwoAnagrams {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        char[] s = in.string().toCharArray();
        char[] t = in.string().toCharArray();
        Arrays.sort(s);
        Arrays.sort(t);
        ArrayUtil.reverse(t, 0, t.length - 1);
        if (String.valueOf(s).compareTo(String.valueOf(t)) < 0) {
            out.println(YES);
        } else {
            out.println(NO);
        }
    }
}
