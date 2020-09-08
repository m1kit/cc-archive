package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.seqence.InvNum;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class No1209XORIntoYou {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints();
        long[] as = in.longs(n), bs = in.longs(n), a = new long[n - 1], b = new long[n - 1];
        if (as[0] != bs[0] || as[n - 1] != bs[n - 1]) {
            out.ans(-1).ln();
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            a[i] = as[i] ^ as[i + 1];
            b[i] = bs[i] ^ bs[i + 1];
        }
        Map<Long, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            if (!map.containsKey(b[i])) map.put(b[i], new ArrayDeque<>());
            map.get(b[i]).offer(i);
        }
        int[] p = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            Queue<Integer> q = map.get(a[i]);
            if (q == null || q.isEmpty()) {
                out.ans(-1).ln();
                return;
            }
            p[i] = q.poll();
        }
        out.ans(InvNum.calcPerm(p)).ln();
        //out.ans(-1).ln();
    }
}
