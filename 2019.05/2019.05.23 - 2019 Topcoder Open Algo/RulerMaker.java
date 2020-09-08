package dev.mikit.atcoder;

import java.util.HashSet;

public class RulerMaker {
    private static final int OFFSET = 250_000;

    public int[] placeStickers(int n) {
        int g = (n + 1) / 2;
        int[] ans = new int[n];
        for (int i = 0; i < g; i++) {
            ans[i] = OFFSET + i;
        }
        for (int i = 0; i < n - g; i++) {
            ans[i + g] = OFFSET - (i + 1) * g;
        }
        return ans;
    }
}
