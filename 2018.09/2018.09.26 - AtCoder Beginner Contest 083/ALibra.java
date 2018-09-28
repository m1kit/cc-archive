package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class ALibra {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int t = in.ints() + in.ints() - in.ints() - in.ints();
        if (t == 0) {
            out.println("Balanced");
        } else if (t < 0) {
            out.println("Right");
        } else {
            out.println("Left");
        }

    }
}
