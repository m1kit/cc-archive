package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class CCampReception {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Participant[] participants = new Participant[n];
        for (int i = 0; i < n; i++) {
            participants[i] = new Participant(in.ints(), in.ints());
        }
        IntroSort.sort(participants, Comparator.comparing(p -> p.in));
        int last = participants[0].in;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (last < participants[i].in) ans++;
            last = Math.max(last, participants[i].out);
        }
        out.ans(ans).ln();
    }
    
    private static class Participant {
        int in, out;

        public Participant(int in, int out) {
            this.in = in;
            this.out = out;
        }
    }
}
