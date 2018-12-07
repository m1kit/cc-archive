package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;

import java.io.PrintWriter;
import java.util.stream.IntStream;

public class AGettingDifference {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), k = in.ints();
        int[] a = in.ints(n);
        int max  = IntStream.of(a).max().orElse(0);
        int gcm = -1;
        for (int x : a) {
            if (x == max) {
            } else if (gcm < 0) {
                gcm = max - x;
            } else {
                gcm = IntMath.gcd(gcm, max - x);
            }
        }
        if (k <= max && (max - k) % gcm == 0) {
            out.println("POSSIBLE");
        } else {
            out.println("IMPOSSIBLE");
        }
    }
}
