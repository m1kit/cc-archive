package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ABoboniuChatsWithDu {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), d = in.ints();
        long m = in.longs();
        long[] a = in.longs(n);
        IntroSort.sort(a);
        int cnt = 0;
        for (int i = 0; i < n; i++) if (a[i] > m) cnt++;

        long[] acc1 = new long[cnt + 1];
        long[] acc2 = new long[n - cnt + 1];
        for (int i = 0; i < cnt; i++) acc1[i + 1] = acc1[i] + a[n - i - 1];
        for (int i = 0; i < n - cnt; i++) acc2[i + 1] = acc2[i] + a[n - cnt - i - 1];
        long ans = 0;
        for (int i = 0; i <= cnt; i++) {
            int sac = Math.max(i - 1, 0) * d;
            if (sac > n - i) break;
            int sac2 = Math.max(0, sac - (cnt - i));
            //System.out.println("n"+n+" i:"+i+" sac:"+sac+" sac2:"+sac2);
            ans = Math.max(ans, acc1[i] + acc2[n - cnt - sac2]);
        }
        out.ans(ans).ln();
    }
}
