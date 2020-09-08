package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AHungryStudentProblem {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints();
        main: for (int i = 0; i < n; i++) {
            int x = in.ints();
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    if (j * 3 + k * 7 == x) {
                        out.yesln();
                        continue main;
                    }
                }
            }

            out.noln();
        }
    }
}
