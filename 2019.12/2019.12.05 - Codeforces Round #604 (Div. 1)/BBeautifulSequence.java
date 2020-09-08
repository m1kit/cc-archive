package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class BBeautifulSequence {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int[] a = in.ints(4);
        for (int i = 0; i < 4; i++) {
            List<Integer> ans = solve(a.clone(), i);
            if (ans == null) continue;
            out.yesln();
            for (int x : ans) out.ans(x);
            out.ln();
            return;
        }
        out.noln();
    }

    private static List<Integer> solve(int[] a, int now) {
        if (a[now] == 0) return null;
        List<Integer> ans = new ArrayList<>();
        a[now]--;
        ans.add(now);

        boolean ok = true;
        outer:
        while (a[0] > 0 || a[1] > 0 || a[2] > 0 || a[3] > 0) {
            switch (now) {
                case 0:
                    if (a[1] == 0) break outer;
                    a[1]--;
                    now = 1;
                    break;
                case 3:
                    if (a[2] == 0) break outer;
                    a[2]--;
                    now = 2;
                    break;
                case 1:
                    if (a[0] > 0) {
                        a[0]--;
                        now = 0;
                    } else if (a[2] > 0) {
                        a[2]--;
                        now = 2;
                    } else break outer;
                    break;
                case 2:
                    if (a[1] > 0) {
                        a[1]--;
                        now = 1;
                    } else if (a[3] > 0) {
                        a[3]--;
                        now = 3;
                    } else break outer;
                    break;
            }
            ans.add(now);
        }
        if (a[0] != 0 || a[1] != 0 || a[2] != 0 || a[3] != 0) ok = false;
        //System.out.println(ans);
        return ok ? ans : null;
    }
}
