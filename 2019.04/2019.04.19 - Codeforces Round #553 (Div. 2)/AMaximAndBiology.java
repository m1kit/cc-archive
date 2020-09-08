package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class AMaximAndBiology {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String s = in.string();
        char[] genomes = {'A', 'C', 'T', 'G'};
        int ans = 1_000_000_000;
        for (int i = 0; i < n - 3; i++) {
            int v = 0;
            for (int j = 0; j < 4; j++) {
                v += dist(s.charAt(i + j), genomes[j]);
            }
            ans = Math.min(ans, v);
        }
        out.ansln(ans);
    }

    private static int dist(char x, char y) {
        return Math.min((x - y + 26) % 26, (y - x + 26) % 26);
    }
}
