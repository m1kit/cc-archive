package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class BIrohaLovesStringsABCEdition {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        in.voids();
        String[] s = in.string(n);
        Arrays.sort(s);
        out.println(String.join("", s));
    }
}
