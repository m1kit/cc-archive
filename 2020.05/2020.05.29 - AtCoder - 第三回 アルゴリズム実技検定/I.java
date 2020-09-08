package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;
import java.util.stream.IntStream;

public class I {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[][] p = {IntStream.range(0, n).toArray(), IntStream.range(0, n).toArray()};
        int t = 0;
        int q = in.ints();
        for (int i = 0; i < q; i++) {
            int type = in.ints();
            if (type <= 2) {
                int a = in.ints() - 1, b = in.ints() - 1;
                int x = (type - 1) ^ t;
                //System.out.println("Swap " + (x == 0 ? "row" : "col") + " " + a + " <=> " + b);
                int tmp = p[x][a];
                p[x][a] = p[x][b];
                p[x][b] = tmp;
                //System.out.println(Arrays.toString(p[0]));
                //System.out.println(Arrays.toString(p[1]));
            } else if (type == 3) {
                t = 1 - t;
            } else {
                int a = in.ints() - 1, b = in.ints() - 1;
                int r = t == 0 ? a : b, c = t == 0 ? b : a;
                r = p[0][r];
                c = p[1][c];
                out.ans(r * (long) n + c).ln();
            }
        }
    }
}
