package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DSummerVacation {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(in.ints() - 1, in.ints());
        }
        IntroSort.sort(jobs, Comparator.comparing(job -> job.cap));
        PriorityQueue<Job> recruit = new PriorityQueue<>(Comparator.comparing(job -> -job.reward));
        long ans = 0;
        int cur = 0;
        for (int i = 0; i < m; i++) {
            while (cur < n && jobs[cur].cap <= i) {
                recruit.offer(jobs[cur++]);
            }
            if (!recruit.isEmpty()) {
                ans += recruit.poll().reward;
            }
        }
        out.ans(ans).ln();
    }

    private static class Job {
        int cap, reward;

        public Job(int cap, int reward) {
            this.cap = cap;
            this.reward = reward;
        }
    }
}
