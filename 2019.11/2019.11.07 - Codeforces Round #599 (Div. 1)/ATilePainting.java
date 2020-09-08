package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.Map;

public class ATilePainting {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long n = in.longs();
        out.ans(calc(n));

        /*for (int m = 1; m <= 2000; m++) {
            IntUnionFind uf = new IntUnionFind(m);
            for (int w = 2; w < m; w++) {
                if (m % w != 0) continue;
                for (int i = 0; i < m - w; i++) {
                    uf.union(i, i + w);
                }
            }

            if (uf.size() != calc(m)) {
                System.out.println("ERROR " + m);
            }
        }*/


    }

    private static long calc(long n) {
        for (long i = 2; i * i <= n; i++) {
            if (n % i != 0) continue;
            while (n % i == 0) n /= i;
            return n == 1 ? i : 1;
        }
        return n;
    }
}
