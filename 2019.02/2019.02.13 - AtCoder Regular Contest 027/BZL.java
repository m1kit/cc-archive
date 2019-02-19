package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.BitMath;
import jp.llv.atcoder.lib.structure.UnionFind;

import java.util.Arrays;

public class BZL {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        String s = in.string(), t = in.string();

        boolean[] app = new boolean[26];
        for (int i = 0; i < n; i++) {
            if (isVar(s.charAt(i))) app[s.charAt(i) - 'A'] = true;
            if (isVar(t.charAt(i))) app[t.charAt(i) - 'A'] = true;
        }


        int[] pos  = new int[26];
        Arrays.fill(pos, 0b11111_11111);
        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < n; i++) {
            if (isVar(s.charAt(i)) && isVar(t.charAt(i))) {
                int g1 = uf.find(s.charAt(i) - 'A'), g2 = uf.find(t.charAt(i) - 'A');
                uf.union(g1, g2);
                pos[uf.find(g1)] = pos[g1] & pos[g2];
                if (i == 0) {
                    pos[uf.find(g1)] &= 0b11111_11110;
                }
            } else if (isVar(s.charAt(i))) {
                pos[uf.find(s.charAt(i) - 'A')] &= 1 << (t.charAt(i) - '0');
            } else if (isVar(t.charAt(i))) {
                pos[uf.find(t.charAt(i) - 'A')] &= 1 << (s.charAt(i) - '0');
            }
        }

        long ans = 1;
        for (int i = 0; i < 26; i++) {
            if (uf.find(i) != i || !app[i]) {
                continue;
            }
            //System.out.println(((char) ('A' + i)) + ": " + BitMath.count(pos[i]));
            ans *= BitMath.count(pos[i]);
        }
        out.ans(ans).ln();
    }

    static boolean isVar(char c) {
        return 'A' <= c && c <= 'Z';
    }
}
