package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class FTwoPizzas {

    private static final int MOD = (int) 1e9 + 7;
    private static final int N = 9;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[] favor = new int[n];
        for (int i = 0; i < n; i++) {
            int f = in.ints();
            for (int j = 0; j < f; j++) {
                int v = in.ints();
                favor[i] |= 1 << (v - 1);
            }
        }
        long[] price = new long[m];
        int[] pizza = new int[m];
        for (int i = 0; i < m; i++) {
            price[i] = in.longs();
            int f = in.ints();
            for (int j = 0; j < f; j++) {
                int v = in.ints();
                pizza[i] |= 1 << (v - 1);
            }
        }

        long[] costPartial = new long[1 << N];
        int[] pizzaPartial = new int[1 << N];
        Arrays.fill(costPartial, Long.MAX_VALUE);
        Arrays.fill(pizzaPartial, -1);
        for (int i = 0; i < 1 << N; i++) {
            for (int j = 0; j < m; j++) {
                if ((pizza[j] | i) == pizza[j] && price[j] < costPartial[i]) {
                    costPartial[i] = price[j];
                    pizzaPartial[i] = j;
                }
            }
        }
        //System.out.println(Arrays.toString(costPartial));

        long[] cost = new long[1 << N];
        int[] pizza0 = new int[1 << N], pizza1 = new int[1 << N];
        Arrays.fill(cost, Long.MAX_VALUE);
        Arrays.fill(pizza0, -1);
        Arrays.fill(pizza1, -1);
        for (int i = 0; i < 1 << N; i++) {
            for (int j = 0; j < m; j++) {
                int insufficient = i & (~pizza[j]);
                //System.out.println("insuf = " + insufficient + " cost =" + cost[insufficient]);
                if (costPartial[insufficient] == Long.MAX_VALUE) continue;
                //System.out.println("HER");
                long totalCost = price[j] + costPartial[insufficient];
                if (totalCost < cost[i]) {
                    cost[i] = totalCost;
                    pizza0[i] = j;
                    pizza1[i] = pizzaPartial[insufficient];
                }
            }
        }
        //System.out.println(Arrays.toString(cost));

        int max = -1;
        int ans0 = 0, ans1 = 1;
        long costRequired = price[0] + price[1];
        for (int i = 0; i < 1 << N; i++) {
            if (cost[i] == Long.MAX_VALUE) continue;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((favor[j] | i) == i) count++;
            }
            if (count > max || (count == max && costRequired > cost[i])) {
                max = count;
                ans0 = pizza0[i];
                ans1 = pizza1[i];
                costRequired = cost[i];
            }
        }
        if (ans0 == ans1) {
            long min = Long.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                if (i != ans0 && price[i] < min) {
                    min = price[i];
                    ans1 = i;
                }
            }
        }

        out.ans(Math.min(ans0, ans1) + 1).ans(Math.max(ans0, ans1) + 1).ln();
    }
}
