package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.math.BitMath;
import dev.mikit.atcoder.lib.math.mod.ModMath;
import dev.mikit.atcoder.lib.util.Reflection;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.function.BinaryOperator;

public class CBeautifulMirrorsWithQueries {

    private static final int MOD = 998244353;
    private static final ModMath mod = new ModMath(MOD);
    private static final long INV100 = mod.inv(100);

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), queries = in.ints();
        long[] p = in.longs(n);
        Transition[] trans = new Transition[n];
        for (int i = 0; i < n; i++) {
            long inv = mod.inv(p[i] * INV100 % MOD);
            trans[i] = new Transition(inv, inv);
        }
        SegmentTree st = new SegmentTree(
                trans,
                (x, y) -> {
                    if (x.zero) return y;
                    if (y.zero) return x;
                    return new Transition(x.a * y.a % MOD, (x.b * y.a + y.b) % MOD);
                });
        //System.out.println(st.query(0, 1));
        //System.out.println(Arrays.toString(trans));
        TreeSet<Integer> checkpoints = new TreeSet<>();
        checkpoints.add(0);
        checkpoints.add(n);
        long ans = st.query(0, n).calc();
        for (int query = 0; query < queries; query++) {
            int x = in.ints() - 1;
            int before = checkpoints.lower(x), after = checkpoints.higher(x);
            long first = st.query(before, x).calc(), second = st.query(x, after).calc(), all = st.query(before, after).calc();
            if (checkpoints.contains(x)) {
                checkpoints.remove(x);
                ans += MOD - first + MOD - second + all;
            } else {
                checkpoints.add(x);
                ans += first + second + MOD - all;
            }
            ans %= MOD;
            //System.out.printf("[%d, %d, %d) : (%d, %d, %d)\n", before, x, after, first, second, all);
            out.ans(ans).ln();
        }
    }

    private static class Transition {
        long a, b;
        boolean zero;

        private static Transition ZERO = new Transition();

        Transition(long a, long b) {
            this.a = a;
            this.b = b;
        }

        Transition() {
            zero = true;
        }

        long calc() {
            return b;
        }

        @Override
        public String toString() {
            return "Transition{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    static class SegmentTree {

        private final int n;
        private final int m;
        private final Transition[] tree;
        private final BinaryOperator<Transition> op; // 区間の併合
        private static final Transition ZERO = Transition.ZERO;


        public SegmentTree(Transition[] array, BinaryOperator<Transition> op) {
            this.n = array.length;
            int msb = BitMath.extractMsb(n);
            this.m = n == msb ? msb : (msb << 1);
            this.tree = Reflection.newInstance(Reflection.getComponentClass(array), 2 * m - 1);
            this.op = op;
            Arrays.fill(tree, ZERO);
            System.arraycopy(array, 0, this.tree, m - 1, array.length);
            for (int i = m - 2; i >= 0; i--) {
                tree[i] = op.apply(tree[2 * i + 1], tree[2 * i + 2]);
            }
        }

        public Transition get(int i) {
            return tree[m + i - 1];
        }


        public Transition query(int l, int r) {
            Transition left = ZERO, right = ZERO;
            l += m - 1;
            r += m - 1;
            while (l < r) {
                if ((l & 1) == 0) {
                    left = op.apply(left, tree[l]);
                }
                if ((r & 1) == 0) {
                    right = op.apply(tree[r - 1], right);
                }
                l = l / 2;
                r = (r - 1) / 2;
            }
            return op.apply(left, right);
        }
    }
}
