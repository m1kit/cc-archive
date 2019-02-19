package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.structure.UnionFind;

public class BPath {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int[] c = new int[4];
        for (int i = 0; i < 3; i++) {
            c[in.ints() - 1]++;
            c[in.ints() - 1]++;
        }
        for (int i = 0; i < 4; i++) {
            if (c[i] > 2) {
                out.ans(NO).ln();
                return;
            }
        }
        out.ans(YES).ln();
    }
}
