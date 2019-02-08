package jp.llv.atcoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
public class SimulateBST {
    private static final int MOD = 1_000_000_007;
    private static final int MUL = 100_000;
    public int checksum(int n, int[] Sprefix, int a, int m) {
        class Segment implements Comparable<Segment> {
            private int l, r, d;
            private Segment(int l, int r, int d) {
                 this.l = l;
                this.r = r;
                this.d = d;
            }
            public boolean in(int x) {
                return l <= x && x < r;
            }
            private Segment split(int x) {
                if (x + 1 == r) {
                    d++;r--;
                    return null;
                } else {
                    d++;
                    Segment s = new Segment(x + 1, r, d);
                    r = x;
                    return s;
                }
            }
            @Override
            public int compareTo(Segment o) {
                return l - o.l;
            }
        }

        int p = Sprefix.length;
        TreeSet<Segment> segs = new TreeSet<>();
        segs.add(new Segment(0, m, 0));
        int[] s = new int[n];
        Map<Integer, Integer> depth = new HashMap<>();
        System.arraycopy(Sprefix, 0, s, 0, p);
        Segment search = new Segment(0, 0, 0);
        long ans = 0;
        long mul = 1;
        for (int i = 0; i < n; i++) {
            if (i >= p) {
                long tmp = (a * (long) s[i - p]) % m;
                tmp += depth.get(s[i - 1]) + 1;
                tmp %= m;
                s[i] = (int) tmp;
            }
            if (depth.containsKey(s[i])) {
                int d = depth.get(s[i]);
                ans += (mul * d) % MOD;
                ans %= MOD;
                mul *= MUL;
                mul %= MOD;
                continue;
            }
            search.l = s[i];
            Segment hit = segs.floor(search);
            if (hit == null) throw new RuntimeException();
            depth.put(s[i], hit.d);
            ans += (mul * hit.d) % MOD;ans %= MOD;
            mul *= MUL;mul %= MOD;
            if (hit.l < s[i]) {
                Segment spl = hit.split(s[i]);
                if (spl != null) {
                    segs.add(spl);
                }
            } else {
                segs.remove(hit);
                hit.l++;
                hit.d++;
                segs.add(hit);
            }
        }
        return (int) ans;
    }
}
