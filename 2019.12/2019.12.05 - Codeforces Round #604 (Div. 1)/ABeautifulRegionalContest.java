package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class ABeautifulRegionalContest {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            int[] p = new int[n + 1];
            for (int i = 0; i < n; i++) p[i] = in.ints();
            p[n] = -1;
            List<Integer> lens = new ArrayList<>();
            int last = p[0], len = 1, sum = 0;
            for (int i = 1; i <= n; i++) {
                if (p[i] == last) len++;
                else {
                    if (sum + len > n / 2) break;
                    sum += len;
                    lens.add(len);
                    len = 1;
                    last = p[i];
                }
            }
            if (lens.size() < 3) {
                out.ans("0 0 0").ln();
                continue;
            }

            int first = lens.get(0), least = lens.get(lens.size() - 1);
            int cur = lens.size() - 2;
            while (cur >= 0 && first >= least) {
                least += lens.get(cur);
                cur--;
            }
            int mid = sum - first - least;
            if (first >= mid || first >= least) {
                out.ans("0 0 0").ln();
                continue;
            }
            out.ans(first).ans(mid).ans(least).ln();
            //System.out.println(lens);
        }
    }
}
