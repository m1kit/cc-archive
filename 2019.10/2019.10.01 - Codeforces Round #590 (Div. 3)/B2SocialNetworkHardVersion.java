package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class B2SocialNetworkHardVersion {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        Set<Integer> s = new HashSet<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int x = in.ints();
            if (s.contains(x)) continue;
            if (q.size() == k)  s.remove(q.pollLast());
            q.offerFirst(x);
            s.add(x);
        }
        out.ans(q.size()).ln();
        for (int i : q) {
            out.ans(i);
        }
        out.ln();
    }
}
