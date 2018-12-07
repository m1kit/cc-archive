package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class AAtCoderGroupContest {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(3 * n);
        Arrays.sort(a);
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += a[3 * n - i * 2];
        }
        out.println(sum);
    }
}
