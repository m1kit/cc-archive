package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.Vec3i;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DDirtyDeedsDoneDirtCheap {

    private static final int MOD = (int) 1e9 + 7;

    private static List<Integer> solve(int n, List<Vec3i> a) {
        a.sort(Comparator.comparing(v -> -v.y));
        int last = 1_000_000;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (last < a.get(i).x) continue;
            ans.add(a.get(i).z);
            last = a.get(i).y;
        }
        return ans;
    }

    @SuppressWarnings("SuspiciousNameCombination")
    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m;
        List<Vec3i> a = new ArrayList<>(), b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = in.ints(), y = in.ints();
            if (x < y) {
                a.add(new Vec3i(x, y, i + 1));
            } else {
                b.add(new Vec3i(-x, -y, i + 1));
            }
        }
        n = a.size();
        m = b.size();
        List<Integer> x = solve(n, a), y = solve(m, b);
        List<Integer> ans = x.size() > y.size() ? x : y;
        out.ans(ans.size()).ln();
        for (int i : ans) {
            out.ans(i);
        }
        out.ln();
    }
}
