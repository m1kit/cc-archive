package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

import java.util.*;

public class BLynyrdSkynyrd {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints(), q = in.ints();
        int[] p = new int[n], pr = new int[n], a = new int[m];
        for (int i = 0; i < n; i++) {
            p[i] = in.ints() - 1;
            pr[p[i]] = i;
        }
        for (int i = 0; i < m; i++) a[i] = in.ints() - 1;

        List<List<Integer>> loop = new ArrayList<>();
        for (int i = 0; i < n; i++) loop.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            loop.get(a[i]).add(i);
        }

        int[][] next = new int[20][m];
        for (int i = 0; i < m; i++) {
            int v = p[(pr[a[i]] + 1) % n];
            List<Integer> indices = loop.get(v);
            if (indices.isEmpty()) {
                next[0][i] = -1;
                continue;
            }
            int min = 0, max = indices.size();
            while (max - min > 0) {
                int mid = (min + max) / 2;
                if (indices.get(mid) <= i) {
                    min = mid + 1;
                } else {
                    max = mid;
                }
            }

            if (min == indices.size()) {
                next[0][i] = -1;
            } else {
                next[0][i] = indices.get(min);
            }
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 0; j < m; j++) {
                if (next[i - 1][j] == -1) {
                    next[i][j] = -1;
                } else {
                    next[i][j] = next[i - 1][next[i - 1][j]];
                }
            }
        }

        long[] nlate = new long[m];
        outer: for (int i = 0; i < m; i++) {
            int cur = i;
            for (int j = 19; j >= 0; j--) {
                if (((n - 1) & (1 << j)) == 0) {
                    continue;
                }
                cur = next[j][cur];
                if (cur == -1) {
                    nlate[i] = Long.MAX_VALUE;
                    continue outer;
                }
            }
            nlate[i] = cur;
        }

        IntSegmentTree st = new IntSegmentTree(nlate, Math::min, Long.MAX_VALUE, (x, u) -> 0);
        for (int i = 0; i < q; i++) {
            int l = in.ints() - 1, r = in.ints();
            if (st.query(l, r) < r) {
                out.print('1');
            } else {
                out.print('0');
            }
        }
        out.ln();
        //System.out.println(Arrays.toString(nlate));
    }
}
