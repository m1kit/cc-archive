package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.ArrayList;
import java.util.List;

public class Aspirations {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.POSSIBLE_IMPOSSIBLE_ALL_DOWN);
        long l = in.ints(), r = in.ints(), d = in.ints();
        r = r / d * d;
        List<Long> li = new ArrayList<>();
        for (; l <= r; r -= d) {
            li.add(r);
        }
        if (li.isEmpty()) {
            out.noln();
            return;
        }
        long gcd = li.get(0);
        for (int i = 1; i < li.size(); i++) {
            gcd = IntMath.gcd(gcd, li.get(i));
        }
        if (gcd != d) {
            out.noln();
            return;
        }
        out.ans(li.size()).ln();
        for (int i = li.size() - 1; i >=0; i--) {
            out.ans(li.get(i));
        }
        out.ln();
    }
}
