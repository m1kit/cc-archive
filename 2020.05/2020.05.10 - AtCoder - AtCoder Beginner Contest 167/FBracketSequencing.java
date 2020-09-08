package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FBracketSequencing {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), total = 0;
        Seq[] seqs = new Seq[n];
        for (int i = 0; i < n; i++) {
            int d = 0, r = 0;
            char[] s = in.chars();
            for (int j = 0; j < s.length; j++) {
                if (s[j] == '(') d++;
                else d--;
                r = Math.max(r, -d);
            }
            seqs[i] = new Seq(d, r);
            total += d;
        }
        if (total != 0) {
            out.noln();
            return;
        }

        PriorityQueue<Seq> ng = new PriorityQueue<>(Comparator.comparing(seq -> seq.r));
        PriorityQueue<Seq> ok = new PriorityQueue<>(Comparator.comparing(seq -> -seq.d));
        ng.addAll(Arrays.asList(seqs));

        // expand
        {
            int now = 0;
            boolean cont = true;
            while (cont) {
                cont = false;
                while (!ng.isEmpty() && ng.peek().r <= now) ok.offer(ng.poll());
                while (!ok.isEmpty() && ok.peek().d >= 0) {
                    Seq used = ok.poll();
                    now += used.d;
                    cont = true;
                }
            }
            if (!ng.isEmpty()) {
                out.noln();
                return;
            }
        }

        // remove
        {
            int now = 0;
            PriorityQueue<Seq> re = new PriorityQueue<>(Comparator.comparing(seq -> seq.r + seq.d));
            re.addAll(ok);
            while (!re.isEmpty()) {
                Seq used = re.poll();
                if (now < used.r + used.d) {
                    out.noln();
                    return;
                }
                now -= used.d;
            }
        }
        out.yesln();
    }

    private static class Seq {
        int d, r;

        Seq(int d, int r) {
            this.d = d;
            this.r = r;
        }

        @Override
        public String toString() {
            return "Seq{" +
                    "d=" + d +
                    ", r=" + r +
                    '}';
        }
    }
}
