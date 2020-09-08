package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BNewYearAndAscentSequence {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        List<Integer> mins = new ArrayList<>(), maxs = new ArrayList<>();
        long ascs = 0;
        for (int i = 0; i < n; i++) {
            int l = in.ints();
            boolean asc = false;
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int j = 0; j < l; j++) {
                int x = in.ints();
                if (min < x) asc = true;
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
            if (asc) {
                ascs++;
                continue;
            }
            mins.add(min);
            maxs.add(max);
        }
        long ans = ascs * ascs + ascs * (n - ascs) * 2;
        mins.sort(Comparator.naturalOrder());
        for (int x : maxs) {
            int ok = -1, ng = mins.size();
            while (ng - ok > 1) {
                int mid = (ok + ng) / 2;
                if (mins.get(mid) < x) ok = mid;
                else ng = mid;
            }
            ans += ng;
            //System.out.println("x="+x+" ans="+ng);
        }
        out.ans(ans).ln();
    }
}
