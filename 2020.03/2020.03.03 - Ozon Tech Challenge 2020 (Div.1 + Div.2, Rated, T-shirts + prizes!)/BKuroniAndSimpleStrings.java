package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BKuroniAndSimpleStrings {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        char[] s = in.string().toCharArray();
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = s.length - 1;
        while (l < r) {
            while (l < r && s[l] == ')') l++;
            while (l < r && s[r] == '(') r--;
            if (l == r) break;
            ans.add(l);
            ans.add(r);
            l++;
            r--;
        }
        ans.sort(Comparator.naturalOrder());
        if (ans.isEmpty()) {
            out.ans(0).ln();
            return;
        }
        out.ans(1).ln().ans(ans.size()).ln();
        for (int x : ans) out.ans(x + 1);
        out.ln();
    }
}
