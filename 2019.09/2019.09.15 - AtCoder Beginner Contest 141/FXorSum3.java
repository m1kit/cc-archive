package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;
import dev.mikit.atcoder.lib.math.linear.BoolMatrix;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.sql.SQLOutput;
import java.util.*;

public class FXorSum3 {

    private static final int BIT = 60;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        int[] cnt = new int[BIT];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < BIT; j++) {
                if ((a[i] & (1L << j)) != 0) cnt[j]++;
            }
        }
        long ans = 0;
        for (int i = 0; i < BIT; i++) {
            if (cnt[i] % 2 == 1) {
                long bit = 1L << i;
                cnt[i] = 0;
                ans |= bit;
                for (int j = 0; j < n; j++) {
                    a[j] &= ~bit;
                }
            }
        }




        int rank = 0;
        for (int col = BIT - 1; col >= 0; col--) {

            int pivot = -1;
            for (int row = rank; row < n; row++) {
                if ((a[row] & (1L << col)) != 0) {
                    pivot = row;
                }
            }
            if (pivot == -1) continue;


            long t = a[pivot];
            a[pivot] = a[rank];
            a[rank] = t;

            for (int row = 0; row < n; row++) {
                if (row != rank && (a[row] & (1L << col)) != 0) {
                    a[row] ^= a[rank];
                }
            }
            rank++;
        }
        long color = 0;
        for (int i = 0; i < n; i++) {
            if (color < (color ^ a[i])) {
                color ^= a[i];
            }
        }

        out.ans(ans + (color << 1)).ln();
    }
}
