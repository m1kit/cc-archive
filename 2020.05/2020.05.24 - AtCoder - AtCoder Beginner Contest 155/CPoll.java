package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashMap;
import java.util.Map;

public class CPoll {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Map<String, Integer> map = new HashMap<>();
        int n = in.ints();
        for (int i = 0; i < n; i++)  map.merge(in.string(), 1, Integer::sum);
        int min = map.values().stream().mapToInt(x -> x).max().orElse(0);
        map.entrySet().stream()
                .filter(e -> e.getValue() == min)
                .map(Map.Entry::getKey)
                .sorted()
                .forEach(out::ansln);
    }
}
