package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class ABeginning {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int[] a = in.ints(4);
        int f = 0;
        for (int i = 0; i < 4; i++) {
            switch (a[i]) {
                case 1:
                    f |= 1;
                    break;
                case 9:
                    f |= 2;
                    break;
                case 7:
                    f |= 4;
                    break;
                case 4:
                    f |= 8;
                    break;
            }
        }
        if (f == 15) {
            out.ans(YES).ln();
        } else {
            out.ans(NO).ln();
        }
    }

}
