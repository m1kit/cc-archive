package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class DMegalomania {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(in.longs(), in.longs());
        }
        IntroSort.sort(tasks, Comparator.comparing(task -> task.b));
        long t = 0;
        for (int i = 0; i < n; i++) {
            t += tasks[i].a;
            if (t > tasks[i].b) {
                out.noln();
                return;
            }
        }
        out.yesln();
    }

    private static class Task {
        long a, b;

        public Task(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }
}
