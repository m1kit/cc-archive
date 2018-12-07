package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class CSugarWater {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int a = in.ints(), b = in.ints(), c = in.ints(), d = in.ints();
        int e = in.ints(), f = in.ints();
        int maxs = 1;
        int maxm = 0;

        for (int x = 0; x <= 30; x++) {
            int rdx = f - 100 * a * x;
            for (int y = 0; y * 100 <= rdx; y++) {
                int n = a * x + b * y;
                int cap = n * e;
                int rdy = rdx - 100 * b * y;
                for (int z = 0; z * c <= rdy && c * z <= cap; z++) {
                    int rdz = rdy - c * z;
                    for (int w = 0; d * w <= rdz && (c * z + d * w) <= cap; w++) {
                        int m = c * z + d * w;
                        int s = 100 * n + m;
                        if (maxm * s <= m * maxs) {
                            maxm = m;
                            maxs = s;
                        }
                    }
                }
            }
        }
        out.println(maxs + " " + maxm);
    }
}
