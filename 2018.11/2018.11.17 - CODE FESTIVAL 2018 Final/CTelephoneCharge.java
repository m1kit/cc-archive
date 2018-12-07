package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class CTelephoneCharge {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        Plan[] plans = new Plan[n];
        for (int i = 0; i < n; i++) {
            plans[i] = new Plan(in.longs(), in.longs());
        }
        Arrays.sort(plans, Comparator.comparing(plan -> plan.max));

        int m = in.ints();
        for (int i = 0; i < m; i++) {
            long t = in.longs();
            int min = 0, max = n;
            while (max - min > 1) {
                int mid = (min + max) / 2;
                if (plans[mid].max <= t) {
                    min = mid;
                } else {
                    max = mid;
                }
            }
            if (max < plans.length) {
                out.println(Math.min(plans[min].calc(t), plans[max].calc(t)));
            } else {
                out.println(plans[min].calc(t));
            }
        }
    }

    private static class Plan {

        private final long max;
        private final long price;

        public Plan(long max, long price) {
            this.max = max;
            this.price = price;
        }

        private long calc(long x) {
            return price + Math.max(0, x - max);
        }
    }
}
