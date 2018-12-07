package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class D {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), a = in.ints();
        BigInteger k = in.bigints();
        int[] b = in.ints(n);
        int[] s = new int[n + 1];
        Arrays.fill(s, -1);
        s[a] = 0;
        int p = a;
        int c = 1;
        while (s[b[p - 1]] < 0) {
            if (k.equals(BigInteger.valueOf(c))) {
                out.println(b[p - 1]);
                return;
            }
            s[b[p - 1]] = c;
            p = b[p - 1];
            c++;
        }
        k = k.subtract(BigInteger.valueOf(s[b[p - 1]])).mod(BigInteger.valueOf(c - s[b[p - 1]]));
        c = 0;
        while (k.compareTo(BigInteger.valueOf(c)) > 0) {
            c++;
            p = b[p - 1];
        }
        out.println(b[p - 1]);
    }
}
