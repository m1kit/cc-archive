package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DMenagerie {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        String s = in.string();
        boolean[] animals = new boolean[n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                animals[0] = i == 1;
                animals[1] = j == 1;
                for (int k = 0; k < n; k++) {
                    animals[(k + 2) % n] = (s.charAt((k + 1) % n) == 'o') == animals[k];
                    if (!animals[(k + 1) % n]) {//wolf
                        animals[(k + 2) % n] = !animals[(k + 2) % n];
                    }
                }
                if (animals[0] == (i == 1) && animals[1] == (j == 1)) {
                    for (int k = 0; k < n; k++) {
                        out.print(animals[k] ? 'S' : 'W');
                    }
                    out.ln();
                    return;
                }
            }
        }
        out.ansln(-1);
    }

}
