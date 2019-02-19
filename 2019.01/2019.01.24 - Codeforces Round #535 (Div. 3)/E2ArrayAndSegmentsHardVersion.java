package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.IntMath;
import jp.llv.atcoder.lib.geo.Vec2i;
import jp.llv.atcoder.lib.geo.Vec3i;
import jp.llv.atcoder.lib.structure.IntSegmentTree;
import jp.llv.atcoder.lib.sort.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class E2ArrayAndSegmentsHardVersion {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints(), m = in.ints();
        long[] a = in.longs(n);

        if (m == 0) {
            out.ans(IntMath.max(a) - IntMath.min(a)).ln()
                    .ans(0).ln();
            return;
        } else if (n == 1) {
            out.ans(0).ln()
                    .ans(0).ln();
            return;
        }

        Vec3i[] segs = new Vec3i[m];
        for (int i = 0; i < m; i++) {
            segs[i] = new Vec3i(in.ints() - 1, in.ints() - 1, i + 1);
        }

        MergeSort.sort(segs, Comparator.comparing(seg -> seg.y));
        long[] lb = a.clone();
        long t = Integer.MAX_VALUE;
        long[] minLeft = new long[n];
        minLeft[0] = t;
        int c = 0;
        for (int i = 1; i < n; i++) {
            t = Math.min(t, a[i - 1]);
            while (c < m && segs[c].y < i) {
                for (int j = segs[c].x; j <= segs[c].y; j++) {
                    lb[j]--;
                    t = Math.min(t, lb[j]);
                }
                c++;
            }
            minLeft[i] = t;
        }


        MergeSort.sort(segs, Comparator.comparing(seg -> -seg.x));
        lb = a.clone();
        t = Integer.MAX_VALUE;
        long[] minRight = new long[n];
        minRight[n - 1] = t;
        c = 0;
        for (int i = n - 2; i >= 0; i--) {
            t = Math.min(t, a[i + 1]);
            while (c < m && segs[c].x > i) {
                for (int j = segs[c].x; j <= segs[c].y; j++) {
                    lb[j]--;
                    t = Math.min(t, lb[j]);
                }
                c++;
            }
            minRight[i] = t;
        }

        //System.out.println(Arrays.toString(minLeft));
        //System.out.println(Arrays.toString(minRight));

        long ans = -1;
        long ansi = -1;
        for (int i = 0; i < n; i++) {
            long ta = a[i] - Math.min(minLeft[i], minRight[i]);
            if (ta > ans) {
                ans = ta;
                ansi = i;
            }
        }

        //System.out.println("ANIS="+ansi);

        List<Vec3i> res = new ArrayList<>();
        for (Vec3i seg : segs) {
            if (seg.y < ansi || ansi < seg.x) {
                res.add(seg);
            }
        }
        out.ans(ans).ln().ans(res.size()).ln();
        for (Vec3i seg : res) {
            out.ans(seg.z);
        }
        out.ln();
    }
}
