package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class CLiningUp {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        int[] b = new int[n];
        for (int d : a) {
            if ((n - d) % 2 == 0 || ++b[d] > 2) {
                out.println(0);
                return;
            }
        }
        if (n % 2 == 1 && b[0] > 1) {
            out.println(0);
            return;
        }
        out.println(pow(2, n / 2));
    }

    private static long pow(long x, long y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            long z = pow(x, y / 2);
            return (z * z) % MOD;
        } else {
            return (x % MOD) * pow(x, y - 1) % MOD;
        }
    }
}
