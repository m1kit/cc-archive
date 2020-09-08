package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class G1IntoBlocksEasyVersion {

    private static final int MAX = 200000;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), unused = in.ints();
        int[] a = in.ints(n);
        int[] min = new int[MAX], max = new int[MAX], cnt = new int[MAX];
        for (int i = 0; i < n; i++) {
            a[i]--;
            if (cnt[a[i]] == 0) min[a[i]] = i;
            max[a[i]] = i;
            cnt[a[i]]++;
        }
        int ans = 0;
        int pos = 0;
        while (pos < n) {
            int majority = cnt[a[pos]];
            ans += max[a[pos]] - min[a[pos]] + 1;
            int i = pos;
            pos = max[a[pos]] + 1;
            for (; i < pos; i++) {
                if (max[a[i]] >= pos) {
                    ans += max[a[i]] - pos + 1;
                    pos = max[a[i]] + 1;
                }
                majority = Math.max(majority, cnt[a[i]]);
            }
            ans -= majority;
        }
        out.ans(ans).ln();
    }
}
