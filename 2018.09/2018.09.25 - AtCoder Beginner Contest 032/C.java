package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class C {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int[] s = IntStream.range(0, n).map(o -> in.nextInt()).toArray();
        int l = 0, r = 0;
        long t = s[0];
        int ans = 0;
        while (r < n) {
            if (s[r] == 0) {
                out.println(n);
                return;
            }
            if (t > k) {
                if (l == r) {
                    r = ++l;
                    if (r < n) {
                        t = s[r];
                    }
                } else {
                    t /= s[l];
                    l++;
                }
            } else {
                ans = Math.max(ans, r - l + 1);
                r++;
                if (r < n) {
                    t *= s[r];
                }
            }
        }
        out.println(ans);
    }
}
