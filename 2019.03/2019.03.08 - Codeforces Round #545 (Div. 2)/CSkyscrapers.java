package jp.llv.atcoder;

import jp.llv.atcoder.lib.geo.Vec2i;
import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class CSkyscrapers {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        int[][] a = in.ints(n, m);
        int[] cs = new int[m], ce = new int[n];
        int[][] s = new int[n][m], e = new int[n][m];

        Vec2i[] vs = new Vec2i[n];
        for (int i = 0; i < n; i++) {
            vs[i] = new Vec2i(0, 0);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vs[j].x = j;
                vs[j].y = a[j][i];
            }
            IntroSort.sort(vs, Comparator.comparing(v -> v.y));
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j != 0 && vs[j - 1].y != vs[j].y) {
                    c++;
                }
                s[vs[j].x][i] = c;
            }
            cs[i] = c + 1;
        }

        vs = new Vec2i[m];
        for (int i = 0; i < m; i++) {
            vs[i] = new Vec2i(0, 0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vs[j].x = j;
                vs[j].y = a[i][j];
            }
            IntroSort.sort(vs, Comparator.comparing(v -> v.y));
            int c = 0;
            for (int j = 0; j < m; j++) {
                if (j != 0 && vs[j - 1].y != vs[j].y) {
                    c++;
                }
                e[i][vs[j].x] = c;
            }
            ce[i] = c + 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int lo = Math.max(s[i][j], e[i][j]);
                int hi = Math.max(cs[j] - s[i][j] - 1, ce[i] - e[i][j] - 1);

                out.ans(lo + hi + 1);
            }
            out.ln();
        }
    }
}
