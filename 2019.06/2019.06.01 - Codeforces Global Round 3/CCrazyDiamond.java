package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CCrazyDiamond {

    private static final int MOD = (int) 1e9 + 7;

    private static void swap(int[] a, int x, int y) {
        int v = a[x];
        a[x] = a[y];
        a[y] = v;
    }

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Array array;
        {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.ints() - 1;
            }
            array = new Array(a);
        }
        List<Swap> ans = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if (array.a[i] == i) continue;

            if (i < n / 2) {
                if (array.idx[i] >= n / 2) {
                    ans.add(array.swap(0, array.idx[i]));
                    ans.add(array.swap(0, n - 1));
                    ans.add(array.swap(i, n - 1));
                } else {
                    ans.add(array.swap(n - 1, array.idx[i]));
                    ans.add(array.swap(n - 1, i));
                }
            } else {
                if (array.idx[i] < n / 2) {
                    ans.add(array.swap(n - 1, array.idx[i]));
                    ans.add(array.swap(n - 1, 0));
                    ans.add(array.swap(0, i));
                } else {
                    ans.add(array.swap(0, array.idx[i]));
                    ans.add(array.swap(0, i));
                }
            }
        }
        if (array.a[0] == n - 1 && array.a[n - 1] == 0) {
            ans.add(array.swap(0, n - 1));
        }

        out.ans(ans.size()).ln();
        //System.out.println(Arrays.toString(a));
        for (Swap swap : ans) {
            out.ans(swap.i + 1).ans(swap.j + 1).ln();
        }
    }

    private static class Array {
        int n;
        int[] a;
        int[] idx;

        Array(int[] a) {
            this.n = a.length / 2;
            this.a = a;
            this.idx = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                idx[a[i]] = i;
            }
        }

        Swap swap(int i, int j) {
            int v = a[i];
            a[i] = a[j];
            a[j] = v;
            idx[a[j]] = j;
            idx[a[i]] = i;
            return new Swap(i, j);
        }


    }

    private static class Swap {
        int i, j;

        public Swap(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
