package jp.llv.atcoder;

import jp.llv.atcoder.lib.geo.GeoWalker;
import jp.llv.atcoder.lib.geo.Vec2i;
import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.IntMath;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class B10Puzzle {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    private static int h, w;
    private static int[][] b;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        h = in.ints();
        w = in.ints();
        b = in.ints(h, w);

        boolean allzero = true;
        boolean anyfive = false;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (b[i][j] == 5) {
                    anyfive = true;
                }
                if (b[i][j] != 0) {
                    allzero = false;
                }
            }
        }
        if (allzero) {
            out.ansln("Yes 0");
            return;
        } else if (!anyfive) {
            out.ansln("No");
            return;
        }

        if (h == 1 && w == 1) {
            out.ansln("Yes 1");
            return;
        }

        if (h == 1 || w == 1) {
            int[] d = new int[Math.max(h, w)];
            if (h == 1) {
                for (int i = 0; i < w; i++) {
                    d[i] = b[0][i];
                }
            } else {
                for (int i = 0; i < h; i++) {
                    d[i] = b[i][0];
                }
            }

            int n = d.length;
            int[] maxl = new int[n], maxr = new int[n];
            for (int i = 0; i < n; i++) {
                maxl[i] = Math.max(maxl[Math.max(0, i - 1)], d[i]);
            }
            for (int i = n - 1; i >= 0; i--) {
                maxr[i] = Math.max(maxr[Math.min(n - 1, i + 1)], d[i]);
            }
            int ans = Integer.MAX_VALUE;
            if (d[0] == 5) {
                ans = Math.min(ans, f(maxr[1]));
            }
            if (d[n - 1] == 5) {
                ans = Math.min(ans, f(maxl[n - 2]));
            }
            for (int i = 1; i < n - 1; i++) {
                if (d[i] == 5) {
                    ans = Math.min(ans, f(maxl[i - 1]) + f(maxr[i + 1]));
                }
            }
            ans++;
            out.ans("Yes").ans(ans).ln();
            return;
        }

        int max = 0;
        for (int i = 0; i < h; i++) {
            max = Math.max(max, IntMath.max(b[i]));
        }
        int ans = f(max) + 1;
        out.ans("Yes").ans(ans).ln();
    }

    private static int f(int m) {
        int ans;
        switch (m) {
            case 5:
                ans = 0;
                break;
            case 6:
                ans = 1;
                break;
            case 7:
                ans = 1;
                break;
            case 8:
                ans = 2;
                break;
            case 9:
                ans = 3;
                break;
            default:
                ans = 0;
        }
        return ans;
    }
}
