package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;
import java.util.Comparator;

public class EMaxGCD {

    private static int n;
    private static long k;
    private static long[] a;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        n = in.ints();
        k = in.ints();
        a = in.longs(n);
        long sum = 0;
        long ans = 1;
        for (int i = 0; i < n; i++) sum += a[i];
        for (int i = 1; i * i <= sum; i++) {
            if (sum % i != 0) continue;
            if (calc(i)) ans = Math.max(ans, i);
            if (calc(sum / i)) ans = Math.max(ans, sum / i);
        }
        out.ans(ans).ln();
    }

    private static boolean calc(long g) {
        long cost = 0;
        Pair[] delta = new Pair[n];
        for (int i = 0; i < n; i++) {
            long d = a[i] - (a[i] / g * g);
            cost += d;
            delta[i] = new Pair(i, g - d);
        }

        IntroSort.sort(delta, Comparator.comparing(d -> d.cost));
        int req = (int) (cost / g);
        for (int i = 0; i < req; i++) {
            long v = a[delta[i].index];
            long d = v - (v / g * g);
            cost -= d;
            cost += delta[i].cost;
        }
        //System.out.println("g=" + g + " cost=" + cost + " d=" + Arrays.toString(delta));
        return cost <= 2 * k;
    }

    private static class Pair {
        int index;
        long cost;

        Pair(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
