package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CFactory {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        PriorityQueue<Machine> q = new PriorityQueue<>(Comparator.comparing(ma -> ma.power));
        for (int i = 0; i < n; i++) {
           q.offer( new Machine(in.longs(), in.longs()));
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            Machine ma = q.poll();
            ans += ma.power;
            ma.power += ma.speed;
            q.offer(ma);
        }
        out.ansln(ans);
    }

    private static class Machine {
        long power;
        long speed;

        public Machine(long power, long speed) {
            this.power = power;
            this.speed = speed;
        }
    }
}
