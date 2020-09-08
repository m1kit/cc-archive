package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;

import java.util.*;

public class JConnectedCheckerboard {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Set<Vec2i> ans = new HashSet<>();
        for (int i = 1; i < n; i += 2) {
            ans.add(new Vec2i(i, 0));
            ans.add(new Vec2i(0, i));
        }
        for (int i = n % 2; i < n; i += 2) {
            ans.add(new Vec2i(i, n - 1));
            ans.add(new Vec2i(n - 1, i));
        }
        int offset = 0;
        int d = 2;
        for (int unused = 0; unused < 10; unused++) {
            for (int i = 1; i < n; i += 2 * d) {
                for (int j = offset; j < n; j += 2 * d) {
                    ans.add(new Vec2i(i, j));
                }
            }
            for (int i = d + 1; i < n; i += 2 * d) {
                for (int j = offset + d; j < n; j += 2 * d) {
                    ans.add(new Vec2i(i, j));
                }
            }

            offset += d;
            d *= 2;
        }

        out.ans(ans.size()).ln();
        for (Vec2i an : ans) {
            out.ans(an.x).ans(an.y).ln();
        }
    }
}
