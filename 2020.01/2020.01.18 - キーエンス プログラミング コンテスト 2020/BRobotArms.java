package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BRobotArms {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), ans = 0;
        Robot[] robots = new Robot[n];
        for (int i = 0; i < n; i++) robots[i] = new Robot(in.ints(), in.ints());
        PriorityQueue<Robot> q = new PriorityQueue<>(Comparator.comparing(Robot::r));
        q.addAll(Arrays.asList(robots));
        long x = Long.MIN_VALUE;
        while (!q.isEmpty()) {
            while (!q.isEmpty() && q.peek().l() < x) q.poll();
            if (q.isEmpty()) break;
            x = q.poll().r();
            ans++;
        }
        out.ans(ans).ln();
    }

    private static class Robot {
        long x, l;

        public Robot(long x, long l) {
            this.x = x;
            this.l = l;
        }

        long l() {
            return x - l;
        }

        long r() {
            return x + l;
        }
    }
}
