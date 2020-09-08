package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BNekoPerformsCatFurrierTransform {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);

        int x = in.ints();
        int n = 0;
        List<Integer> ans = new ArrayList<>();
        outer:
        for (int i = 0; i <= 40; i++) {
            for (int j = 1; j <= 22; j++) {
                if (x == (1 << j) - 1) {
                    break outer;
                }
            }
            n++;
            if (i % 2 == 0) {
                if (x != 0) {
                    int msb = BitMath.msb(x);
                    int v = (1 << (msb + 1)) - 1;
                    ans.add(msb + 1);
                    x ^= v;
                } else {
                    x = 1;
                    ans.add(1);
                }
            } else {
                x++;
            }
        }
        out.ans(n).ln();
        for (int i = 0; i < ans.size(); i++) {
            out.ans(ans.get(i));
        }
        out.ln();
    }
}
