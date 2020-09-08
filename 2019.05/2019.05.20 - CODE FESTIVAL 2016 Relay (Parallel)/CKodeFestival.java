package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class CKodeFestival {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = 1 << n;
        List<Integer> list = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            list.add(in.ints());
        }
        while (list.size() > 1) {
            List<Integer> next = new ArrayList<>(list.size() / 2);
            for (int i = 0; i < list.size(); i += 2) {
                int a = list.get(i), b = list.get(i + 1);
                if (a == b) {
                    next.add(a);
                } else {
                    next.add(Math.abs(a - b));
                }
            }
            list = next;
        }
        out.ans(list.get(0)).ln();
    }
}
