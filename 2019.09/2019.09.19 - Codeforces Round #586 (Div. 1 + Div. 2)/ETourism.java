package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.WithMoreStack;

import java.util.ArrayList;
import java.util.List;

public class ETourism {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        WithMoreStack.run(() -> {
            int n = in.ints(), m = in.ints();
            City[] cities = new City[n];
            for (int i = 0; i < n; i++) {
                cities[i] = new City(i, in.longs());
            }
            for (int i = 0; i < m; i++) {
                int x = in.ints() - 1, y = in.ints() - 1;
                cities[x].neighbor.add(cities[y]);
                cities[y].neighbor.add(cities[x]);
            }
            int s = in.ints() - 1;
            cities[s].dfs(null);
            long base = 0;
            for (int i = 0; i < n; i++) {
                cities[i].visited = false;
                if (cities[i].cyclic) base += cities[i].value;
            }
            out.ans(base + cities[s].solve(null)).ln();
        });
    }

    private static class City {
        int index;
        long value;
        List<City> neighbor = new ArrayList<>();
        boolean visited;
        boolean cyclic;

        City(int index, long value) {
            this.index = index;
            this.value = value;
        }

        boolean dfs(City from) {
            visited = true;
            for (City city : neighbor) {
                if (city == from) continue;
                if (city.visited || city.dfs(this)) cyclic = true;
            }
            return cyclic;
        }

        long solve(City from) {
            long max = 0;
            visited = true;
            for (City city : neighbor) {
                if (city == from || city.visited) continue;
                max = Math.max(max, city.solve(this));
            }
            if (!cyclic) max += value;
            return max;
        }
    }
}
