package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class NTL_1_A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long n = in.longs();
        Map<Long, Integer> m = IntMath.primeFactorize(n);
        out.ans(n + ":");
        List<Map.Entry<Long, Integer>> ents = new ArrayList<>(m.entrySet());
        ents.sort(Comparator.comparing(Map.Entry::getKey));
        for (Map.Entry<Long, Integer> ent : ents) {
            for (int i = 0; i < ent.getValue(); i++) {
                out.ans(ent.getKey());
            }
        }
        out.ln();
    }
}
