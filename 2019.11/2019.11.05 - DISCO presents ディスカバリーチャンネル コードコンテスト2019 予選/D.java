package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.LongChineseRemainder;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

public class D {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        LongChineseRemainder cr = new LongChineseRemainder();
        int[] mod = new int[31];
        try {
            for (int i = 2; i <= 30; i++) {
                cr.grow((mod[i] = in.ints()) % (i - 1), i - 1);
                if (cr.getRemainder() > 1_000_000_000_000L) {
                    throw new RuntimeException();
                }
            }
            for (int i = 2; i <= 30; i++) {
                long rem = cr.getRemainder();
                int sum = 0;
                while (rem > 0) {
                    sum += rem % i;
                    rem /= i;
                }
                if (sum != mod[i]) throw new RuntimeException();
            }
            out.ans(cr.getRemainder()).ln();
        } catch(RuntimeException _ignored) {
            out.ans("invalid").ln();
        }
    }
}
