package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CEvenPicture {

    private static final int[] DX = {0, 0, 0, 1, -1};
    private static final int[] DY = {0, 1, -1, 0, 0};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Set<Vec2i> ans = new HashSet<>();
        ans.add(new Vec2i(-1, -1));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                ans.add(new Vec2i(i + DX[j], i + DY[j]));
            }
        }
        ans.add(new Vec2i(n, n));
        out.ans(ans.size()).ln();
        for (Vec2i v : ans) {
            out.ans(v.x).ans(v.y).ln();
        }
    }

}
