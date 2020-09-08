package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class EWhiteAndBlue {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), p = in.ints();
        Member[] members = new Member[n];
        long b = 0;
        for (int i = 0; i < n; i++) {
            members[i] = new Member(in.ints(), in.ints());
            b += p * members[i].b;
        }
        IntroSort.sort(members, Comparator.comparing(m -> -m.c(p)));
        int ans = 0;
        while (b > 0) {
            b -= members[ans].c(p);
            ans++;
        }
        out.ans(ans).ln();
    }

    private static class Member {
        final long w, b;
        Member(long w, long b) {
            this.w = w;
            this.b = b;
        }

        private long c(long p) {
            return (100 - p) * w + p * b;
        }
    }
}
