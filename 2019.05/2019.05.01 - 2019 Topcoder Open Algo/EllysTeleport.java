package dev.mikit.atcoder;

import java.util.Arrays;
import java.util.BitSet;

public class EllysTeleport {
    public int getMax(int n, int h1, int a, int b, int p, int q, int m) {
        Platform[] h = new Platform[n];
        h[0] = new Platform(0, h1);
        for (int i = 1; i < n; i++)  h[i] = new Platform(i, (h[i - 1].height * a + b) % m);
        Arrays.sort(h);
        for (int i = 0; i < n; i++) {
            long dh = (h[i].height * p + q) % m;
            for (int j = n - 1; j >= 0; j--) {
                if (h[j].height <= dh) {
                    h[i].dest = h[j];
                    break;
                }
            }
        }
        BitSet visited = new BitSet(n);
        int max = 0;
        for (int i = 0; i < n; i++) {
            visited.clear();

            Platform cur = h[i];
            visited.set(h[i].index);
            int ans = 1;
            while (cur.dest != null) {
                if (visited.get(cur.dest.index)) break;
                cur = cur.dest;
                visited.set(cur.index);
                ans++;
            }
            max = Math.max(ans, max);
        }
        return max;
    }
    private static class Platform implements Comparable<Platform> {
        int index;
        long height;
        Platform dest;
        Platform(int index, long height) {
            this.index = index;
            this.height = height;
        }
        @Override
        public int compareTo(Platform o) {
            return Long.compare(height, o.height);
        }
    }
}
