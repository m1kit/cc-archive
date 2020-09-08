package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BAtCoder {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[][] r = new int[3][100010];
        int[] acc = new int[100010];
        Participant[] participants = new Participant[n];
        for (int i = 0; i < n; i++) {
            participants[i] = new Participant(in.ints(), in.ints() - 1);
            acc[participants[i].rate]++;
            r[participants[i].hand][participants[i].rate]++;
        }
        for (int i = 1; i < 100010; i++) acc[i] += acc[i - 1];
        for (int i = 0; i < n; i++) {
            out.ans(acc[participants[i].rate - 1] + r[(participants[i].hand + 1) % 3][participants[i].rate])
                    .ans(n - acc[participants[i].rate] + r[(participants[i].hand + 2) % 3][participants[i].rate])
                    .ans(r[participants[i].hand][participants[i].rate] - 1).ln();
        }
    }

    private static class Participant {
        int hand, rate;

        public Participant(int rate, int hand) {
            this.hand = hand;
            this.rate = rate;
        }
    }
}
