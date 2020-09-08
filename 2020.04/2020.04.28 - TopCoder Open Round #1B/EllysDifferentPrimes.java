package dev.mikit.atcoder;

import java.util.*;

public class EllysDifferentPrimes {
    private static final int R = 10_000_000;
    public int getClosest(int n) {
        int l = Math.max(2, n - R), r = n + R;
        int[] table = makeTable(l, r);
        int ans = 2;
        for (int i = l; i < r; i++) if (table[i - l] != 0 && Math.abs(n - i) < Math.abs(n - ans) && isValid(i)) ans = i;
        return ans;
    }

    static boolean isValid(int x) {
        int f = 0;
        while (x > 0) {
            int d = x % 10;
            x /= 10;
            if (((f >> d) & 1) == 1) return false;
            f |= 1 << d;
        }
        return true;
    }

    static int[] makeTable(int l, int h) {
        int n = 10_101;
        List<Integer> list = new ArrayList<>();
        int[] divisor = new int[n];
        for (int i = 2; i < n; i++) {
            if (divisor[i] != 0) continue;
            divisor[i] = i;
            list.add(i);
            for (int j = i + i; j < n; j += i) {
                if (divisor[j] == 0) divisor[j] = i;
            }
        }

        int[] p = list.stream().mapToInt(x -> x).toArray();
        int[] table = new int[h - l];
        for (int i = l; i < h; i++) table[i - l] = i;
        for (int i = 0, j; p[i] * p[i] < h; ++i) { // O( \sqrt(H) )
            if (p[i] >= l) j = p[i] * p[i];
            else if (l % p[i] == 0) j = l;
            else j = l - (l % p[i]) + p[i];
            for (; j < h; j += p[i]) table[j - l] = 0;
        }
        return table;
    }
}
