package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.HashSet;
import java.util.Set;

public class FDivisionOrSubstraction {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        long n = in.longs();
        Set<Long> ans = new HashSet<>();
        for (long x : IntMath.getAllDivisors(n)) if (isValid(n, x)) ans.add(x);
        for (long x : IntMath.getAllDivisors(n - 1)) if (isValid(n, x)) ans.add(x);
        out.ans(ans.size()).ln();
    }

    private static boolean isValid(long n, long k) {
        if (k == 1) return false;
        while (n % k == 0) n /= k;
        return n % k == 1;
    }
}
