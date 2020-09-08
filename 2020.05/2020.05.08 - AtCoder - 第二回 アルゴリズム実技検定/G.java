package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayDeque;
import java.util.Queue;

public class G {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        ArrayDeque<Seq> q = new ArrayDeque<>();
        int tests = in.ints();
        for (int test = 0; test < tests; test++) {
            if (in.ints() == 1) {
                q.offerLast(new Seq(in.chr(), in.ints()));
                continue;
            }
            int[] cnt = new int[26];
            int rem = in.ints();
            while (rem > 0 && !q.isEmpty()) {
                Seq s = q.pollFirst();
                if (s.len <= rem) {
                    cnt[s.ch - 'a'] += s.len;
                    rem -= s.len;
                } else {
                    cnt[s.ch - 'a'] += rem;
                    q.offerFirst(new Seq(s.ch, s.len - rem));
                    rem = 0;
                }
            }
            long ans = 0;
            for (int i = 0; i < 26; i++) ans += cnt[i] * (long) cnt[i];
            out.ans(ans).ln();
        }
    }

    private static class Seq {
        char ch;
        int len;

        Seq(char ch, int len) {
            this.ch = ch;
            this.len = len;
        }
    }
}
