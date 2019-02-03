package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.sort.MergeSort;
import jp.llv.atcoder.lib.structure.vector.Vec2i;
import jp.llv.atcoder.lib.structure.vector.Vec3i;

import java.util.Comparator;

public class CDivisionAndUnion {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int t = in.ints();
        for (int testCase = 0; testCase < t; testCase++) {
            int n = in.ints();
            Vec3i[] segments = new Vec3i[n];
            for (int i = 0; i < n; i++) {
                segments[i] = new Vec3i(in.ints(), in.ints(), i);
            }
            MergeSort.sort(segments, Comparator.comparing(segment -> segment.x));
            int max = segments[0].y;
            int[] ans = new int[n];
            int tmp = 1;
            ans[segments[0].z] = tmp;
            for (int i = 1; i < n; i++) {
                if (max >= segments[i].x) {
                    max = Math.max(segments[i].y, max);
                } else {
                    tmp = 2;
                }
                ans[segments[i].z] = tmp;
            }
            if (tmp == 1) {
                out.ans(-1).ln();
            } else {
                for (int a : ans) {
                    out.ans(a);
                }
                out.ln();
            }
        }
    }
}
