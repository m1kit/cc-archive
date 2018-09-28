package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;

import java.io.PrintWriter;

public class CTakahashisInformation {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int[][] c = in.ints(3, 3);
        for (int i = 0; i < 3; i++) {
            int min = IntMath.min(c[i]);
            for (int j = 0; j < 3; j++) {
                c[i][j] -= min;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (c[0][i] != c[1][i] || c[1][i] != c[2][i]) {
                out.println(NO);
                return;
            }
        }
        out.println(YES);
    }
}
