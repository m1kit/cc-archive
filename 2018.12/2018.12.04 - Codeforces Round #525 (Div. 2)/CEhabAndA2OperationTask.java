package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class CEhabAndA2OperationTask {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long x = 0;
        out.println(n + 1);
        for (int i = n - 1; i >= 0; i--) {
            long d = (n + i - ((a[i] + x) % n)) % n;
            out.println("1 " + (i + 1) + " " + d);
            x += d;
        }
        out.println("2 " + n + " " + n);
    }
}
