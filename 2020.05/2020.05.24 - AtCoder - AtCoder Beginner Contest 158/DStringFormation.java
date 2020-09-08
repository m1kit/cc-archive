package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DStringFormation {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        StringBuilder middle = new StringBuilder(in.string()), front = new StringBuilder(), back = new StringBuilder();
        int queries = in.ints(), rev = 0;
        for (int query = 0; query < queries; query++) {
            if (in.ints() == 1) rev ^= 1;
            else  {
                if ((in.ints() == 1) == (rev == 0)) front.append(in.chr());
                else back.append(in.chr());
            }
        }
        front.reverse().append(middle).append(back);
        if (rev == 1) front.reverse();
        out.ans(front).ln();
    }
}
