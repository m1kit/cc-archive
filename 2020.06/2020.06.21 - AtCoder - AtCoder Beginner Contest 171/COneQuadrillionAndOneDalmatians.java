package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class COneQuadrillionAndOneDalmatians {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long n = in.longs();
        StringBuilder name = new StringBuilder();
        while (n > 26) {
            name.append((char) ('a' + ((n + 25) % 26)));
            n /= 26;
        }
        name.append((char) (n - 1 + 'a'));
        out.ans(name.reverse()).ln();
    }
}
