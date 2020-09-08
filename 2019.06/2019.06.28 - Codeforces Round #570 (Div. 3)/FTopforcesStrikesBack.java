package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.*;
import java.util.stream.IntStream;

public class FTopforcesStrikesBack {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        List<Integer> res = new ArrayList<>();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            int[] a = IntStream.range(0, n).map(idx -> in.ints()).distinct().toArray();
            n = a.length;
            IntroSort.sort(a);

            long ans = a[n - 1];
            if (n > 1) {
                for (int k : new int[]{n - 1, n - 2}) {
                    res.clear();
                    res.add(a[k]);
                    for (int i = k - 1; i >= 0; i--) {
                        final int index = i;
                        if (res.size() < 3 && res.stream().noneMatch(x -> x % a[index] == 0)) {
                            res.add(a[i]);
                        }
                    }
                    ans = Math.max(ans, res.stream().mapToInt(x -> x).sum());
                }
            }
            out.ans(ans).ln();
        }
    }
}
