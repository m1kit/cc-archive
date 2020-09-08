package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.counting.Permutation;

import java.util.HashSet;
import java.util.stream.IntStream;

public class NewElementsPart1 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints();
            Mol[] mols = new Mol[n];
            for (int i = 0; i < n; i++) {
                mols[i] = new Mol(in.ints(), in.ints());
            }

            Q zero = new Q(0, 1);
            HashSet<Q> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    Q q = new Q(mols[i].c - mols[j].c, mols[i].j - mols[j].j);
                    if (q.q != 0 && q.compareTo(zero) < 0) {
                        set.add(q);
                    }
                }
            }
            out.ans("Case #" + testCase + ":").ans(set.size() + 1).ln();
        }
    }

    private static class Mol {
        int c, j;

        public Mol(int c, int j) {
            this.c = c;
            this.j = j;
        }
    }

    private static class Q implements Comparable<Q> {
        long p, q;

        public Q(int p, int q) {
            if (q == 0) {
                this.p = 1;
                this.q = 0;
            } else if (p == 0) {
                this.p = 0;
                this.q = 1;
            } else {
                if (q < 0) {
                    p = -p;
                    q = -q;
                }
                int gcd = IntMath.gcd(Math.abs(p), q);
                this.p = p / gcd;
                this.q = q / gcd;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Q q1 = (Q) o;

            if (p != q1.p) return false;
            return q == q1.q;

        }

        @Override
        public int hashCode() {
            int result = (int) (p ^ (p >>> 32));
            result = 31 * result + (int) (q ^ (q >>> 32));
            return result;
        }

        @Override
        public int compareTo(Q o) {
            return Long.compare(p * o.q, q * o.p);
        }
    }
}
