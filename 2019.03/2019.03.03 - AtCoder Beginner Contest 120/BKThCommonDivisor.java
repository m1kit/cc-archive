package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class BKThCommonDivisor {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        List<Integer> d = new ArrayList<>();
        int a = in.ints(), b = in.ints(), k = in.ints();
        for (int i = 1; i <= 100; i++) {
            if (a % i == 0 && b % i == 0) {
                d.add(i);
            }
        }
        out.ansln(d.get(d.size() - k));
    }
}
