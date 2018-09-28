package jp.llv.atcoder;

import java.util.*;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class DSimpleKnapsack {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    private static int n;
    private static int[] w;
    private static int[] v;
    private static final Map<Key, Integer> dp = new HashMap<>();

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        dp.clear();
        n = in.nextInt();
        int wa = in.nextInt();
        w = new int[n];
        v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            v[i] = in.nextInt();
        }
        out.println(calc(new Key(0, wa)));
        // System.out.println(dp);
    }

    private int calc(Key key) {
        if (key.index == n) {
            return 0;
        } else if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int ans = calc(new Key(key.index + 1, key.toughness));
        int nt = key.toughness - w[key.index];
        if (nt >= 0) {
            ans = Math.max(ans, calc(new Key(key.index + 1, nt)) + v[key.index]);
        }
        dp.put(key, ans);
        return ans;
    }

    private static class Key {
        int index, toughness;

        public Key(int index, int toughness) {
            this.index = index;
            this.toughness = toughness;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return index == key.index &&
                    toughness == key.toughness;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, toughness);
        }

        @Override
        public String toString() {
            return "Key(" +
                    index +
                    ", " + toughness +
                    ')';
        }
    }

}
