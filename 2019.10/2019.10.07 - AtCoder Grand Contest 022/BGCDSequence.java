package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BGCDSequence {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        if (n == 3) {
            out.ans(2).ans(5).ans(63).ln();
            return;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 30000; i++) {
            if (i % 2 == 0 || i % 3 == 0) nums.add(i);
        }
        while (true) {
            Collections.shuffle(nums);
            int gcd = nums.get(0);
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums.get(i);
                gcd = IntMath.gcd(gcd, nums.get(i));
            }
            if (sum % 6 == 0 && gcd == 1) break;
        }

        for (int i = 0; i < n; i++) {
            out.ans(nums.get(i));
        }
        out.ln();
    }
}
