package jp.llv.atcoder;

import jp.llv.atcoder.lib.ModMath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.PrintWriter;

public class CIntervalGame {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Per[] l = new Per[n];
        Per[] r = new Per[n];
        int li = 0, ri = 0;
        boolean[] u = new boolean[n];
        for (int i = 0; i < n; i++) {
            Per p = new Per(in.nextInt(), in.nextInt());
            l[i] = p;
            r[i] = p;
        }
        Arrays.sort(l, Comparator.comparing(p -> -p.l));
        Arrays.sort(r, Comparator.comparing(p -> p.r));
        int takahashi = 0;
        long d = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(takahashi);
            Per pr;
            while ((pr = l[li]).used) {
                li++;
            }
            int dr = pr.dist(i);
            Per pl;
            while ((pl = r[ri]).used) {
                ri++;
            }
            int dl = pl.dist(i);
            if (dr >= dl) {
                pr.used = true;
                if (dr != 0) {
                    d += pr.l - takahashi;
                    takahashi = pr.l;
                }
            } else {
                pl.used = true;
                d += takahashi - pl.r;
                takahashi = pl.r;
            }
        }
        System.out.println(takahashi);
        d += Math.abs(takahashi);
        out.println(d);
    }

    static class Per {
        int l, r;
        boolean used = false;

        Per(int l, int r) {
            this.l = l;
            this.r = r;
        }

        int dist(int i) {
            if (i < l) {
                return l - i;
            } else if (r < i) {
                return i - r;
            } else {
                return 0;
            }
        }
    }
}
