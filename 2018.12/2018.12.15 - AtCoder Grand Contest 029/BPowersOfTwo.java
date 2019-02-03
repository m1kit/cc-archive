package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.io.PrintWriter;
import java.util.*;

public class BPowersOfTwo {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        boolean[] u = new boolean[n + 1];
        Arrays.sort(a);
        ArrayUtil.reverse(a, 0, n - 1);
        long ans = 0;
        outer: for (int i = 0; i < n - 1; i++) {
            if (u[i]) {
                continue;
            }
            for (int j = 32; j >= 0; j--) {
                long t = (1L << j) - a[i];
                int min = lower_bound(a, t, i + 1);
                if (min == n) {
                    continue;
                }
                while (min < n && u[min] && a[min] == t) {
                    min++;
                }
                if (min == n || a[min] != t) {
                    continue;
                }
                ans++;
                u[i] = true;
                u[min] = true;
                //System.out.println("FOUND: " + a[i] + " and " + a[min]);
                continue outer;
            }
        }
        out.println(ans);
    }

    private static int lower_bound(long[] a, long t, int min) {
        int max = a.length;
        while (min < max) {
            int mid = (min + max) / 2;
            if (t >= a[mid]) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
