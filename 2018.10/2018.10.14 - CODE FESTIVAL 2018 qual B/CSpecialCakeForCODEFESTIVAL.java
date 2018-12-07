package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;

public class CSpecialCakeForCODEFESTIVAL {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if ((x + y * 2) % 5 == 0
                        || y == 0 && x % 5 == 2
                        || x == 0 && y % 5 == 3
                        || y == n - 1 && (x + y * 2) % 5 == 3
                        || x == n - 1 && (x + y * 2) % 5 == 1
                ) {
                    out.print('X');
                } else {
                    out.print('.');
                }
            }
            out.println();
        }
    }
}
