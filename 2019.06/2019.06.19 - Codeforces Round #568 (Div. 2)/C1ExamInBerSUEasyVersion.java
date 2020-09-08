package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Comparator;
import java.util.PriorityQueue;

public class C1ExamInBerSUEasyVersion {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long m = in.longs();

        PriorityQueue<Long> pass = new PriorityQueue<>(Comparator.reverseOrder()), fail = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long t = in.longs();
            while (sum + t > m) {
                long v = pass.poll();
                sum -= v;
                fail.offer(v);
            }
            while (!pass.isEmpty() && !fail.isEmpty() && pass.peek() > fail.peek()) {
                long a = pass.poll(), b = fail.poll();
                sum -= a;
                sum += b;
                pass.offer(b);
                fail.offer(a);
            }
            sum += t;
            pass.offer(t);
            while (!fail.isEmpty() && sum + fail.peek() <= m) {
                long v = fail.poll();
                sum += v;
                pass.offer(v);
            }
            out.ans(fail.size());
        }
        out.ln();
    }
}
