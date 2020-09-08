package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CPipes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int queries = in.ints();
        for (int query = 0; query < queries; query++) {
            int n = in.ints();
            char[] r1 = in.string().toCharArray(), r2 = in.string().toCharArray();
            int flow = 0b01;
            for (int i = 0; i < n; i++) {
                boolean c1 = r1[i] <= '2', c2 = r2[i] <= '2';
                if (!c1 || !c2) {
                    if (c1) {
                        flow &= 0b01;
                    } else if (c2) {
                        flow &= 0b10;
                    } else if (flow != 0) {
                        flow ^= 0b11;
                    }
                }
            }
            out.ans(flow == 2).ln();
        }
    }
}
