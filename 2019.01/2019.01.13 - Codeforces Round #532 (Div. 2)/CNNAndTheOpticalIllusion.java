package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class CNNAndTheOpticalIllusion {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        double n = in.doubles();
        double r = in.doubles();
        double sine = Math.sin(Math.PI / n);
        out.ans(r * sine / (1 - sine), 7).ln();
    }
}
