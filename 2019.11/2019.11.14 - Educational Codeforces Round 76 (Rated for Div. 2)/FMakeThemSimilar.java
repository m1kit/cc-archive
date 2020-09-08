package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.math.BitMath;

import java.util.*;

public class FMakeThemSimilar {

    private static final int MASK = (1 << 15) - 1;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] high = new int[n], low = new int[n];
        for (int i = 0; i < n; i++) {
            int x = in.ints();
            high[i] = ((x >> 15) & MASK);
            low[i] = ((x) & MASK);
            if (BitMath.count(low[i]) > 15) throw new RuntimeException();
        }

        Map<Tuple, Integer> map = new HashMap<>();
        for (int i = 0; i < (1 << 15); i++) {
            int max = 0;
            for (int j = 0; j < n; j++) max = Math.max(max, BitMath.count(low[j] ^ i));
            Tuple al = new Tuple(n);
            if (max >= 16) {
                for (int j = 0; j < n; j++) {
                    if (BitMath.count(low[j] ^ i) >= 16) {
                        throw new RuntimeException(Integer.toBinaryString(i) + " with " + j + "th number is " + Integer.toBinaryString(low[j]) + " and has count " + BitMath.count(low[j] ^ i));
                    }
                }
            }
            for (int j = 0; j < n; j++) al.set(j, max - BitMath.count(low[j] ^ i));
            if (!map.containsKey(al)) map.put(al, i);
        }
        for (int i = 0; i < (1 << 15); i++) {
            int min = 16;
            for (int j = 0; j < n; j++) min = Math.min(min, BitMath.count(high[j] ^ i));
            Tuple al = new Tuple(n);
            for (int j = 0; j < n; j++) al.set(j, BitMath.count(high[j] ^ i) - min);
            if (map.containsKey(al)) {
                out.ans((i << 15) | map.get(al)).ln();
                return;
            }
        }
        out.ans(-1).ln();
    }

    private static class Tuple {
        byte[] a;

        Tuple(int n) {
            this.a = new byte[n];
        }

        int set(int i, int x) {
            a[i] = (byte) x;
            return x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple that = (Tuple) o;
            return Arrays.equals(a, that.a);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(a);
        }
    }
}
