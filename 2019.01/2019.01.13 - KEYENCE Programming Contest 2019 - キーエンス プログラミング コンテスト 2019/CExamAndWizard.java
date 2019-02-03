package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.sort.MergeSort;
import jp.llv.atcoder.lib.structure.vector.Vec2l;

import java.util.Arrays;
import java.util.Comparator;

public class CExamAndWizard {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        long[] a = in.longs(n);
        long[] b = in.longs(n);
        Vec2l[] d = new Vec2l[n];
        for (int i = 0; i < n; i++) {
            d[i] = new Vec2l(i, a[i] - b[i]);
        }
        MergeSort.sort(d, Comparator.comparing(e -> -e.y));
        //System.out.println(Arrays.toString(d));

        int source = 0;
        for (int sink = n - 1; sink >= 0 && d[sink].y < 0; sink--) {
            long borrow = -d[sink].y;
            while (borrow > 0) {
                if (source == n) {
                    out.ans(-1).ln();
                    return;
                }
                if (d[source].y > borrow) {
                    d[source].y -= borrow;
                    break;
                }
                borrow -= d[source].y;
                d[source].y = 0;
                source++;
            }
            d[sink].y = 0;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[(int) d[i].x] - b[(int) d[i].x] != d[i].y) {
                ans++;
            }
        }
        out.ans(ans).ln();
    }
}
