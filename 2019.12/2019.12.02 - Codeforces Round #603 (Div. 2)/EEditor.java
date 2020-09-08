package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.math.BitMath;

import java.util.Arrays;
import java.util.function.LongBinaryOperator;

public class EEditor {

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        char[] s = in.string().toCharArray();
        //int lower = 0, higher = 1_000_000;
        int lower = Integer.MAX_VALUE, higher = Integer.MIN_VALUE;
        {
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == 'L') index = Math.max(0, index - 1);
                else if (s[i] == 'R') index++;
                else {
                    lower = Math.min(lower, index);
                    higher = Math.max(higher, index);
                }
            }
            if (lower == Integer.MAX_VALUE) lower = higher = 0;
        }

        MaxLazySegmentTree max = new MaxLazySegmentTree(new long[higher - lower + 1], Integer.MIN_VALUE);
        MinLazySegmentTree min = new MinLazySegmentTree(new long[higher - lower + 1], Integer.MAX_VALUE);
        int cur = -lower, width = higher - lower + 1;
        char[] text = new char[higher - lower + 1];
        long last = 0, depth = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'L') cur = Math.max(-lower, cur - 1);
            else if (s[i] == 'R') cur++;
            else if (s[i] != text[cur]) {
                int delta = 0;
                if (text[cur] == '(') delta--;
                else if (text[cur] == ')') delta++;
                text[cur] = s[i];
                if (s[i] == '(') delta++;
                else if (s[i] == ')') delta--;
                if (delta != 0) {
                    depth += delta;
                    max.update(cur, width, delta);
                    min.update(cur, width, delta);
                    if (depth != 0 || min.query(0, width) < 0) last = -1;
                    else last = max.query(0, width);
                }
            }
            out.ans(last);
        }
        out.ln();
    }

    private static class MaxLazySegmentTree {

        private final int m;
        private final long[] tree, lazy;
        private final long zero;
        private static final long nop = 0;

        public MaxLazySegmentTree(long[] array, long zero) {
            int n = array.length;
            int msb = BitMath.extractMsb(n);
            this.m = n == msb ? msb : (msb << 1);
            this.zero = zero;
            this.tree = new long[m * 2 - 1];
            Arrays.fill(tree, zero);
            System.arraycopy(array, 0, this.tree, m - 1, array.length);
            this.lazy = new long[m * 2 - 1];
            Arrays.fill(lazy, nop);
            for (int i = m - 2; i >= 0; i--) {
                tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
            }
        }

        private void eval(int len, int k) {
            if (lazy[k] == nop) {
                return;
            } else if (k * 2 + 1 < m * 2 - 1) {
                lazy[k * 2 + 1] += lazy[k];
                lazy[k * 2 + 2] += lazy[k];
            }
            tree[k] += lazy[k];
            lazy[k] = nop;
        }

        public void update(int i, long v) {
            i += m - 1;
            eval(1, i);
            tree[i] += v;
            while (i > 0) {
                i = (i - 1) / 2;
                tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
            }
        }

        private long update(int l, int r, long q, int k, int sl, int sr) {
            if (r <= sl || sr <= l) {
                eval(sr - sl, k);
                return tree[k];
            }
            if (l <= sl && sr <= r) {
                lazy[k] += q;
                eval(sr - sl, k);
                return tree[k];
            } else {
                eval(sr - sl, k);
                return tree[k] = Math.max(
                        update(l, r, q, k * 2 + 1, sl, (sl + sr) / 2),
                        update(l, r, q, k * 2 + 2, (sl + sr) / 2, sr)
                );
            }
        }

        public void update(int l, int r, long q) {
            update(l, r, q, 0, 0, m);
        }

        private long query(int l, int r, int k, int sl, int sr) {
            if (r <= sl || sr <= l) {
                return zero;
            }
            eval(sr - sl, k);
            if (l <= sl && sr <= r) {
                return tree[k];
            } else {
                long left = query(l, r, 2 * k + 1, sl, (sl + sr) / 2);
                long right = query(l, r, 2 * k + 2, (sl + sr) / 2, sr);
                return Math.max(left, right);
            }
        }

        public long query(int l, int r) {
            return query(l, r, 0, 0, m);
        }
    }

    private static class MinLazySegmentTree {

        private final int m;
        private final long[] tree, lazy;
        private final long zero;
        private static final long nop = 0;

        public MinLazySegmentTree(long[] array, long zero) {
            int n = array.length;
            int msb = BitMath.extractMsb(n);
            this.m = n == msb ? msb : (msb << 1);
            this.zero = zero;
            this.tree = new long[m * 2 - 1];
            Arrays.fill(tree, zero);
            System.arraycopy(array, 0, this.tree, m - 1, array.length);
            this.lazy = new long[m * 2 - 1];
            Arrays.fill(lazy, nop);
            for (int i = m - 2; i >= 0; i--) {
                tree[i] = Math.min(tree[2 * i + 1], tree[2 * i + 2]);
            }
        }

        private void eval(int len, int k) {
            if (lazy[k] == nop) {
                return;
            } else if (k * 2 + 1 < m * 2 - 1) {
                lazy[k * 2 + 1] += lazy[k];
                lazy[k * 2 + 2] += lazy[k];
            }
            tree[k] += lazy[k];
            lazy[k] = nop;
        }

        public void update(int i, long v) {
            i += m - 1;
            eval(1, i);
            tree[i] += v;
            while (i > 0) {
                i = (i - 1) / 2;
                tree[i] = Math.min(tree[2 * i + 1], tree[2 * i + 2]);
            }
        }

        private long update(int l, int r, long q, int k, int sl, int sr) {
            if (r <= sl || sr <= l) {
                eval(sr - sl, k);
                return tree[k];
            }
            if (l <= sl && sr <= r) {
                lazy[k] += q;
                eval(sr - sl, k);
                return tree[k];
            } else {
                eval(sr - sl, k);
                return tree[k] = Math.min(
                        update(l, r, q, k * 2 + 1, sl, (sl + sr) / 2),
                        update(l, r, q, k * 2 + 2, (sl + sr) / 2, sr)
                );
            }
        }

        public void update(int l, int r, long q) {
            update(l, r, q, 0, 0, m);
        }

        private long query(int l, int r, int k, int sl, int sr) {
            if (r <= sl || sr <= l) {
                return zero;
            }
            eval(sr - sl, k);
            if (l <= sl && sr <= r) {
                return tree[k];
            } else {
                long left = query(l, r, 2 * k + 1, sl, (sl + sr) / 2);
                long right = query(l, r, 2 * k + 2, (sl + sr) / 2, sr);
                return Math.min(left, right);
            }
        }

        public long query(int l, int r) {
            return query(l, r, 0, 0, m);
        }
    }
}
