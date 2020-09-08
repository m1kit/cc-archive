package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class BGuidebook {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Restaurant[] restaurants = new Restaurant[n];
        for (int i = 0; i < n; i++) {
            restaurants[i] = new Restaurant(i, in.string(), in.ints());
        }
        Comparator<Restaurant> cmp = Comparator.comparing(restaurant -> restaurant.name);
        IntroSort.sort(restaurants, cmp.thenComparing(restaurant -> -restaurant.score));
        for (int i = 0; i < n; i++) {
            out.ans(restaurants[i].index + 1).ln();
        }
    }

    private static class Restaurant {
        int index;
        String name;
        int score;

        public Restaurant(int index, String name, int score) {
            this.index = index;
            this.name = name;
            this.score = score;
        }
    }
}
