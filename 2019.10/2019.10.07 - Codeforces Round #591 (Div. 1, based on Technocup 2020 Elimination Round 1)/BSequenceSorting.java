package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.segmenttree.IntLazySegmentTree;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.*;

public class BSequenceSorting {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            int[] min = new int[n + 1], max = new int[n + 1];
            Arrays.fill(min, -1);
            Arrays.fill(max, -1);

            int[] a = in.ints(n);
            for (int i = 0; i < n; i++) {
                if (min[a[i]] == -1) min[a[i]] = i;
                max[a[i]] = i;
            }

            List<Segment> segments = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (min[i] == -1) continue;
                segments.add(new Segment(i, min[i], max[i]));
            }

            int red = 0;
            int cur = 0, cnt = 0;
            for (Segment segment : segments) {
                if (cur > segment.left) {
                    cnt = 0;
                }
                red = Math.max(red, ++cnt);
                cur = segment.right;
            }
            out.ans(segments.size() - red).ln();
        }
    }

    private static class Segment {
        int value, left, right;

        Segment(int value, int left, int right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
