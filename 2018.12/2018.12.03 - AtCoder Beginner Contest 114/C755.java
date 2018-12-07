package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class C755 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        out.println(f(n, 0, 0));
    }

    public int f(int n, long base, int mask) {
        base *= 10;
        int ans = 0;
        if (base + 3 <= n) {
            if ((mask | 1) == 7) {
                ans++;
            }
            ans += f(n, base + 3, mask | 1);
        }
        if (base + 5 <= n) {
            if ((mask | 2) == 7) {
                ans++;
            }
            ans += f(n, base + 5, mask | 2);
        }
        if (base + 7 <= n) {
            if ((mask | 4) == 7) {
                ans++;
            }
            ans += f(n, base + 7, mask | 4);
        }
        return ans;
    }
}
